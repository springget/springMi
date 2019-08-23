package com.jk.mapper;

import com.jk.model.Goods;
import com.jk.model.Television;
import com.jk.model.TvVersion;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FrontMapper {

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
}
