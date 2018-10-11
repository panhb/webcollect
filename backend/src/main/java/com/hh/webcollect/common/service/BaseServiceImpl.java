package com.hh.webcollect.common.service;

import com.google.common.collect.Lists;
import com.hh.webcollect.common.model.*;
import com.hh.webcollect.common.repository.BaseRepository;
import com.hh.webcollect.common.util.BeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

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
        Optional<T> optional = baseRepository.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        return BeanUtil.copyBean(optional.get(), sClass);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<T> findAll(Example example) {
        return baseRepository.findAll(example);
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

    /**
     * page对象转换
     *
     * @param pageVO
     * @return
     */
    public Pageable getPageable(PageVO pageVO) {
        List<SortVO> sortList = pageVO.getSortList();
        List<Sort.Order> orderList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(sortList)) {
            for (SortVO sort : sortList) {
                Sort.Direction direction;
                if ("asc".equalsIgnoreCase(sort.getType())) {
                    direction = Sort.Direction.ASC;
                }else if ("desc".equalsIgnoreCase(sort.getType())) {
                    direction = Sort.Direction.DESC;
                } else {
                    continue;
                }
                orderList.add(new Sort.Order(direction, sort.getName()));
            }
        }
        return PageRequest.of(pageVO.getPageNum() - 1, pageVO.getPageSize(), Sort.by(orderList));
    }

    /**
     * jpa的page<entity>转pageResult<bo>
     *
     * @param page
     * @param sClass
     * @return
     */
    public PageResult<S> transforPage(final Page<T> page, Class<S> sClass) {
        PageResult<S> pageResult = new PageResult<>();
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setTotalPages(page.getTotalPages());
        if (CollectionUtils.isNotEmpty(page.getContent())) {
            pageResult.setContent(BeanUtil.copyList(page.getContent(), sClass));
        }
        return pageResult;
    }


}
