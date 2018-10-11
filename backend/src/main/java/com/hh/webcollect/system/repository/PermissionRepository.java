package com.hh.webcollect.system.repository;

import com.hh.webcollect.common.repository.BaseRepository;
import com.hh.webcollect.system.model.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long> {

    /**
     * findByIsDelete
     *
     * @param isDelete
     * @return List<Permission>
     */
    List<Permission> findByIsDelete(Boolean isDelete);

}
