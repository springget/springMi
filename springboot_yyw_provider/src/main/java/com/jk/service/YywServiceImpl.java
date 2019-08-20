package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.YywDao;
import com.jk.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class YywServiceImpl implements YywService{

    @Autowired
    private YywDao yywDao;

    @Override
    public Goods query(Integer id) {
        return yywDao.query(id);
    }
}
