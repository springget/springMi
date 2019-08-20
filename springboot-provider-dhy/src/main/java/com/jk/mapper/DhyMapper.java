package com.jk.mapper;

import com.jk.model.Gangwei;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.Zhanghao;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface DhyMapper {

    List<Role> queryRole(Map map);

    List<Zhanghao> queryZhanghao(Map map);

    @Select("select * from t_gangwei where gid = #{id}")
    Gangwei showXiangQing(Integer id);
    @Select("select * from t_zhanghao where id = #{id}")
    Zhanghao showXiangQing2(Integer id);

    @Update("update t_zhanghao set status = 1 where id = #{id}")
    void updateStatus(Integer id);

    @Update("update t_zhanghao set status = 0 where id = #{id}")
    void updateStatus2(Integer id);
@Select(" SELECT sp.* from t_user s ,user_role ur ,l_role sr,role_permission rp,tree sp " +
        " where s.userid = ur.userid " +
        " and ur.roleid = sr.id " +
        " and sr.id = rp.roleid " +
        " and rp.perid = sp.id " +
        " and pid=#{value}  GROUP BY sp.text")
    List<Tree> getTreeAll(Integer id);

    //List<Tree> getTreeAll();


}
