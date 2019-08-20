package com.jk.mapper;

import com.jk.model.RolePer;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolePerMapper {



    int insert(RolePer record);

    int insertSelective(RolePer record);

    @Select("select perid from role_permission where roleid = #{id}")
    List<String> queryPerById(Integer id);

    @Select("select * from tree")
    List<Tree> queryPerAll();

    @Delete("delete from role_permission where roleid = #{roleid}")
    int deletePerById(Integer roleid);
}