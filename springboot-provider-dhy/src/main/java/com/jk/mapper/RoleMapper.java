package com.jk.mapper;

import com.jk.model.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}