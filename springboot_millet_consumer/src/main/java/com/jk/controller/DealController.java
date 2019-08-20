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
import com.jk.model.Logistics;
import com.jk.model.Order;
import com.jk.model.Refund;
import com.jk.model.User;
import com.jk.service.DealService;
import com.jk.util.DataGridResult;
import com.jk.util.ExportExcel;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("queryUser")
    @ResponseBody
    public DataGridResult queryUser(@RequestBody ParameUtil param,Integer id){
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryUser(param,id);

        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;

    }
    //订单
    @RequestMapping("queryOrder")
    @ResponseBody
    public DataGridResult queryOrder(@RequestBody ParameUtil param,Integer id){
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryOrder(param,id);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

   @RequestMapping("queryLogistics")
 @ResponseBody
    public DataGridResult queryLogistics(@RequestBody ParameUtil param,Integer id){
       DataGridResult result = new DataGridResult();
       PageUtil pageUtil = DealService.queryLogistics(param,id);
       result.setRows(pageUtil.getList());
       result.setTotal(pageUtil.getSumSize());
       return result;
    }


    //交易退款
    @RequestMapping("queryRefund")
    @ResponseBody
    public DataGridResult queryRefund(@RequestBody ParameUtil param){
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryRefund(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    //同意
    @RequestMapping("updateUp")
    @ResponseBody
    public void updateUp( Integer id){
        DealService.updateUp(id);
    }

    //拒绝
    @RequestMapping("updateDown")
    @ResponseBody
    public void updateDown( Integer id){
        DealService.updateDown(id);
    }
    //评论
    @RequestMapping("queryComment")
    @ResponseBody
    public DataGridResult queryComment(@RequestBody ParameUtil param){
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryComment(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    //导出

    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response, Integer page, Integer rows, String name,ParameUtil param){
        //导出的excel的标题
        String title = "1902B管理";
        //导出excel的列名
        String[] rowName = {"退款编号","订单号/商品","订单金额","退款金额","发货状态","退款方式","原因","申请时间","退款状态"};
        //导出的excel数据
        List<Object[]>  dataList = new ArrayList<Object[]>();
        //查询的数据库的书籍信息


        List<Refund> list=DealService.queryRefund2();

        //循环书籍信息
        for(Refund refund:list){
            Object[] obj =new Object[rowName.length];

                obj[0]=refund.getRefundId();


                obj[1]=refund.getGoodsName();
            obj[2]=refund.getRealityMoney();
            obj[3]=refund.getRefundMoney();

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
            } else if(refund.getRefundInfo() == 2) {
                obj[6] = "未按约定时间发货";
            } else if(refund.getRefundInfo() == 3) {
                obj[6] = "包装/商品破损";
            } else if(refund.getRefundInfo() == 4) {
                obj[6] = "快递/物流无跟踪记录";
            } else if(refund.getRefundInfo() == 5) {
                obj[6] = "退运费";
            } else if(refund.getRefundInfo() == 6) {
                obj[6] = "物破损已拒签";
            } else if(refund.getRefundInfo() == 7) {
                obj[6] = "快递/物流一直未送到";
            }
            obj[7]=refund.getRefundTime();

            if (refund.getRefundrecord() == 1) {
                obj[8] = "退款成功";
            } else if (refund.getRefundrecord() == 2){
                obj[8] = "已拒绝退款";
            }else if (refund.getRefundrecord() == 3){
                obj[8] = "退款待处理";
            }else if (refund.getRefundrecord() == 4){
                obj[8] = "待买家发货";
            }else if (refund.getRefundrecord() == 5){
                obj[8] = "退款关闭";
            }

            dataList.add(obj);
        }
        ExportExcel exportExcel =new ExportExcel(title,rowName,dataList,response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //queryDd  订单
    @RequestMapping("queryDd")
    @ResponseBody
    public DataGridResult queryDd(@RequestBody ParameUtil param){

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryDd2")
    @ResponseBody
    public DataGridResult queryDd2(@RequestBody ParameUtil param){

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd2(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }
    @RequestMapping("queryDd3")
    @ResponseBody
    public DataGridResult queryDd3(@RequestBody ParameUtil param){

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd3(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }
    @RequestMapping("queryDd4")
    @ResponseBody
    public DataGridResult queryDd4(@RequestBody ParameUtil param){

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd4(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }
    @RequestMapping("queryDd5")
    @ResponseBody
    public DataGridResult queryDd5(@RequestBody ParameUtil param){

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd5(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }
    @RequestMapping("queryDd6")
    @ResponseBody
    public DataGridResult queryDd6(@RequestBody ParameUtil param){

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd6(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }
    @RequestMapping("queryDd7")
    @ResponseBody
    public DataGridResult queryDd7(@RequestBody ParameUtil param){

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = DealService.queryDd7(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }
}