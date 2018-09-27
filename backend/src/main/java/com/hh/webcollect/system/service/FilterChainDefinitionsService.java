package com.hh.webcollect.system.service;

import java.util.Map;

/**
 * @author hongbo.pan
 * @date 2018/9/26
 */
public interface FilterChainDefinitionsService {

    /**
     * 获取权限
     *
     * @return Map<String, String>
     */
    Map<String, String> loadFilterChainDefinitions();
}
