package com.jk.mapper;


import com.jk.model.Goods;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemMapper {




   // Goods selectByPrimaryKey(Integer goodsId);
    @Select("select * from t_goods  g where  g.goodsId =#{goodsId}")
    Goods getGoodsById(Integer goodsId);


 /*   int countByExample(TbItemExample example);

    int deleteByExample(TbItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

   */


  /*  @Select("select * from t_goods  where id = #{id}")*/
/*    TbItem selectByPrimaryKey(Integer id);//

    List<TbItem> selectByExample(TbItemExample example);*/

    /*   List<TbItem> selectByExample(TbItemExample example);*/

    /*int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);*/
}