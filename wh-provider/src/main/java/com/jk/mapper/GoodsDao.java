package com.jk.mapper;

import com.jk.model.Allocation;
import com.jk.model.Goods;
import com.jk.model.Tree;
import com.jk.model.Type;
import com.jk.util.ParameUtil;

import java.util.List;

public interface GoodsDao {
    //查询树
    List<Tree> getTreeAll();
    //查询 商品管理--商品列表
    List<Goods> queryGoods(ParameUtil param);

    List<Type> queryType();

    void soldOut(String id);

    void deleById(String id);

    void addgoods(Goods goods);

    Goods findGoodsByid(Integer id);

    void updGoods(Goods goods);

    List<Type> queryTypeTwo(ParameUtil param);

    void deleByIdTwo(String id);

    void putawayOne(Integer id);

    void ishot(Integer id);

    void nohot(String id);

    List<Allocation> TypeOne();
}
