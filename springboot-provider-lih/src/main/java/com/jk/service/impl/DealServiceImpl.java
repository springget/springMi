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
import org.apache.poi.ss.formula.functions.Rows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Queue;

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

    @Autowired
    private MongoTemplate mongoTemplate;
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
       /* PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<Comment> list = dealMapper.queryComment(param);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);

        PageUtil pageUtil = new PageUtil((int) pageInfo.getTotal(), param.getPageNumber(), param.getPageSize());
        pageUtil.setList(list);
        return pageUtil;*/

        Criteria criteria = new Criteria();
        Query query = new Query();

        query.addCriteria(criteria);

        Integer count=(int) mongoTemplate.count(query, Comment.class,"Comment");
        System.out.println(count);

        PageUtil pageUtil = new  PageUtil(count, param.getPageNumber(), param.getPageSize());
        Integer skip = pageUtil.getFirstResultCount();

        query.skip(skip);
        query.limit(param.getPageSize());


        List<Comment> list=mongoTemplate.find(query,Comment.class, "Comment");
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

    @Override
    public Refund findRefundByid(Integer id) {
        return dealMapper.findRefundByid(id);
    }

    @Override
    public Comment findCommentByid(Integer id) {
        Criteria criteria = new Criteria();
        criteria.is(id);
        Query query = new Query();
        query.addCriteria(criteria);
        Comment comment=  mongoTemplate.findOne(query, Comment.class,"Comment");
  /*      System.out.println(id);

        System.out.println(comment.getCommentId());*/
        return comment;
    }

    @Override
    public void addComment(Comment comment) {
        Update update=new Update();
        update.set("reply",comment.getReply());
        Query query = new 	Query();
        Criteria c = new Criteria();
        c.and("commentId").is(comment.getCommentId());
        query.addCriteria(c);

        mongoTemplate.updateFirst(query, update,"Comment");
    }


}