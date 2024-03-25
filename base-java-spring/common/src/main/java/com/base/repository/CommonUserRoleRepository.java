package com.base.repository;

import com.base.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommonUserRoleRepository {
    void insertUserRole(@Param("userRole") UserRole userRole);
}
