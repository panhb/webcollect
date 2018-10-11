package com.hh.webcollect.system.repository;

import com.hh.webcollect.common.repository.BaseRepository;
import com.hh.webcollect.system.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @param isDelete
     * @return User
     */
    User findByUsernameAndIsDelete(String username, Boolean isDelete);

    /**
     * 根据用户昵称查找用户
     *
     * @param nickname
     * @param isDelete
     * @return User
     */
    User findByNicknameAndIsDelete(String nickname, Boolean isDelete);

    /**
     * 分页条件查询
     *
     * @param specification
     * @param pageable
     * @return
     */
    @Override
    Page<User> findAll(Specification<User> specification, Pageable pageable);
}
