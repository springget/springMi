package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.ShopDao;
import com.jk.model.Area;
import com.jk.model.Shop;

import com.jk.model.longShop;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Service
public class ShopServiceImpl implements ShopService {

   @Autowired
    private ShopDao shopDao;

    @Override
    public List<Area> queryArea(Integer id) {
        return shopDao.queryArea(id);
    }

    @Override
    public Shop queryShop(String name) {
        return shopDao.queryShop(name);
    }

    @Override
    public void addlongShop(longShop longShop) {
        shopDao.addlongShop(longShop);
    }

    @Override
    public void addShop(Shop shop) {

        shopDao.addShop(shop);
}


}