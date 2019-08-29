/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DealService
 * Author:   李辉
 * Date:     2019/8/16 11:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.model.Comment;
import com.jk.model.GoShop;
import com.jk.model.Order;
import com.jk.model.Refund;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 李辉
 * @create 2019/8/16
 * @since 1.0.0
 */
public interface DealService {


    PageUtil queryUser(ParameUtil param,Integer id);

    PageUtil queryOrder(ParameUtil param,Integer id);

    PageUtil queryLogistics(ParameUtil param,Integer id);

    PageUtil queryRefund(ParameUtil param);

    void updateUp(Integer id);

    void updateDown(Integer id);

    PageUtil queryComment(ParameUtil param);

    List<Refund> queryRefund2();

    PageUtil queryDd(ParameUtil param);

    PageUtil queryDd2(ParameUtil param);

    PageUtil queryDd3(ParameUtil param);

    PageUtil queryDd4(ParameUtil param);

    PageUtil queryDd5(ParameUtil param);

    PageUtil queryDd6(ParameUtil param);

    PageUtil queryDd7(ParameUtil param);

    Refund findRefundByid(Integer id);

    Comment findCommentByid(Integer id);

    void addComment(Comment comment);


 /*   List<GoShop> findOrderListAll(Integer id);*/
 List<GoShop> findOrderListAll(Integer userId);
    void deleteGood(Integer id,Integer userId);
}