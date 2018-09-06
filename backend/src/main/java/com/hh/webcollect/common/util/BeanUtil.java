package com.hh.webcollect.common.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.hh.webcollect.common.exception.WcException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/6
 */
public class BeanUtil {

    private BeanUtil() {

    }

    /**
     * 拷贝对象
     * @param source
     * @param target
     * @param ignoreSourceNullField   是否忽略source上的null字段
     */
    public static void copyBean(Object source,
                                Object target,
                                boolean ignoreSourceNullField) {

        String[] sourceNullPropertyNames = null;
        if (ignoreSourceNullField) {
            sourceNullPropertyNames = getSourceNullPropertyNames(source);
        }
        try {
            BeanUtils.copyProperties(source, target, sourceNullPropertyNames);
        } catch (Exception e) {
            throw new WcException("拷贝对象异常", e);
        }
    }

    /**
     * 拷贝对象
     * @param source
     * @param target
     */
    public static void copyBean(Object source,
                                Object target) {
        copyBean(source, target, false);
    }

    /**
     * 拷贝对象
     * @param source
     * @param targetClass
     * @return
     */
    public static <T> T copyBean(Object source,
                                 Class<T> targetClass) {
        return copyBean(source, targetClass, false);
    }

    /**
     * 拷贝对象
     * @param source
     * @param targetClass
     * @param ignoreSourceNullField	是否忽略source上的null字段
     * @return
     */
    public static <T> T copyBean(Object source,
                                 Class<T> targetClass, boolean ignoreSourceNullField) {
        T target;
        try {
            target = targetClass.newInstance();
            String[] sourceNullPropertyNames = null;
            if (ignoreSourceNullField) {
                sourceNullPropertyNames = getSourceNullPropertyNames(source);
            }
            BeanUtils.copyProperties(source, target, sourceNullPropertyNames);
        } catch (Exception e) {
            throw new WcException("拷贝对象异常", e);
        }
        return target;
    }

    /**
     * 拷贝对象列表
     * @param dataList 待拷贝列表
     * @param clazz 目标类型
     * @param ignoreSourceNullField 是否忽略source上的null字段
     * @return
     */
    public static <T> List<T> copyList(List<?> dataList,
                                       Class<T> clazz,
                                       boolean ignoreSourceNullField) {
        List<T> newList = Lists.newArrayList();
        if (CollectionUtils.isEmpty(dataList)) {
            return newList;
        }
        try {
            for (Object data : dataList) {
                T target = clazz.newInstance();
                String[] sourceNullPropertyNames = null;
                if (ignoreSourceNullField) {
                    sourceNullPropertyNames = getSourceNullPropertyNames(data);
                }
                BeanUtils.copyProperties(data, target, sourceNullPropertyNames);
                newList.add(target);
            }
        } catch (Exception e) {
            throw new WcException("bean list 转换异常", e);
        }
        return newList;
    }

    /**
     * 拷贝对象列表
     * @param dataList 待拷贝列表
     * @param clazz 目标类型
     * @return
     */
    public static <T> List<T> copyList(List<?> dataList,
                                       Class<T> clazz) {
        return copyList(dataList, clazz, false);
    }

    private static String[] getSourceNullPropertyNames(Object source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> nullValueFieldNames = Sets.newHashSet();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (null == srcValue) {
                nullValueFieldNames.add(pd.getName());
            }
        }
        String[] result = new String[nullValueFieldNames.size()];
        return nullValueFieldNames.toArray(result);
    }

}
