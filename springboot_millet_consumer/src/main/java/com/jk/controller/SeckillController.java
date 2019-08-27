package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Goods;
import com.jk.service.GoodsService;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: SeckillController
 * describe:
 *
 * @author wanghang
 * @date 2019/08/21 15:43
 */
@Controller
@RequestMapping("seckill")
public class SeckillController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Reference
    private GoodsService goodsService;

    @RequestMapping("setSeckill")
    @ResponseBody
    public void setSeckill(Integer count,Integer time, HttpServletRequest request){
        Goods goods = (Goods) request.getSession().getAttribute("goods");
        String key = "seckill"+goods.getGoodsId();
        ModelAndView mv = new ModelAndView();
        redisTemplate.opsForValue().set(key,count);
        redisTemplate.expire(key, time, TimeUnit.MINUTES);
    }

    @RequestMapping("getSeckill")
    @ResponseBody
    public String getSeckill(HttpServletRequest request){
        Goods goods = (Goods) request.getSession().getAttribute("goods");
        String key = "seckill"+goods.getGoodsId();
        Long dec = redisTemplate.opsForValue().decrement(key, 1);
        if(dec<=0){
            redisTemplate.delete(key);
        }
        return "1";
    }

    @RequestMapping("querySeckill")
    @ResponseBody
    public List<Goods> querySeckill(HttpServletRequest request){
        List<Goods> list = new ArrayList();
        Goods goods = (Goods) request.getSession().getAttribute("goods");
        String key = "seckill"+goods.getGoodsId();
        if(redisTemplate.hasKey(key)){
            list = (List<Goods>) redisTemplate.opsForValue().get(key);
        }
        return list;
    }


    @RequestMapping("queryHotGoods")
    @ResponseBody
    public List<Goods> queryHotGoods(){

        List<Goods> list = goodsService.queryHotGoods();

        return list;
    }
}
