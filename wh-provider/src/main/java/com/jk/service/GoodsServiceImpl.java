package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.mapper.GoodsDao;
import com.jk.model.Allocation;
import com.jk.model.Goods;
import com.jk.model.Tree;
import com.jk.model.Type;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsDao goodsDao;

    //查询树
    @Override
    public List<Tree> getTreeAll() {
        return goodsDao.getTreeAll();
    }
    //查询 商品管理--商品列表
    @Override
    public PageUtil queryGoods(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Goods> list = goodsDao.queryGoods(param);
        PageInfo<Goods> pageInfo = new PageInfo<>(list);
        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(),param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public List<Type> queryType() {
        return goodsDao.queryType();
    }

    @Override
    public void soldOut(String id) {
        goodsDao.soldOut(id);
    }

    @Override
    public void deleById(String id) {
        goodsDao.deleById(id);
    }

    @Override
    public void addgoods(Goods goods) {
        if(goods.getGoodsId()==null){
            goodsDao.addgoods(goods);
        }else{
            goodsDao.updGoods(goods);
        }

    }

    @Override
    public Goods findGoodsByid(Integer id) {
        return goodsDao.findGoodsByid(id);
    }

    @Override
    public PageUtil queryTypeTwo(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Type> list = goodsDao.queryTypeTwo(param);
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(),param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public void deleByIdTwo(String id) {
        goodsDao.deleByIdTwo(id);
    }

    @Override
    public void putawayOne(Integer id) {
        goodsDao.putawayOne(id);
    }

    @Override
    public void ishot(Integer id) {
        goodsDao.ishot(id);
    }

    @Override
    public void nohot(String id) {
        goodsDao.nohot(id);
    }

    @Override
    public List<Allocation> TypeOne() {
        return goodsDao.TypeOne();
    }

    @Override
    public void refuse(Integer id) {
        goodsDao.refuse(id);
    }

    @Override
    public void pass(Integer id) {
        goodsDao.pass(id);
    }

    @Override
    public List<Goods> queryHotGoods() {
        return goodsDao.queryHotGoods();
    }

    @Override
    public void setSeckill(Integer id) {
        goodsDao.setSeckill(id);
    }

}
