package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Goods;
import com.jk.model.Pedition;

import com.jk.model.Television;
import com.jk.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/front")
public class FrontController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Reference
    private FrontService frontService;


    //財務管理
    @RequestMapping("login")
    public String touserlist() {
        return "html/qiantai/login";
    }

    //查询手机
    @RequestMapping("queryshouji1")
    @ResponseBody
    public List<Goods> queryshouji1(Model model){
        List<Goods> list = new ArrayList<>();
        String key = "ds1";
        if (redisTemplate.hasKey(key)){

            list = (List<Goods>) redisTemplate.opsForValue().get(key);

        }else {
            list = frontService.queryshouji1();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }

    //查询电视
    @RequestMapping("dianshi")
    @ResponseBody
    public List<Television> dianshi(Model model){
        List<Television> list = new ArrayList<>();
        String key = "ds2";
        if (redisTemplate.hasKey(key)){

            list = (List<Television>) redisTemplate.opsForValue().get(key);

        }else {
            list = frontService.dianshi();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }

    //跳转详情
    @RequestMapping("pxiangQing")
    public String mi8(Integer id,Model model){
      Goods goods = frontService.pxiangQing(id);
      model.addAttribute("goods",goods);
      return "html/qiantai/pxiangQing";
    }

    @RequestMapping("queryShouji2")
    @ResponseBody
    public void queryShouji2(Integer id){
        System.out.println(id);
    }

    //查询版本 价格
    @RequestMapping("lickMemory")
    @ResponseBody
    public List<Pedition>  lickMemory(){
        List<Pedition> list = frontService.lickMemory();
        return list;
    }





}
