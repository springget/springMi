/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DealMapper
 * Author:   李辉
 * Date:     2019/8/16 12:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.mapper;

import com.jk.model.*;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 李辉
 * @create 2019/8/16
 * @since 1.0.0
 */
public interface DealMapper {
    List<User> queryUser(ParameUtil param,@Param("id") Integer id);

    List<Order> queryOrder(ParameUtil param,@Param("id") Integer id);

    List<Logistics> queryLogistics(ParameUtil param,@Param("id") Integer id);

    List<Refund> queryRefund(ParameUtil param);

    void updateUp(Integer id);

    void updateDown(Integer id);

    List<Comment> queryComment(ParameUtil param);

    List<Refund> queryRefund2();

    List<Order> queryDd(ParameUtil param);

    List<Order> queryDd2(ParameUtil param);

    List<Order> queryDd3(ParameUtil param);

    List<Order> queryDd4(ParameUtil param);

    List<Order> queryDd5(ParameUtil param);

    List<Order> queryDd6(ParameUtil param);

    List<Order> queryDd7(ParameUtil param);
  /* // @Select("select count(1) from t_user ")
    List<User> queryUser();
 //   @Select("select * from t_user limit #{start},#{end}")
   // Integer queryUserCount(Map map);


    //@Select("select count(1) from t_order o ,t_goods g ,t_logistics  l  where o.orderId=g.goodId  l.logisticId=o.logisticId")
   // Integer queryOrderCount(Map map);
    @Select("select * from t_order o ,t_goods g ,t_logistics  l  where o.orderId=g.goodId  l.logisticId=o.logisticId  limit #{start},#{end}")
    List<Order> queryOrder(Map map);
   // @Select("select * from t_logistics  limit #{start},#{end}")
    List<Logistics> queryLogistics(HashMap map);
    @Select("select count(1) from t_logistics   ")
    Integer queryLogisticsCount(HashMap map);

   Integer queryUserCount();*/
}