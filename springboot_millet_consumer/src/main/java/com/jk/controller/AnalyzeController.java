package com.jk.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Area;
import com.jk.model.Goods;
import com.jk.service.AnalyzeService;
import com.jk.util.DataGridResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("analyze")
public class AnalyzeController {

    @Reference
    private AnalyzeService analyzeService;


    @RequestMapping("queryAnaList")
    @ResponseBody
    public DataGridResult queryAnaList(){
        DataGridResult result = new DataGridResult();
        List<Goods>  goods= analyzeService.queryAnaList();
        result.setRows(goods);

        return result;
    }

    @RequestMapping("queryTodayAnaList")
    @ResponseBody
    public DataGridResult queryTodayAnaList(){
        DataGridResult result = new DataGridResult();
        List<Goods>  goods= analyzeService.queryTodayAnaList();
        result.setRows(goods);
        return result;
    }


    @RequestMapping("queryThirtyAnaList")
    @ResponseBody
    public DataGridResult queryThirtyAnaList(){
        DataGridResult result = new DataGridResult();
        List<Goods>  goods= analyzeService.queryThirtyAnaList();
        result.setRows(goods);
        return result;
    }

    @RequestMapping("queryYearAnaList")
    @ResponseBody
    public DataGridResult queryYearAnaList(){
        DataGridResult result = new DataGridResult();
        List<Goods>  goods= analyzeService.queryYearAnaList();
        result.setRows(goods);
        return result;
    }

    @RequestMapping("queryGoodsByYear")
    @ResponseBody
    public List<Map<String,Object>> queryGoodsByYear(){
        List<Map<String,Object>> list = analyzeService.queryGoodsByYear();
        for (Map<String,Object> map:list) {
            map.put("sliced",true);
            map.put("selected",true);
        }
        return list;
    }
    @RequestMapping("queryBookByMonth")
    @ResponseBody
    public Map<String,Object> queryBookByMonth(){
        List<Map<String,Object>> list = analyzeService.queryBookByMonth();
        String[] month = new String[list.size()];
        int[] count = new int[list.size()];
        for (int i=0;i<list.size();i++){
            if(list.get(i).get("month").equals("01")){
                month[i] = "一月";
            }
            if(list.get(i).get("month").equals("02")){
                month[i] = "二月";
            }
            if(list.get(i).get("month").equals("03")){
                month[i] = "三月";
            }
            if(list.get(i).get("month").equals("04")){
                month[i] = "四月";
            }
            if(list.get(i).get("month").equals("05")){
                month[i] = "五月";
            }
            if(list.get(i).get("month").equals("06")){
                month[i] = "六月";
            }
            if(list.get(i).get("month").equals("07")){
                month[i] = "七月";
            }
            if(list.get(i).get("month").equals("08")){
                month[i] = "八月";
            }
            if(list.get(i).get("month").equals("09")){
                month[i] = "九月";
            }
            if(list.get(i).get("month").equals("10")){
                month[i] = "十月";
            }
            if(list.get(i).get("month").equals("11")){
                month[i] = "十一月";
            }
            if(list.get(i).get("month").equals("12")){
                month[i] = "十二月";
            }
            count[i] = Integer.parseInt(list.get(i).get("count").toString());
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("month",month);
        map.put("count",count);
        return map;
    }
}