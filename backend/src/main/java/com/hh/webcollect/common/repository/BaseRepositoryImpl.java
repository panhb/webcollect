package com.hh.webcollect.common.repository;

import com.google.common.collect.Lists;
import com.hh.webcollect.common.enums.StatusEnum;
import com.hh.webcollect.common.model.BaseEntity;
import org.apache.commons.collections4.CollectionUtils;
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
        if (entity.getId() == null) {
            entity.setCreateDate(date);
            entity.setIsDelete(false);
            entity.setStatus(StatusEnum.E.getCode());
            this.entityManager.persist(entity);
            return entity;
        } else {
            return this.entityManager.merge(entity);
        }
    }

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
}
