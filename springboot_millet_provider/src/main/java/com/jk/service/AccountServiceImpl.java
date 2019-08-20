/**
 * Copyright (C), 2015-2019, 金科教育
 * FileName: AccountServiceImpl
 * Author:   dell
 * Date:     2019/8/16 14:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名 ：刘博文   修改时间   new Date()  版本号              描述
 */
package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.AccountMapper;
import com.jk.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2019/8/16
 * @since 1.0.0
 */
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountMapper accountMapper;

    @Override
    public HashMap<String, Object> findBootstrapaccount(Integer page, Integer rows, Goods goods) {
     Integer  start=(page-1)*rows;
     Integer end=start +rows;
     HashMap<String, Object> map=new HashMap<>();
     map.put("end",end);
     map.put("start",start);
     map.put("goods",goods);
     Integer  count= accountMapper.queryaccountcount(map);
     HashMap<String, Object> hash=new HashMap<>();
     List<Goods> list = accountMapper.queryaccount(map);
     hash.put("total", count);
     hash.put("rows", list);
     return hash;
    }

    @Override
    public HashMap<String, Object> findBootstrapincome(Integer page, Integer rows, Goods goods) {
        Integer  start=(page-1)*rows;
        Integer end=start +rows;
        HashMap<String, Object> map=new HashMap<>();
        map.put("end",end);
        map.put("start",start);
        map.put("goods",goods);
        Integer  count= accountMapper.queryaccountcount(map);
        HashMap<String, Object> hash=new HashMap<>();
        List<Goods> list = accountMapper.queryincome(map);
        hash.put("total", count);
        hash.put("rows", list);
        return hash;
    }

    @Override
    public HashMap<String, Object> findincome(Integer page, Integer rows, Goods goods) {
        Integer  start=(page-1)*rows;
        Integer end=start +rows;
        HashMap<String, Object> map=new HashMap<>();
        map.put("end",end);
        map.put("start",start);
        map.put("goods",goods);
        Integer  count= accountMapper.findincomecount(map);
        HashMap<String, Object> hash=new HashMap<>();
        List<Goods> list = accountMapper.findincome(map);
        hash.put("total", count);
        hash.put("rows", list);
        return hash;
    }

    @Override
    public Goods findbrankById(String goodsId) {
        return accountMapper.findbrankById(goodsId);
    }

    @Override
    public void saveorupdate(Goods goods) {
        accountMapper.saveorupdate(goods);
    }
}
