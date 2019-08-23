package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.HighDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * ClassName: HighServiceImpl
 * describe:
 *
 * @author wanghang
 * @date 2019/08/23 14:40
 */
@Service
public class HighServiceImpl implements HighService{

    @Autowired
    private HighDao highDao;

    @Override
    public List<Map<String, Object>> queryColu() {
        List<Map<String, Object>> list = highDao.queryColu();
        return list;
    }

    @Override
    public List<Map<String, Object>> queryline() {
        return highDao.queryline();
    }
}
