package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.Goods;
import com.jk.model.Luser;
import com.jk.model.Television;
import com.jk.model.TvVersion;
import com.jk.service.FrontService;
import com.jk.util.CheckImgUtil;
import com.jk.util.CheckSumBuilder;
import com.jk.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("front")
public class FrontController {

    @Reference
    private FrontService frontService;

    @Autowired
    private RedisTemplate redisTemplate;



    //前台注册
    @RequestMapping("register")

    public String register(){
        return "html/qiantai/register";
    }


    //注册查重
    @RequestMapping("checkUsername")
    @ResponseBody
    public String loginUser(Luser user, String code, HttpServletRequest request,String username){

        //短信验证码
	/*	String realcode = request.getSession().getAttribute("ckcode").toString();
		System.out.println(realcode);
		if(!realcode.equals(code)) {

			return "codeError";
		}*/
        System.out.println(username);
        Luser luser = frontService.register(username);

        if(luser != null){
            return "userError";
        }

        return "success";
    }

    //注册
    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(Luser user,String code,HttpServletRequest request){
       System.out.println(user.getUsername());

        //图片
        String realcode = request.getSession().getAttribute("checkcode").toString();
        //System.out.println(realcode);
        if(!realcode.toLowerCase().equals(code.toLowerCase())) {

            return "codeError";
        }

        frontService.addUser(user);

        return "success";
    }


    @RequestMapping("getCode")
    @ResponseBody
    public void getcode(String tel,HttpServletRequest request) throws Exception{
        System.out.println(tel);

        //短信验证码

    	String url = "https://api.netease.im/sms/sendcode.action";

		String appkey = "a4afd456bc8cf461833108c680e15c5f";

		String curTime = String.valueOf(Calendar.getInstance().getTimeInMillis()/1000);

		String nonce = UUID.randomUUID().toString().replace("-","");

		String checkSum = CheckSumBuilder.getCheckSum("3ca5c205a153",nonce,curTime);

		//设置hander 参数

		HashMap<String, Object> headers = new HashMap<>();

		headers.put("Appkey", appkey);
		headers.put("Nonce", nonce);
		headers.put("CurTime", curTime);
		headers.put("CheckSum", checkSum);

		HashMap<String, Object>  params = new HashMap<>();

		params.put("mobile", tel);
		params.put("templateid", "14801329");

		String str = HttpClientUtil.post(url, params, headers);
		JSONObject jsonObject = JSONObject.parseObject(str);

		String code = jsonObject.getString("code");
		System.out.println(code);
		if("200".equals(code)) {
			String aa = jsonObject.getString("obj");
			request.getSession().setAttribute("ckcode", aa);
			System.out.println(aa);
		}

        //图片验证码

    }





    @RequestMapping("pxiangQing")
    public String mi8(Integer id){
        return "html/qiantai/pxiangQing";
    }

    @RequestMapping("tvVersion")
    @ResponseBody
    public List<TvVersion> tvVersion(){

        List<TvVersion> list = frontService.tvVersion();

        return list;
    }

    @RequestMapping("txiangQing")
    public String tv(Integer tid,Model model){

        Television tv = frontService.querytvxiangQing(tid);

        model.addAttribute("list",tv);

        return "html/qiantai/txiangQing";
    }

    @RequestMapping("queryPhone1")
    @ResponseBody
    public List<Goods> queryPhone1(Model model){

        List<Goods> list = new ArrayList<>();
        String key = "phone";
        if (redisTemplate.hasKey(key)){

            list = (List<Goods>) redisTemplate.opsForValue().get(key);

        }else {
            list = frontService.queryPhone1();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }

    @RequestMapping("queryPhone2")
    @ResponseBody
    public List<Goods> queryPhone2(Model model){
        List<Goods> list = new ArrayList<>();
        String key = "phone2";
        if (redisTemplate.hasKey(key)){

            list = (List<Goods>) redisTemplate.opsForValue().get(key);

        }else {
            list = frontService.queryPhone2();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }

    @RequestMapping("queryPhone3")
    @ResponseBody
    public List<Goods> queryPhone3(Model model){
        List<Goods> list = new ArrayList<>();
        String key = "phone3";
        if (redisTemplate.hasKey(key)){

            list = (List<Goods>) redisTemplate.opsForValue().get(key);

        }else {
            list = frontService.queryPhone3();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }


    @RequestMapping("queryTv1")
    @ResponseBody
    public List<Television> queryTv1(Model model){

        List<Television> list = new ArrayList<>();
        String key = "Tv1";
        if (redisTemplate.hasKey(key)){

            list = (List<Television>) redisTemplate.opsForValue().get(key);

        }else {
            list = frontService.queryTv1();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }

    @RequestMapping("queryTv2")
    @ResponseBody
    public List<Television> queryTv2(Model model){

        List<Television> list = new ArrayList<>();
        String key = "Tv2";
        if (redisTemplate.hasKey(key)){

            list = (List<Television>) redisTemplate.opsForValue().get(key);

        }else {
            list = frontService.queryTv2();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }

    @RequestMapping("queryTv3")
    @ResponseBody
    public List<Television> queryTv3(Model model){

        List<Television> list = new ArrayList<>();
        String key = "Tv3";
        if (redisTemplate.hasKey(key)){

            list = (List<Television>) redisTemplate.opsForValue().get(key);

        }else {
            list = frontService.queryTv3();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }


/*    @RequestMapping("addTv")
    @ResponseBody
    public void addTv(String id,String name){

    }*/



}
