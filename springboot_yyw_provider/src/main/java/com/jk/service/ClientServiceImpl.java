package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.dao.ClientDao;
import com.jk.model.Member;
import com.jk.model.User;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientDao clientDao;

    @Override
    public PageUtil queryUserList(ParameUtil params) {
        PageHelper.startPage(params.getPageNumber(), params.getPageSize());
        List<User> list = clientDao.queryUserList(params);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), params.getPageNumber(), params.getPageSize());
        pageUtil.setList(list);

        return pageUtil;
    }

    @Override
    public PageUtil queryMemberList(ParameUtil params) {
        PageHelper.startPage(params.getPageNumber(), params.getPageSize());
        List<Member> list = clientDao.queryMemberList(params);
        PageInfo<Member> pageInfo = new PageInfo<>(list);
        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), params.getPageNumber(), params.getPageSize());
        pageUtil.setList(list);

        return pageUtil;
    }

    @Override
    public void updateClient(String aa,String id) {
        Map map = new HashMap();
        map.put("aa",aa);
        map.put("id",id);
        clientDao.updateClient(map);
    }

    @Override
    public User queryUserName(String userAccount) {
        return clientDao.queryUserName(userAccount);
    }

    @Override
    public void updateCancel(Integer id) {
        clientDao.updateCancel(id);
    }

    @Override
    public User queryCoupon(Integer id) {
        return clientDao.queryCoupon(id);
    }



}
