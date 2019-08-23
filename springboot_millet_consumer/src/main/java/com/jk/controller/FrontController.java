package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Goods;
import com.jk.model.Television;
import com.jk.model.TvVersion;
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
@RequestMapping("front")
public class FrontController {

    @Reference
    private FrontService frontService;

    @Autowired
    private RedisTemplate redisTemplate;

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


    @RequestMapping("addTv")
    @ResponseBody
    public void addTv(){

    }


}
