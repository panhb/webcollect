package com.hh.webcollect.common.service;

import com.hh.webcollect.common.model.BaseBO;
import com.hh.webcollect.common.model.BaseEntity;
import com.hh.webcollect.common.repository.BaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 *
 * 非实体对应的service不能继承BaseServiceImpl,
 * 只能以BaseServiceImpl<entity, bo>的形式继承
 */
public class BaseServiceImpl<T extends BaseEntity, S extends BaseBO> implements BaseService<T, S> {

    @Autowired
    private BaseRepository<T, Long> baseRepository;

    @Override
    public T findById(Long id) {
        return baseRepository.findById(id).get();
    }

    @Override
    public S findById(Long id, Class<S> sClass) {
        T t = baseRepository.findById(id).get();
        S s = null;
        try {
            s = sClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(t, s);
        return s;
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public T save(T t) {
        return baseRepository.saveWithDate(t);
    }

    @Override
    public List<T> save(List<T> list) {
        return baseRepository.saveAllWithDate(list);
    }

    @Override
    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }

    @Override
    public void delete(T t) {
        baseRepository.delete(t);
    }

    @Override
    public void deleteAll() {
        baseRepository.deleteAll();
    }


}
