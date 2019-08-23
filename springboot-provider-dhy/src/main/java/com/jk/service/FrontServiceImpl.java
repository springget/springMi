package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.FrontMapper;
import com.jk.model.Goods;
import com.jk.model.Pedition;
import com.jk.model.Television;
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
}
