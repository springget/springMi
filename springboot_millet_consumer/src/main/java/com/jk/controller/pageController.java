
package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Comment;
import com.jk.model.Goods;
import com.jk.model.Refund;
import com.jk.service.GoodsService;
import com.jk.service.RessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("page")
public class pageController {

    @Reference
    private GoodsService goodsService;


    @Reference
    private RessService ressService;

    @Reference
    private com.jk.service.DealService DealService;

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

    //查看会员
    @RequestMapping("clientList")
    public String clientList() {
        return "html/yyw/clientList";
    }


    //查看
    @RequestMapping("memberList")
    public String memberList() {
        return "html/yyw/memberList";
    }

    //登陆
    @RequestMapping("loginUser")
    public String loginUser(){
        return "html/yyw/loginUser";
    }



    //修改积分
    @RequestMapping("updPresented")
    public ModelAndView updPresented(String id){
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


    //查询优惠券
    @RequestMapping("addCoupon")
    public String addCoupon() {
        return "html/yyw/addCoupon";

    }
    //订单分析
    @RequestMapping("toAnalyze")
    public String toAnalyze(){
        return "html/hgj/toAnalyze";
    }

    //新增优惠卷
    @RequestMapping("queryCoupon")
    public String queryCoupon() {
        return "html/yyw/queryCoupon";
    }
    //退款审核
        @RequestMapping("toUpdate")
        public ModelAndView toUpdate(Integer id){
            Refund refund = DealService.findRefundByid(id);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("html/lih/check");
            mv.addObject("refund",refund);
            return mv;
        }

//updateComment 回复
        @RequestMapping("updateComment")
        public ModelAndView updateComment(Integer id){
            Comment comment = DealService.findCommentByid(id);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/html/lih/reply");
            mv.addObject("comment",comment);

            return mv;
        }
        //轮播图
        @RequestMapping("sss")
        public String sss() {
            return "html/lih/sss";
        }
        //轮播图
        @RequestMapping("aaa")
        public String aaa() {
            return "html/lih/aaa";
        }




    //秒杀回显
    @RequestMapping("setSeckill")
    public ModelAndView setSeckill(Integer id,HttpServletRequest request){
        Goods goods = goodsService.findGoodsByid(id);
        request.getSession().setAttribute("goods", goods);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("html/wh/seckill");
        mv.addObject("goods",goods);
        return mv;
    }

    // 个人中心
    @RequestMapping("persion")
    public String persion(){
        return "html/wh/persion";
    }

    // 收益明细
    @RequestMapping("highcharts")
    public String highcharts(){
        return "html/wh/highcharts";
    }


 //购物车页面
    @RequestMapping("shoppingCart")
    public String shoppingCart() {
        return "html/shoppingCart";
    }

    //购物车页面
    @RequestMapping("shoppingCart2")
    public String shoppingCart2() {
        return "html/lih/shoppingCart";
    }


    //前往订单
    @RequestMapping("forder")
    public String forder(){
        return "html/hgj/toOrderPay";
    }

    //购物车页面
    @RequestMapping("cart")
    public String cart() {
        return "html/shoppingCart";
    }

    //购物车页面
    @RequestMapping("cart2")
    public String cart2() {
        return "html/lih/cart";
    }


    //订单页面
    @RequestMapping("myOrder")
    public String myOrder() {
        return "html/lih/myOrder";
    }
}
