
package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Goods;
import com.jk.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("page")
public class pageController {

    @Reference
    private GoodsService goodsService;

    //財務管理
    @RequestMapping("tofinance")
    public String touserlist() {
        return "html/lbw/FinanceList";
    }

    //树
 //   @RequestMapping("index")
   // public String index(){
      //  return "html/wh/tree";
//    }

    //商品查询
    @RequestMapping("goodsshow")
    public String goodsshow(){
        return "html/wh/goodsshow";
    }

    //发布商品
    @RequestMapping("addgoods")
    public String addgoods(){
        return "html/wh/addgoods";
    }

    @RequestMapping("edit")
    public ModelAndView edit(Integer id){
        Goods goods = goodsService.findGoodsByid(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/wh/updgoods");
        mv.addObject("goods",goods);
        return mv;
    }
    @RequestMapping("typegoods")
    public String typegoods(){
        return "html/wh/typegoods";
    }


    @RequestMapping("main")
    public String main(){
        return "html/index";
    }








    //订单管理
   /* @RequestMapping("deal")
    public String deal(Integer id) {

        return "html/lih/deal";
    }*/

    @RequestMapping("dd")
    public String dd() {
        return "html/lih/dd";
    }
    //退款管理
    @RequestMapping("refund")
    public String refund() {
        return "html/lih/refund";
    }
    //评论管理
    @RequestMapping("comment")
    public String comment() {
        return "html/lih/comment";
    }


    @RequestMapping("dealXq")
    public ModelAndView dealXq(Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/lih/deal");
        mv.addObject("order",id);
        return mv;
    }




    //岗位角色
    @RequestMapping("togangWei")
    public String toGangwei(){
        return "html/dhy/gangWei";
    }
    //账号管理
    @RequestMapping("tozhangHao")
    public String toZhanghao(){
        return "html/dhy/zhangHao";
    }

    @RequestMapping("clientList")
    public String clientList() {
        return "html/yyw/clientList";
    }


    @RequestMapping("memberList")
    public String memberList() {
        return "html/yyw/memberList";
    }

    //登陆
    @RequestMapping("loginUser")
    public String loginUser(){
        return "html/yyw/loginUser";
    }




    @RequestMapping("updPresented")
    public ModelAndView updPresented(String id){
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/yyw/updPresented");
        mv.addObject("order",id);
        return mv;
    }

    //注册
    @RequestMapping("toregister")
    public String toregister(){
        return "html/yyw/register";
    }
    //树
    @RequestMapping("index")
    public String index(){
        return "html/dhy/index";
    }


    //订单管理
    @RequestMapping("deal")
    public String deal() {
        return "html/lih/deal";
    }




    //店铺管理
    @RequestMapping("toaddshop")
    public String toAddShop(){
        return  "/html/hgj/addShop";
    }
    //店铺认证
    @RequestMapping("addlongShop")
    public String addlongShop(){
        return "html/hgj/addlongShop";
    }



}
