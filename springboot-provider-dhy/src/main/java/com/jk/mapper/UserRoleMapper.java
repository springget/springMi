package com.jk.mapper;

import com.jk.model.Role;
import com.jk.model.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    @Select("select roleid from user_role where userid = #{id}")
    List<String> queryRoleByid(Integer id);

    @Select("select * from l_role")
    List<Role> queryRoleAll();

    @Delete("delete from user_role where id = #{id}")
    int deleteRole(Integer id);

}