package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ComDao;
import com.jk.model.Comment;
import com.jk.model.Comment_main;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ClassName: ComServiceImpl
 * describe:
 *
 * @author wanghang
 * @date 2019/08/26 11:55
 */
@Service
public class ComServiceImpl implements ComService{

    @Autowired
    private ComDao comDao;

    @Override
    public List<Comment> queryContent(Integer id) {

        return comDao.queryContent(id);
    }
}
