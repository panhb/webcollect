package com.hh.webcollect.common.service;

import com.hh.webcollect.common.model.BaseBO;
import com.hh.webcollect.common.model.BaseEntity;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
public interface BaseService<T extends BaseEntity, S extends BaseBO> {

    /**
     * 通用主键查询
     *
     * @param id
     * @return entity
     */
    T findById(Long id);

    /**
     * 通用主键查询
     *
     * @param id
     * @return bo
     */
    S findById(Long id, Class<S> sClass);

    /**
     * 查询全部
     *
     * @return
     */
    List<T> findAll();

    /**
     * 条件查询全部
     *
     * @param example
     * @return
     */
    List<T> findAll(Example example);

    /**
     * 保存
     *
     * @param t
     * @return
     */
    T save(T t);

    /**
     * 批量保存
     *
     * @param list
     * @return
     */
    List<T> save(List<T> list);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     * 删除
     *
     * @param t
     */
    void delete(T t);

    /**
     * 删除全部
     */
    void deleteAll();

}
