package com.hh.webcollect.system.repository;

import com.hh.webcollect.common.repository.BaseRepository;
import com.hh.webcollect.system.model.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return User
     */
    User findByUsername(String username);

}
