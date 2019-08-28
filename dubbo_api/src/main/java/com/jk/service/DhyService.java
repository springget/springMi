package com.jk.service;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;

public interface DhyService {


    /*PageUtil queryGangwei(ParameUtil parameUtil);*/
    PageUtil queryRole(ParameUtil parameUtil);

    PageUtil queryZhanghao(ParameUtil parameUtil);


    Role showXiangQing(Integer id);

    User showXiangQing2(Integer id);

    void updateStatus(Integer id);

    void updateStatus2(Integer id);

    List<Tree> getTreeAll(Integer userId);

    List<Role> getPerById(Integer id);

    void updateRole(Integer[] ids, Integer id);

    List<Tree> queryPerById(Integer id);

/*    void updatePer(Integer[] ids, Integer roleid);*/

    void UpdateTree(Integer[] ids, Integer roleid);

    List<Tree> querytreebyrid(Integer id, int pid);

    List<Role> editrole(Integer id);

    List<String> queryRoleById(Integer id);

    void updateRoleCount(int i, Integer ids);

    void updateRole2(Integer ids, Integer id);
}
