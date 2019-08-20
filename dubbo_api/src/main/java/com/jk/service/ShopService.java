package com.jk.service;

;

import com.jk.model.Area;
import com.jk.model.Shop;
import com.jk.model.longShop;

import java.util.List;

public interface ShopService {


    void addShop(Shop shop);

    List<Area> queryArea(Integer id);

    Shop queryShop(String name);

    void addlongShop(longShop longShop);
}