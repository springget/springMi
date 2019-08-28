package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.*;
import com.jk.service.DhyService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("dhy")
public class DhyController {

    @Reference
    private DhyService dhyService;

    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("queryRole")
    @ResponseBody
    public DataGridResult queryRole(@RequestBody ParameUtil parameUtil){
        PageUtil pageUtil = dhyService.queryRole(parameUtil);

        DataGridResult result = new DataGridResult();

        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());

        return result;
    }



    @RequestMapping("showXiangQing")

    public ModelAndView showXiangQing(Integer id, ModelAndView model){
   /*     System.err.println(id);*/
        Role list = dhyService.showXiangQing(id);

        model.setViewName("html/dhy/showXiangQing");
        model.addObject("list",list);

        return model;
    }

    @RequestMapping("showXiangQing2")

    public ModelAndView showXiangQing2(Integer id, ModelAndView model){
       /* System.err.println(id);*/
        User list = dhyService.showXiangQing2(id);

        model.setViewName("html/dhy/role");
        model.addObject("list",list);

        return model;
    }



    @RequestMapping("queryZhanghao")
    @ResponseBody
    public DataGridResult queryZhanghao(@RequestBody ParameUtil parameUtil){
        PageUtil pageUtil = dhyService.queryZhanghao(parameUtil);

        DataGridResult result = new DataGridResult();

        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());

        return result;
    }

    @RequestMapping("down")
    @ResponseBody
    public void updateStatus(Integer id){

        dhyService.updateStatus(id);
    }

    @RequestMapping("up")
    @ResponseBody
    public void updateStatus2(Integer id){

        dhyService.updateStatus2(id);
    }

   /* //tree
    @RequestMapping("getAllTree")
    @ResponseBody
    public List<Tree> getTreeAll(HttpServletRequest request){
        List<Tree> list = new ArrayList<>();
      User user = (User) request.getSession().getAttribute("user");
        //定义缓存key
        String key = "tree"+user.getUserId();
        //判断缓存是否存在
        if(redisTemplate.hasKey(key)){
            System.out.println("=====走缓存=======");
            list = (List<Tree>) redisTemplate.opsForValue().get(key);
        }else{
            System.out.println("====走数据库===");
       *//*     list = dhyService.getTreeAll();*//*
            list = dhyService.getTreeAll(user.getUserId());
            //自己调自己
            list = TreeNoteUtil.getFatherNode(list);
            redisTemplate.opsForValue().set(key, list);
            //设置过期时间
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;

    }
*/
    @RequestMapping("getAllTree")
    @ResponseBody
    public List<Tree> getTreeAll(HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");

        List<Tree> list = dhyService.getTreeAll(user.getUserId());
        //自己调自己
        list = TreeNoteUtil.getFatherNode(list);

        return list;
    }



    @RequestMapping("getPerById")
    @ResponseBody
    public List<Role> getPerById(Integer id){

        List<Role> list = dhyService.getPerById(id);

        return list;
    }

    @RequestMapping("updateRole")
    @ResponseBody
    public void updateRole(Integer[] ids,Integer id){

       dhyService.updateRole(ids,id);
    }

    //权限
    @RequestMapping("queryPer")
    @ResponseBody
    public List<Tree> queryPer(Integer id){

        List<Tree> list = dhyService.queryPerById(id);
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }

/*
    @RequestMapping("updatePer")
    @ResponseBody
    public void updatePer(Integer[] ids,Integer roleid){
        dhyService.updatePer(ids,roleid);
    }
*/



    //根据 角色id跳转到回显页面
    @RequestMapping("dhytree")
    public String  dhytree(Integer roleid, Model model){
        model.addAttribute("id",roleid);
        return "html/dhy/dhytree";
    }

    //根据 角色id查询对应权限
    @RequestMapping("cxbyridtree")
    @ResponseBody
    public List<Tree> cxbyridtree(Integer id){
        /*System.out.println(id);*/
        return dhyService.querytreebyrid(id,0);
    }

    //绑定权限
    @RequestMapping("updatetree")
    @ResponseBody
    public void updatetree(Integer[] ids,Integer roleid){
        dhyService.UpdateTree(ids,roleid);
    }

    //角色权限
    @RequestMapping("queryRoleById")
    public String  queryRoleById(Integer id, Model model,HttpServletRequest request){
        List<Role> list = dhyService.editrole(id);
        List<String> list1 = dhyService.queryRoleById(id);
    //    System.err.println(list1.get(0));
        request.getSession().setAttribute("id",list1.get(0));
        model.addAttribute("id",id);
        model.addAttribute("list",list);
        return "html/dhy/dhyrole";
    }

    @RequestMapping("updateRole2")
    @ResponseBody
    public void updateRole(Integer ids,Integer id,HttpServletRequest request) {
        String roleid = (String)request.getSession().getAttribute("id");
        int i = Integer.parseInt(roleid);
        dhyService.updateRoleCount(i,ids);
        dhyService.updateRole2(ids,id);
    }



    @RequestMapping("queryPerById")
    public String queryPerById(Integer id,Model model){
        User user= (User) dhyService.queryPerById(id);
        model.addAttribute("user",user);
        return "html/dhy/upduser";
    }


}
