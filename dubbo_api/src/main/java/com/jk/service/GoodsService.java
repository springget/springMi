package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.Tree;
import com.jk.model.Type;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;

public interface GoodsService {
    //查询树
    List<Tree> getTreeAll();
    //商品管理--商品列表
    PageUtil queryGoods(ParameUtil param);

    List<Type> queryType();

    void soldOut(String id);

    void deleById(String id);

    void addgoods(Goods goods);

    Goods findGoodsByid(Integer id);

    PageUtil queryTypeTwo(ParameUtil param);

    void deleByIdTwo(String id);
}
