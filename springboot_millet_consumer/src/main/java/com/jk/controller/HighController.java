package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.HighService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: HighController
 * describe: 收益明细
 *
 * @author wanghang
 * @date 2019/08/23 14:39
 */
@Controller
@RequestMapping("highcharts")
public class HighController {

    @Reference
    private HighService highService;

    @RequestMapping("queryColu")
    @ResponseBody
    public List<Map<String, Object>> queryColu(){
        List<Map<String,Object>> list = highService.queryColu();
        List<Map<String,Object>> list1=new ArrayList<>();
        for (Map<String,Object> map1:list){
            Map<String,Object> map=new HashMap<>();
            String  aa = map1.get("收入").toString();
            Integer count = Integer.parseInt(map1.get("总收入").toString());
            String sj = (map1.get("时间").toString());
            map.put("name",map1.get("时间"));
            int[] bb = new int[]{count};
            map.put("data",bb);
            list1.add(map);
        }
        return list1;
    }

    @RequestMapping("queryline")
    @ResponseBody
    public List<Map<String,Object>> queryCarline(){
        List<Map<String,Object>> list= highService.queryline();
        List<Map<String,Object>> list1=new ArrayList<>();
        for (Map<String,Object> map1:list) {
            Map<String,Object> map=new HashMap<>();
            map.put("name",map1.get("月份"));
            map.put("y",map1.get("收入"));
            list1.add(map);
        }
        return list1;
}
    }
