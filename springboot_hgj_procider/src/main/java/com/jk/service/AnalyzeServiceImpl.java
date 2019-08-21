package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.AnalyzeDao;
import com.jk.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class AnalyzeServiceImpl implements AnalyzeService {
@Autowired
    private AnalyzeDao analyzeDao;


    @Override
    public List<Goods> queryAnaList() {
        return analyzeDao.queryAnaList();
    }

    @Override
    public List<Goods> queryTodayAnaList() {
        return analyzeDao.queryTodayAnaList();
    }

    @Override
    public List<Goods> queryThirtyAnaList() {
        return analyzeDao.queryThirtyAnaList();
    }

    @Override
    public List<Goods> queryYearAnaList() {
        return analyzeDao.queryYearAnaList();
    }

    @Override
    public List<Map<String, Object>> queryGoodsByYear() {
        return analyzeDao.queryGoodsByYear();
    }

    @Override
    public List<Map<String, Object>> queryBookByMonth() {
        return analyzeDao.queryBookByMonth();
    }
}