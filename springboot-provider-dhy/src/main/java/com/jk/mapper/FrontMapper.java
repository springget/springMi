package com.jk.mapper;

import com.jk.model.Goods;
import com.jk.model.Pedition;
import com.jk.model.Television;
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
}
