package com.jk.service;

import com.jk.model.Gangwei;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.Zhanghao;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;

public interface DhyService {


    /*PageUtil queryGangwei(ParameUtil parameUtil);*/
    PageUtil queryRole(ParameUtil parameUtil);

    PageUtil queryZhanghao(ParameUtil parameUtil);


    Gangwei showXiangQing(Integer id);

    Zhanghao showXiangQing2(Integer id);

    void updateStatus(Integer id);

    void updateStatus2(Integer id);

    List<Tree> getTreeAll();

    List<Role> getPerById(Integer id);

    void updateRole(Integer[] ids, Integer id);

    List<Tree> queryPerById(Integer id);

    void updatePer(Integer[] ids, Integer roleid);
}
