/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DealServiceImpl
 * Author:   李辉
 * Date:     2019/8/16 11:59
 * Description: s
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.mapper.DealMapper;
import com.jk.model.*;
import com.jk.service.DealService;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈s〉
 *
 * @author 李辉
 * @create 2019/8/16
 * @since 1.0.0
 */
@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealMapper dealMapper;


    @Override
    public PageUtil queryUser(ParameUtil param,Integer id) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<User> list = dealMapper.queryUser(param,id);
        PageInfo<User> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(),param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;

    }

    @Override
    public PageUtil queryOrder(ParameUtil param,Integer id) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Order> list = dealMapper.queryOrder(param,id);
        PageInfo<Order> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(),param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public PageUtil queryLogistics(ParameUtil param,Integer id) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Logistics> list = dealMapper.queryLogistics(param,id);
        PageInfo<Logistics> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public PageUtil queryRefund(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Refund> list = dealMapper.queryRefund(param);
        PageInfo<Refund> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public void updateUp(Integer id) {
        dealMapper.updateUp(id);
    }

    @Override
    public void updateDown(Integer id) {
        dealMapper.updateDown(id);
    }

    @Override
    public PageUtil queryComment(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Comment> list = dealMapper.queryComment(param);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public List<Refund> queryRefund2() {
        return dealMapper.queryRefund2();
    }

    @Override
    public PageUtil queryDd(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Order> list = dealMapper.queryDd(param);
        PageInfo<Order> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public PageUtil queryDd2(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Order> list = dealMapper.queryDd2(param);
        PageInfo<Order> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public PageUtil queryDd3(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Order> list = dealMapper.queryDd3(param);
        PageInfo<Order> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public PageUtil queryDd4(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Order> list = dealMapper.queryDd4(param);
        PageInfo<Order> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public PageUtil queryDd5(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Order> list = dealMapper.queryDd5(param);
        PageInfo<Order> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public PageUtil queryDd6(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Order> list = dealMapper.queryDd6(param);
        PageInfo<Order> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public PageUtil queryDd7(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Order> list = dealMapper.queryDd7(param);
        PageInfo<Order> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;
    }
















    /*@Override
    public List<User> queryUser(HashMap map) {
        return dealMapper.queryUser(map);
    }



    @Override
    public Integer queryUserCount() {
        return dealMapper.queryUserCount();
    }

    @Override
    public Integer queryOrderCount(HashMap map) {
        return dealMapper.queryOrderCount(map);
    }

    @Override
    public List<Order> queryOrder(HashMap map) {
        return dealMapper.queryOrder(map);
    }

    @Override
    public List<Logistics> queryLogistics(HashMap map) {
        return dealMapper.queryLogistics(map);
    }

    @Override
    public Integer queryLogisticsCount(HashMap map) {
        return dealMapper.queryLogisticsCount(map);
    }*/
}