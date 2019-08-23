package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.jk.model.Payment;
import com.jk.model.Ress;
import com.jk.service.RessService;
import com.jk.util.DataGridResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("ress")
public class RessController {

    @Reference
    private RessService ressService;

//查询地址
    @RequestMapping("queryRess")
    @ResponseBody
    public DataGridResult queryRess(Integer id){
        DataGridResult result = new DataGridResult();
        List<Ress> ress= ressService.queryRess(id);
        result.setRows(ress);

        return result;
    }

//新增地址
@RequestMapping("addRess")
@ResponseBody
    public void addRess(Integer id,Ress ress){
    ressService.addRess(id,ress);
}

//删除地址
    @RequestMapping("deleteOrderUrl")
    @ResponseBody
    public void deleteOrderUrl(String ids) {
        String[] split = ids.split(",");
        for (String id : split) {
            ressService.deleteOrderUrl(id);
        }
    }
    //修改地址
    @RequestMapping("updateOrderUrls")
    @ResponseBody
    public void updateOrderUrls(Ress ress) {

        ressService.updateOrderUrls(ress);

    }


//查询结账商品
    @RequestMapping("findPaymentListAll")
    @ResponseBody
    public DataGridResult findPaymentListAll(){
        DataGridResult result = new DataGridResult();
        List<Payment> payment= ressService.findPaymentListAll();
        result.setRows(payment);
        return result;
    }
//查询总价钱
    @RequestMapping("queryzPrice")
    @ResponseBody
    public Integer queryzPrice(){
        Integer zprice=ressService.queryzPrice();
        return zprice;
    }
//查询总件数
    @RequestMapping("queryzSum")
    @ResponseBody
    public Integer queryzSum(){
        Integer zsum=ressService.queryzSum();
        return zsum;
    }
}