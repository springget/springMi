/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DealController
 * Author:   李辉
 * Date:     2019/8/16 11:49
 * Description: 交易模块
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.*;
import com.jk.service.DealService;
import com.jk.service.ItemService;
import com.jk.util.DataGridResult;
import com.jk.util.ExportExcel;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈交易模块〉
 *
 * @author 李辉
 * @create 2019/8/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("deal")
public class DealController {
    @Reference
    private com.jk.service.DealService DealService;
    @Reference
    private ItemService itemService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("queryUser")
    @ResponseBody
    public DataGridResult queryUser(@RequestBody ParameUtil param, Integer id) {
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryUser(param, id);

        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;

    }

    //订单
    @RequestMapping("queryOrder")
    @ResponseBody
    public DataGridResult queryOrder(@RequestBody ParameUtil param, Integer id) {
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryOrder(param, id);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryLogistics")
    @ResponseBody
    public DataGridResult queryLogistics(@RequestBody ParameUtil param, Integer id) {
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryLogistics(param, id);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }


    //交易退款
    @RequestMapping("queryRefund")
    @ResponseBody
    public DataGridResult queryRefund(@RequestBody ParameUtil param) {
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryRefund(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    //同意
    @RequestMapping("updateUp")
    @ResponseBody
    public void updateUp(Integer id) {
        DealService.updateUp(id);
    }

    //拒绝
    @RequestMapping("updateDown")
    @ResponseBody
    public void updateDown(Integer id) {
        DealService.updateDown(id);
    }

    //评论
    @RequestMapping("queryComment")
    @ResponseBody
    public DataGridResult queryComment(@RequestBody ParameUtil param) {
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryComment(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }


    //导出

    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response, Integer page, Integer rows, String name, ParameUtil param) {
        //导出的excel的标题
        String title = "1902B管理";
        //导出excel的列名
        String[] rowName = {"退款编号", "订单号/商品", "订单金额", "退款金额", "发货状态", "退款方式", "原因", "申请时间", "退款状态"};
        //导出的excel数据
        List<Object[]> dataList = new ArrayList<Object[]>();
        //查询的数据库的书籍信息


        List<Refund> list = DealService.queryRefund2();

        //循环书籍信息
        for (Refund refund : list) {
            Object[] obj = new Object[rowName.length];

            obj[0] = refund.getRefundId();


            obj[1] = refund.getGoodsName();
            obj[2] = refund.getRealityMoney();
            obj[3] = refund.getRefundMoney();

            if (refund.getSendStatus() == 1) {
                obj[4] = "已发货";
            } else {
                obj[4] = "未发货";
            }
            if (refund.getRefundStatus() == 1) {
                obj[5] = "仅退款";
            } else {
                obj[5] = "退货退款";
            }
            if (refund.getRefundInfo() == 1) {
                obj[6] = "不喜欢/不想要";
            } else if (refund.getRefundInfo() == 2) {
                obj[6] = "未按约定时间发货";
            } else if (refund.getRefundInfo() == 3) {
                obj[6] = "包装/商品破损";
            } else if (refund.getRefundInfo() == 4) {
                obj[6] = "快递/物流无跟踪记录";
            } else if (refund.getRefundInfo() == 5) {
                obj[6] = "退运费";
            } else if (refund.getRefundInfo() == 6) {
                obj[6] = "物破损已拒签";
            } else if (refund.getRefundInfo() == 7) {
                obj[6] = "快递/物流一直未送到";
            }
            obj[7] = refund.getRefundTime();

            if (refund.getRefundrecord() == 1) {
                obj[8] = "退款成功";
            } else if (refund.getRefundrecord() == 2) {
                obj[8] = "已拒绝退款";
            } else if (refund.getRefundrecord() == 3) {
                obj[8] = "退款待处理";
            } else if (refund.getRefundrecord() == 4) {
                obj[8] = "待买家发货";
            } else if (refund.getRefundrecord() == 5) {
                obj[8] = "退款关闭";
            }

            dataList.add(obj);
        }
        ExportExcel exportExcel = new ExportExcel(title, rowName, dataList, response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //queryDd  订单
    @RequestMapping("queryDd")
    @ResponseBody
    public DataGridResult queryDd(@RequestBody ParameUtil param) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryDd2")
    @ResponseBody
    public DataGridResult queryDd2(@RequestBody ParameUtil param) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd2(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryDd3")
    @ResponseBody
    public DataGridResult queryDd3(@RequestBody ParameUtil param) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd3(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryDd4")
    @ResponseBody
    public DataGridResult queryDd4(@RequestBody ParameUtil param) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd4(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryDd5")
    @ResponseBody
    public DataGridResult queryDd5(@RequestBody ParameUtil param) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd5(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryDd6")
    @ResponseBody
    public DataGridResult queryDd6(@RequestBody ParameUtil param) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd6(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryDd7")
    @ResponseBody
    public DataGridResult queryDd7(@RequestBody ParameUtil param) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd7(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    //addComment
    @RequestMapping("addComment")
    @ResponseBody
    public void addComment(Comment comment) {
        DealService.addComment(comment);
    }


    @RequestMapping("findOrderListAll")
    @ResponseBody
    public List<GoShop> findOrderListAll(HttpServletRequest request) {
       Luser luser = (Luser) request.getSession().getAttribute("luser");
        return DealService.findOrderListAll(luser.getId());

    }

    @RequestMapping("deleteGood")
    /* @ResponseBody*/
    public String deleteGood(Integer id,HttpServletRequest request) {
        System.out.println(id + "ssss");
        Luser luser = (Luser) request.getSession().getAttribute("luser");
       // luser.getId();
        DealService.deleteGood(id,luser.getId());

        //return  "Redirect:../html/shoppingCart.html";
        return "html/shoppingCart";
    }

    @RequestMapping("add")
    @ResponseBody
    public void add(Integer goodsId,HttpServletRequest request) {
        Query query = new Query();
        List<GoShop> list=mongoTemplate.find(query,GoShop.class, "shop");
        boolean flag = false;
        for (GoShop goods : list) {
            //如果存在数量相加
            if (goods.getGoodsId() == goodsId) {
                flag = true;
                //找到商品，数量相加
               /* goods.goodsNumber(goods.getGoodsPrice()+1);*/

             GoShop shop1 = new GoShop();
              Update update = new Update();
                update.set("goodsId",goodsId);
                update.set("goodsInfo",goods.getGoodsInfo());
                update.set("goodsName",goods.getGoodsName());
                update.set("goodsNumber",goods.getGoodsNumber()+1);
              update.set("goodsPrice",goods.getGoodsPrice());
               Luser luser = (Luser) request.getSession().getAttribute("luser");
                update.set("userId",luser.getId());
                //跳出循环
              Criteria c = new Criteria();
                c.and("goodsId").is(goodsId);
                query.addCriteria(c);
                mongoTemplate.updateFirst(query, update, "shop");
                break;
            }

        }

        if (!flag) {
            Goods goods = itemService.getGoodsById(goodsId);
            GoShop shop1 = new GoShop();
            shop1.setGoodsId(goodsId);
            shop1.setGoodsInfo(goods.getGoodsInfo());
            shop1.setGoodsName(goods.getGoodsName());
            shop1.setGoodsNumber(1);
            shop1.setGoodsPrice(goods.getGoodsPrice());
      Luser luser = (Luser) request.getSession().getAttribute("luser");
        shop1.setUserId(luser.getId());

           GoShop save = mongoTemplate.save(shop1, "shop");


            }

    }

    //update
    @RequestMapping("update")//+
    @ResponseBody
    public void update(Integer id,Integer count, HttpServletRequest request) {
        Update update = new Update();
        update.set("goodsNumber",count+1);
        Query query = new 	Query();
        Criteria c = new Criteria();
        c.and("goodsId").is(id);
        query.addCriteria(c);

        mongoTemplate.updateFirst(query, update,"shop");

    }
    //update2 -
    @RequestMapping("update2")//
    @ResponseBody
    public void update2(Integer id,Integer count, HttpServletRequest request) {
        Update update = new Update();
        update.set("goodsNumber",count);
        Query query = new 	Query();
        Criteria c = new Criteria();
        c.and("goodsId").is(id);
        query.addCriteria(c);

        mongoTemplate.updateFirst(query, update,"shop");

    }
    //order
    @RequestMapping("order")//
    @ResponseBody
    public void order(String id, HttpServletRequest request) {
      /*  String[] split = id.split(",");
        System.out.println(id);
        Criteria criteria = new Criteria();
        criteria.where("goodsId").in(id);
         Luser luser = (Luser) request.getSession().getAttribute("luser");
        criteria.where("userId").is(luser.getId());
        Query query = new Query();
        query.addCriteria(criteria);
        List<GoShop> shopList = mongoTemplate.find(query, GoShop.class, "shop");
        boolean flag = false;
        for (GoShop shop : shopList) {
            for (int i = 0; i < split.length; i++) {
                if (shop.getGoodsId() == Integer.parseInt(split[i])) {
                    flag = true;
                    Update update = new Update();
                    update.set("goodsId", shop.getGoodsId());
                    update.set("goodsInfo", shop.getGoodsInfo());
                    update.set("goodsName", shop.getGoodsName());
                    update.set("goodsNumber", shop.getGoodsNumber() + 1);
                    update.set("goodsPrice", shop.getGoodsPrice());
                    Criteria c2 = new Criteria();
                    c2.and("goodsId").is(Integer.parseInt(split[i]));
                    Query query2 = new Query();
                    query2.addCriteria(c2);
                    mongoTemplate.updateFirst(query2, update, "goShop");
                    break;
                }
            }
            if (!flag) {
                GoShop shop2 = new GoShop();
                shop2.setGoodsId(shop.getGoodsId());
                shop2.setGoodsInfo(shop.getGoodsInfo());
                shop2.setGoodsName(shop.getGoodsName());
                shop2.setGoodsNumber(shop.getGoodsNumber());
                shop2.setGoodsPrice(shop.getGoodsPrice());
                shop2.setUserId(shop.getUserId());
                mongoTemplate.save(shop2, "goShop");
            }

        }
       // mongoTemplate.remove(query,GoShop.class, "shop");*/

        String[] split = id.split(",");
        System.out.println(id);
        Criteria criteria = new Criteria();
        criteria.where("goodsId").in(id);
        Luser luser = (Luser) request.getSession().getAttribute("luser");
        criteria.and("userId").is(1);
        Query query = new Query();
        query.addCriteria(criteria);
        List<GoShop> shopList = mongoTemplate.find(query, GoShop.class, "shop");
        for (GoShop shop : shopList) {
            GoShop shop2 = new GoShop();
            shop2.setGoodsId(shop.getGoodsId());
            shop2.setGoodsInfo(shop.getGoodsInfo());
            shop2.setGoodsName(shop.getGoodsName());
            shop2.setGoodsNumber(shop.getGoodsNumber());
            shop2.setGoodsPrice(shop.getGoodsPrice());
            shop2.setUserId(shop.getUserId());
            mongoTemplate.save(shop2, "goShop");
        }

        mongoTemplate.remove(query,GoShop.class, "shop");
    }


}
