package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Allocation;
import com.jk.model.Goods;
import com.jk.model.Tree;
import com.jk.model.Type;
import com.jk.service.GoodsService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.jk.util.OSSClientUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Reference
    private GoodsService goodsService;

    @Autowired
    private RedisTemplate redisTemplate;

    //查询树
    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(){
        List<Tree> list = new ArrayList();
        String key = "tree";
        if (redisTemplate.hasKey(key)) {
            System.out.println("=====走缓存=====");
            list = (List<Tree>) redisTemplate.opsForValue().get(key);
        }else {
            System.out.println("=====走数据库=====");
            list = goodsService.getTreeAll();
            list = TreeNoteUtil.getFatherNode(list);
            redisTemplate.opsForValue().set(key, list);
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        }
        return list;
    }
    // 查询 商品管理--商品列表
    @RequestMapping("queryGoods")
    @ResponseBody
    public DataGridResult queryGoods(@RequestBody ParameUtil param){
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = goodsService.queryGoods(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    //类型下拉列表查询
    @RequestMapping("queryType")
    @ResponseBody
    public List<Type> queryType(){

        List<Type> list = goodsService.queryType();

        return list;
    }
    @RequestMapping("TypeOne")
    @ResponseBody
    public List<Allocation> TypeOne(){

        List<Allocation> list = goodsService.TypeOne();

        return list;
    }
    //批量下架
    @RequestMapping("soldOut")
    @ResponseBody
    public void soldOut(String ids){
        String[] split = ids.split(",");
            for (String id:split) {
                goodsService.soldOut(id);
            }
    }

    //批量删除
    @RequestMapping("deleById")
    @ResponseBody
    public void deleById(String ids){
        String[] split = ids.split(",");
        for (String id:split) {
            goodsService.deleById(id);
        }
    }
    //商品新增
    @RequestMapping("addgoods")
    @ResponseBody
    public void addgoods(Goods goods){
        goodsService.addgoods(goods);
    }

    //分类管理查询
    @RequestMapping("queryTypeTwo")
    @ResponseBody
    public DataGridResult queryTypeTwo(@RequestBody ParameUtil param){
        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = goodsService.queryTypeTwo(param);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    //分类管理--批删
    @RequestMapping("deleByIdTwo")
    @ResponseBody
    public void deleByIdTwo(String ids) {
        String[] split = ids.split(",");
        for (String id:split) {
            goodsService.deleByIdTwo(id);
        }
    }
    @RequestMapping("uploadPhotoFile")
    @ResponseBody
    public String upImg(MultipartFile artImg, HttpServletRequest req) throws
            Exception{
    //获取原文件名称
        String fileName = artImg.getOriginalFilename();
        String folderPath =
                req.getSession().getServletContext().getRealPath("/")+
                        "upload/";
        File file = new File(folderPath);
    // 该目录是否已经存在
        if(!file.exists()){
    // 创建文件夹
            file.mkdir();
        }
        String onlyFileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf('.'));
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
        fos.write(artImg.getBytes());
        fos.flush();
        fos.close();
        return "/upload/"+onlyFileName;
    }
    @RequestMapping("putawayOne")
    @ResponseBody
    public void putawayOne(Integer id){
        goodsService.putawayOne(id);
    }
    @RequestMapping("ishot")
    @ResponseBody
    public void ishot(Integer id){
        goodsService.ishot(id);
    }
    @RequestMapping("nohot")
    @ResponseBody
    public void nohot(String ids) {
        String[] split = ids.split(",");
        for (String id:split) {
            goodsService.nohot(id);
        }
    }
    @RequestMapping("updaloadImg")
    @ResponseBody
    public String uploadImg(MultipartFile imgg)throws IOException {
        if (imgg == null || imgg.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(imgg);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println(split[0]);
        return split[0];
    }
}
