package com.jk.mapper;

import com.jk.model.Goods;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface AccountMapper {
@Select("select count(g.goodsId) from t_goods g LEFT JOIN t_order o ON g.orderId=o.goodsId " +
        "        LEFT JOIN t_user u on g.userId=u.goodsId " +
        "        LEFT JOIN t_state s on u.stateId=s.satateId")
    Integer queryaccountcount(HashMap<String, Object> map);
@Select("select g.goodsId as goodsId,g.goodsName as goodsName,o.orderTime AS orderTime, u.userId AS userId, u.userName AS userName,g.goodsPrice AS goodsPrice, s.stateName AS stateName from t_goods g LEFT JOIN t_order o ON g.orderId=o.goodsId " +
        "        LEFT JOIN t_user u on g.userId=u.goodsId " +
        "        LEFT JOIN t_state s on u.stateId=s.satateId " +
        "limit ${start},${end}")
    List<Goods> queryaccount(HashMap<String, Object> map);

    @Select("select o.orderId as orderId,g.goodsName as goodsName,o.orderTime AS orderTime, u.userId AS userId, u.userName AS userName,g.goodsPrice AS goodsPrice, s.stateName AS stateName from t_goods g LEFT JOIN t_order o ON g.orderId=o.goodsId " +
            "LEFT JOIN t_user u on g.userId=u.goodsId " +
            "LEFT JOIN t_state s on u.stateId=s.satateId  where s.satateId =1 " +
            "limit ${start},${end}")
    List<Goods> queryincome(HashMap<String, Object> map);
@Select("select count(*) from t_goods g " +
        "     LEFT JOIN t_order o ON g.orderId=o.goodsId " +
        "     LEFT JOIN t_user u on g.userId=u.goodsId " +
        "     LEFT JOIN t_state s on u.stateId=s.satateId " +
        "     LEFT JOIN t_bank b on o.bankId=b.bankId")
    Integer findincomecount(HashMap<String, Object> map);
@Select("select  g.goodsId as goodsId,g.goodsName as goodsName,o.orderTime AS orderTime, u.userId AS userId, u.userName AS userName,g.goodsPrice AS goodsPrice, s.stateName AS stateName, " +
        "b.discountTime AS discountTime,b.daozhangTime as daozhangTime  from t_goods g " +
        "     LEFT JOIN t_order o ON g.orderId=o.goodsId " +
        "     LEFT JOIN t_user u on g.userId=u.goodsId " +
        "     LEFT JOIN t_state s on u.stateId=s.satateId " +
        "     LEFT JOIN t_bank b on o.bankId=b.bankId ")
    List<Goods> findincome(HashMap<String, Object> map);
@Select("select  g.goodsId AS goodsId,s.stateName AS stateName, g.goodsPrice AS goodsPrice,  b.bankName AS bankName, b.discountTime  AS  discountTime, u.userName AS userName,b.bankcard AS bankcard from t_goods g " +
        "     LEFT JOIN t_order o ON g.orderId=o.goodsId " +
        "     LEFT JOIN t_user u on g.userId=u.goodsId " +
        "     LEFT JOIN t_state s on u.stateId=s.satateId " +
        "     LEFT JOIN t_bank b on o.bankId=b.bankId where  g.goodsId =#{value} ")
    Goods findbrankById(String goodsId);

    @Update("update  t_goods g LEFT JOIN t_order o LEFT JOIN t_user u  LEFT JOIN  t_state s LEFT JOIN  t_bank b set  s.stateName =${stateName}, g.goodsPrice =${goodsPrice},b.bankName=${bankName},b.discountTime=${discountTime},u.userName=${userName} where g.goodsId =#{VALUE}")
    void saveorupdate(Goods goods);

}
