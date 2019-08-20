package com.jk.dao;

import com.jk.model.Area;
import com.jk.model.Shop;
import com.jk.model.longShop;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopDao {
    void addShop(Shop shop);
@Select("select * from t_area where pid=#{value}")
    List<Area> queryArea(Integer id);
@Select("select * from t_shop where shopName=#{value}")
    Shop queryShop(String name);

    void addlongShop(longShop longShop);
}
