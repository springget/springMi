package com.jk.mapper;

import com.jk.model.Role;
import com.jk.model.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    @Select("select roleid from user_role where userid = #{id}")
    List<String> queryRoleByid(Integer id);

    @Select("select * from l_role")
    List<Role> queryRoleAll();

    @Delete("delete from user_role where id = #{id}")
    int deleteRole(Integer id);

    @Select("select roleid from user_role where userid = #{id}")
    List<String> queryrolebyid(Integer id);

    @Update("update user_role set roleid=#{ids} where userid=#{id}")
    void updateRole2(@Param("ids") Integer ids, @Param("id") Integer id);
    @Update("update l_role set count = count-1 where id = #{i}")
    void updateRoleCount1(int i);
    @Update("update l_role set count = count+1 where id = #{ids}")
    void updateRoleCount2(Integer ids);
}