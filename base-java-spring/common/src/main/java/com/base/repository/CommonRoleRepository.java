package com.base.repository;

import com.base.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommonRoleRepository {
    Optional<Role> findByName(String name);

    @Transactional
    List<Role> findAllRoles();

    @Transactional
    List<Role> findAllRolesByUserIds(@Param("userId") String userId);
}
