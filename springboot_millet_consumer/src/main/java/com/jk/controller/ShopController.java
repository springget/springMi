
package com.jk.controller;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Area;
import com.jk.model.Shop;
import com.jk.model.longShop;
import com.jk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("shop")
public class ShopController {
    @Reference
    private ShopService shopService;

//查询地区
    @RequestMapping("queryArea")
    @ResponseBody
    public List<Area> queryArea(Integer id){
        List<Area> findArea = shopService.queryArea(id);
        return findArea;
    }
    //查询店铺名称是否已有
    @RequestMapping("queryShop")
    @ResponseBody
    public String queryShop(String name){
        Shop shop = shopService.queryShop(name);
        if(shop != null){
            return  "1";
        }else {
            return  "2";
        }
    }

//新增店铺
@RequestMapping("addShop")
@ResponseBody
public void addShop(Shop shop){

    shopService.addShop(shop);

}

    //认证店铺
    @RequestMapping("addlongShop")
    @ResponseBody
    public void addlongShop(longShop longShop){
        shopService.addlongShop(longShop);

    }

}
