package com.jk.mapper;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface DhyMapper {

    List<Role> queryRole(Map map);

    List<User> queryZhanghao(Map map);

    @Select("select * from l_role where id = #{id}")
    Role showXiangQing(Integer id);

    User showXiangQing2(Integer id);

    @Update("update t_zhanghao set status = 1 where id = #{id}")
    void updateStatus(Integer id);

    @Update("update t_zhanghao set status = 0 where id = #{id}")
    void updateStatus2(Integer id);

    List<Tree> getTreeAll(Integer userId);

    List<Tree> queryOrgAll2(@Param("id") int id, @Param("pid") int pid);

    List<Tree> queryOrgAll3(@Param("pid") int pid);
}
