package com.base.repository;

import com.base.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;


/**
 *
 * @since 22/03/2022 - 10:27
 */
@Mapper
public interface CommonUserRepository {

    void insertUser(@Param("user") User user);

    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByEmailAndDeletedAtIsNull(@Param("email") String email);

    Optional<User> findByUserIdAndDeletedAtIsNull(@Param("userId") String userId);
}
