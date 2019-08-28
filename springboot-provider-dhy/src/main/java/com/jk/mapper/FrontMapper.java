package com.jk.mapper;

import com.jk.model.Goods;
import com.jk.model.Luser;
import com.jk.model.Luser;
import com.jk.model.Pedition;
import com.jk.model.Television;
import com.jk.model.Television;
import com.jk.model.TvVersion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FrontMapper {
    @Select("select * from t_goods limit 0,8")
    List<Goods> queryshouji1();
    @Select("select * from t_television limit 0,6")
    List<Television> dianshi();
    @Select("select * from t_pedition")
    List<Pedition> lickMemory();
    @Select("select * from  t_goods g,t_allocation a,t_pcolor p where g.allId = a.id and g.colorId = p.pid and g.goodsId = #{id}" )
    Goods pxiangQing(Integer id);
    @Select("select * from l_user where username =#{username}")
    Luser loginLuser(String username);

    @Select("SELECT * from t_goods LIMIT 0,6")
    List<Goods> queryPhone1();
    @Select("SELECT * from t_goods LIMIT 7,6")
    List<Goods> queryPhone2();
    @Select("SELECT * from t_goods LIMIT 12,6")
    List<Goods> queryPhone3();

    @Select("SELECT * from t_television LIMIT 0,6")
    List<Television> queryTv1();
    @Select("SELECT * from t_television LIMIT 7,6")
    List<Television> queryTv2();
    @Select("SELECT * from t_television LIMIT 12,6")
    List<Television> queryTv3();

    @Select("SELECT * from t_television t,tv_version v where t.tvVersion = v.id and t.televId = #{tid}")
    Television querytvxiangQing(Integer tid);

    @Select("select * from tv_version")
    List<TvVersion> tvVersion();

    @Select("select * from l_user where username = #{username}")
    Luser register(String username);

    @Insert("insert into l_user(username,password,name) values(#{username},#{password},#{name})")
    void addUser(Luser user);

    @Select("select * from t_goods t\n" +
            "where t.goodsTime >= date(now())\n" +
            "and t.goodsTime < DATE_ADD(date(now()),INTERVAL 1 DAY) and isseckill = 1 limit 0,4")
    List<Goods> queryMiaosha();
}
