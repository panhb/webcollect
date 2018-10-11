package com.hh.webcollect.common.repository;

import com.google.common.collect.Lists;
import com.hh.webcollect.common.Constant;
import com.hh.webcollect.common.enums.StatusEnum;
import com.hh.webcollect.common.model.BaseEntity;
import com.hh.webcollect.system.model.bo.UserBO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
public class BaseRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>  {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public <S extends BaseEntity> S saveWithDate(S entity) {
        Date date = new Date();
        entity.setModifyDate(date);
        UserBO userBO = getUserInfo();
        if (userBO != null) {
            entity.setModifyUserId(userBO.getId());
            entity.setModifyUserName(userBO.getUsername());
        }
        if (entity.getId() == null) {
            if (userBO != null) {
                entity.setCreateUserId(userBO.getId());
                entity.setCreateUserName(userBO.getUsername());
            }
            entity.setCreateDate(date);
            entity.setIsDelete(false);
            entity.setStatus(StatusEnum.E.getCode());
            this.entityManager.persist(entity);
            return entity;
        } else {
            return this.entityManager.merge(entity);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public <S extends BaseEntity> List<S> saveAllWithDate(List<S> entitys) {
        List<S> list = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(entitys)) {
            for (S entity : entitys) {
                list.add(this.saveWithDate(entity));
            }
        }
        return list;
    }

    private UserBO getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            Session session = subject.getSession();
            if (session != null) {
                return (UserBO) session.getAttribute(Constant.LOGINUSER);
            }
        }
        return null;
    }
}
