package com.hh.webcollect.common.repository;

import com.hh.webcollect.common.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /**
     * 保存并给时间赋值
     *
     * @param entity
     * @return S
     */
    <S extends BaseEntity> S saveWithDate(S entity);

    /**
     * 批量保存并给时间赋值
     *
     * @param entitys
     * @return List<S>
     */
    <S extends BaseEntity> List<S> saveAllWithDate(List<S> entitys);
}
