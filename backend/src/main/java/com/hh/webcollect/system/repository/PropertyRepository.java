package com.hh.webcollect.system.repository;

import com.hh.webcollect.common.repository.BaseRepository;
import com.hh.webcollect.system.model.entity.Property;
import org.springframework.stereotype.Repository;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Repository
public interface PropertyRepository extends BaseRepository<Property, Long> {

}
