package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Coupon;
import com.jk.model.Goods;
import com.jk.model.User;
import com.jk.service.ClientService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Reference
    private ClientService clientService;

    @Autowired
    private SolrClient client;


    @RequestMapping("queryUserList")
    @ResponseBody
    public DataGridResult queryUserList(@RequestBody ParameUtil params) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = clientService.queryUserList(params);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryMemberList")
    @ResponseBody
    public DataGridResult queryMemberList(@RequestBody ParameUtil params) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = clientService.queryMemberList(params);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("updateClient")
    @ResponseBody
    public void updateClient(String aa,String id){
        clientService.updateClient(aa,id);
    }

   /* //获取图片验证码
    @RequestMapping("getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response){

        CheckImgUtil.buildCheckImg(request, response);

    }
*/
    //登陆
    @RequestMapping("loginUser")
	@ResponseBody
	public String login(User user,HttpServletRequest request){

		/*//验证验证码
		//从session中取出验证码
        System.out.println(user.getUserAccount());
		String realCode = request.getSession().getAttribute("checkcode").toString();
		//校验验证码
		if(!realCode.toLowerCase().equals(code.toLowerCase())){

			return "codeError";
		}*/
		//验证账号
		User loginUser = clientService.queryUserName(user.getUserAccount());

		if(loginUser == null){

			return "userError";
		}
        System.out.println(loginUser.getUserPassword());
		//验证密码
		if(!loginUser.getUserPassword().equals(user.getUserPassword())){

			return "pwError";
		}
		//登录成功

		request.getSession().setAttribute("user", loginUser);
		return "success";
	}

	@RequestMapping("updateCancel")
	@ResponseBody
    public void updateCancel(Integer id) {
        clientService.updateCancel(id);
    }


	@RequestMapping("addCoupon")
    @ResponseBody
    public void addCoupon(Coupon coupon){
        clientService.addCoupon(coupon);
    }

    @RequestMapping("queryCoupon")
    @ResponseBody
    public DataGridResult queryCoupon(@RequestBody ParameUtil params) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = clientService.queryCoupon(params);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }
/**
     * 新增/修改 索引
     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
     * @return
     */
   /* @RequestMapping("add")
    @ResponseBody
    public void add() {
       Goods good =  new Goods();
        good.setGoodsName("华为手机");
        good.setGoodsNumber(20);
        good.setGoodsImg("123");
        good.setGoodsPrice(852.8);
        clientService.add(good);
       *//* String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("id", uuid);
            doc.setField("content_ik", goods.getBankName());
            client.add(doc);
            //client.commit();
            client.commit();
            return uuid;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";*//*
    }*/



    @RequestMapping("queryCommodity")
    public String queryCommodity(Integer page, Model model,String goodsName) {
/*//返回的参数map
        Map<String,Object> mSolr = new HashMap<String,Object>();*/
//查询的集合
        List<Goods> comlist=new ArrayList<>();
//查询参数的对象SolrQuery
        SolrQuery params=new SolrQuery();
//判断关键词是否为空
        if(!"".equals(goodsName)&&goodsName!=null){
//不为空时，关键词为前台传递的参数
            params.set("q",goodsName);
        }else{
//为空时查询所有数据
            params.set("q","*:*");
        }
//默认查询的字段
        params.set("df","goodsName");
//默认返回的字段
        params.set("fl","id,goodsName,goodsPrice,goodsImg,goodsNumber,typeId,goodsTime,goodsInfo,sales,commentId,userId,orderId,allId,ishot,isseckill,audit,colorId ");
//设置高亮字段
        params.addHighlightField("goodsName");
        //分页
        if(page==null){
            page=0;
        }
        params.setStart(page);
        params.setRows(100);
        //打开高亮
        params.setHighlight(true);
        //设置前缀
        params.setHighlightSimplePre("<span style='color:red'>");
        //设置后缀
        params.setHighlightSimplePost("</span>");
        try {
            //solr查询返回的对象QueryResponse
            QueryResponse queryResponse= client.query(params);
            //查询返回的真正结果
            SolrDocumentList results=queryResponse.getResults();
/*//查询总条数
            long numFound=results.getNumFound();*/
//高亮显示的内容
            Map<String,Map<String, List<String>>> higlight=queryResponse.getHighlighting();
//循环遍历结果，把查询内容放到list中
            for (SolrDocument res:results){
                Goods goods=new Goods();
                String highname="";
//获得的高亮内容
                Map<String, List<String>> map=higlight.get(res.get("id"));
//获得高亮内容的list
                List<String> list=map.get("goodsName");
                if(list==null){
//如果为空则没有高亮
                    highname=(String)res.get("goodsName");
                }else{
//不为空则有高亮
                    highname=list.get(0);
                }
//把字段放入对象中

                goods.setGoodsId(Integer.parseInt(res.get("id").toString()));
                goods.setGoodsName((String) res.get("goodsName"));
                goods.setGoodsPrice(Double.parseDouble(res.get("goodsPrice").toString()));
                goods.setGoodsImg((String) res.get("goodsImg"));
                goods.setGoodsNumber((Integer) res.get("goodsNumber"));
                goods.setTypeId((Integer) res.get("typeId"));
                goods.setGoodsTime((Date) res.get("goodsTime"));
                goods.setColorId((Integer) res.get("coloId"));
                goods.setGoodsInfo((String) res.get("goodsInfo"));
                goods.setSales((Integer)res.get("sales"));
                goods.setCommentId((Integer) res.get("commentId"));
                goods.setUserId((Integer) res.get("userId"));
                goods.setOrderId((Integer) res.get("orderId"));
                goods.setAllId((Integer) res.get("allId"));
                goods.setIshot((String) res.get("ishot"));
                goods.setIsseckill((String) res.get("isseckill"));
                goods.setAudit((Integer) res.get("audit"));

                comlist.add(goods);
            }
            //把条数和查询结果放到上面的map中
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//把条数和查询结果放到上面的map中
          /*  mSolr.put("total",numFound);
            mSolr.put("rows",comlist);
*/
        //返回map
        model.addAttribute("mSol",comlist);
        return "html/qiantai/tiaocha";
    }

}