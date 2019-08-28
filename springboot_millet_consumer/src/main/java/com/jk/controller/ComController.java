package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Comment;
import com.jk.service.ComService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ComController
 * describe:  前台评论
 *
 * @author wanghang
 * @date 2019/08/26 11:54
 */

@Controller
@RequestMapping("content")
public class ComController {

    @Reference
    private ComService comService;

    @RequestMapping("queryContent")
    @ResponseBody
    public Map queryContent(Integer id){
        List<Comment> list = comService.queryContent(id);
        Map map = new HashMap<>();
        map.put("rows",list);
        return map;
    }
}
