package com.jk.dao;

import com.jk.model.Goods;

import java.util.List;
import java.util.Map;

public interface AnalyzeDao {


    List<Goods> queryAnaList();

    List<Goods> queryTodayAnaList();

    List<Goods> queryThirtyAnaList();

    List<Goods> queryYearAnaList();

    List<Map<String, Object>> queryGoodsByYear();

    List<Map<String, Object>> queryBookByMonth();
}