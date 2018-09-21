package com.hh.webcollect.system.service.impl;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import com.hh.webcollect.common.Constant;
import com.hh.webcollect.common.model.PageResult;
import com.hh.webcollect.common.service.BaseServiceImpl;
import com.hh.webcollect.common.util.BeanUtil;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.entity.User;
import com.hh.webcollect.system.model.vo.AddUserVO;
import com.hh.webcollect.system.model.vo.QueryUserVO;
import com.hh.webcollect.system.repository.UserRepository;
import com.hh.webcollect.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserBO> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserBO addUser(AddUserVO addUserVO) {
        UserBO userBO = BeanUtil.copyBean(addUserVO, UserBO.class);
        String password = userBO.getPassword();
        password = Hashing.sha256().hashString(
                password + Constant.PASSWORD_SALT, Charsets.UTF_8).toString();
        userBO.setPassword(password);
        User savedUser = save(BeanUtil.copyBean(userBO, User.class));
        return BeanUtil.copyBean(savedUser, UserBO.class);
    }

    @Override
    public UserBO findByUsername(String username) {
        User user = userRepository.findByUsernameAndIsDelete(username, false);
        if (user != null) {
            return BeanUtil.copyBean(user, UserBO.class);
        }
        return null;
    }

    @Override
    public PageResult<UserBO> pageUser(QueryUserVO queryUserVO) {
        Pageable pageable = getPageable(queryUserVO.getPageVO());
        Page<User> userPage = userRepository.findAll(
                (Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
            /**
             * 连接查询条件, 不定参数，可以连接0..N个查询条件
             */
            List<Predicate> predicateList = Lists.newArrayList();
            if (!Strings.isNullOrEmpty(queryUserVO.getUsername())) {
                Path<String> username = root.get("username");
                predicateList.add(cb.like(username,
                        "%" + queryUserVO.getUsername() + "%"));
            }
            if (!Strings.isNullOrEmpty(queryUserVO.getNickname())) {
                Path<String> nickname = root.get("nickname");
                predicateList.add(cb.like(nickname,
                        "%" + queryUserVO.getNickname() + "%"));
            }
            if (!Strings.isNullOrEmpty(queryUserVO.getRemark())) {
                Path<String> remark = root.get("remark");
                predicateList.add(cb.like(remark,
                        "%" + queryUserVO.getRemark() + "%"));
            }
            Predicate[] predicates = new Predicate[predicateList.size()];
            predicateList.toArray(predicates);
            cq.where(predicates);
            return null;
        }, pageable);
        return transforPage(userPage, UserBO.class);
    }
}
