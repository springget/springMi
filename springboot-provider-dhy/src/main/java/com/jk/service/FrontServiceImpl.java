package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.FrontMapper;
import com.jk.model.*;
import com.jk.model.Goods;
import com.jk.model.Luser;
import com.jk.model.Pedition;
import com.jk.model.Television;
import com.jk.model.Television;
import com.jk.model.TvVersion;
import com.jk.model.TvxiantQing;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class FrontServiceImpl implements FrontService{

    @Autowired
    private FrontMapper frontMapper;


    @Override
    public List<Goods> queryshouji1() {
        return frontMapper.queryshouji1();
    }

    @Override
    public List<Television> dianshi() {
        return frontMapper.dianshi();
    }

    @Override
    public List<Pedition> lickMemory() {
        return frontMapper.lickMemory();
    }

    @Override
    public Goods pxiangQing(Integer id) {
        return frontMapper.pxiangQing(id);
    }

    @Override
    public Luser loginLuser(String username) {
        return frontMapper.loginLuser(username);
    }
    @Override
    public List<Goods> queryPhone1() {

        return frontMapper.queryPhone1();
    }

    @Override
    public List<Goods> queryPhone2() {
        return frontMapper.queryPhone2();
    }

    @Override
    public List<Goods> queryPhone3() {
        return frontMapper.queryPhone3();
    }

    @Override
    public List<Television> queryTv1() {
        return frontMapper.queryTv1();
    }

    @Override
    public List<Television> queryTv2() {
        return frontMapper.queryTv2();
    }

    @Override
    public List<Television> queryTv3() {
        return frontMapper.queryTv3();
    }

    @Override
    public Television querytvxiangQing(Integer tid) {

        return frontMapper.querytvxiangQing(tid);
    }

    @Override
    public List<TvVersion> tvVersion() {
        return frontMapper.tvVersion();
    }

    @Override
    public Luser register(String username) {

        return frontMapper.register(username);
    }

    @Override
    public void addUser(Luser user) {

        frontMapper.addUser(user);
    }
}
