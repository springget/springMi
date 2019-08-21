package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.mapper.DhyMapper;
import com.jk.mapper.RolePerMapper;
import com.jk.mapper.UserRoleMapper;
import com.jk.model.*;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DhyServiceImpl implements DhyService{

    @Autowired
    private DhyMapper dhyMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePerMapper rolePerMapper;

    @Override
    public PageUtil queryRole(ParameUtil parameUtil) {
        PageHelper.startPage(parameUtil.getPageNumber(),parameUtil.getPageSize());

        Map map = new HashMap<>();

        map.put("name",parameUtil.getName());
        /*        System.err.println(parameUtil.getName());*/
        List<Role> list = dhyMapper.queryRole(map);

        PageInfo<Role> pageInfo = new PageInfo<>(list);

        PageUtil page= new PageUtil((int)pageInfo.getTotal(),parameUtil.getPageNumber(), parameUtil.getPageSize());

        page.setList(list);

        return page;

    }

    @Override
    public PageUtil queryZhanghao(ParameUtil parameUtil) {

        PageHelper.startPage(parameUtil.getPageNumber(),parameUtil.getPageSize());

        Map map = new HashMap<>();

        map.put("name",parameUtil.getName());
        System.err.println(parameUtil.getName());
        List<Zhanghao> list = dhyMapper.queryZhanghao(map);

        PageInfo<Zhanghao> pageInfo = new PageInfo<>(list);

        PageUtil page= new PageUtil((int)pageInfo.getTotal(),parameUtil.getPageNumber(), parameUtil.getPageSize());

        page.setList(list);

        return page;

    }

    @Override
    public Role showXiangQing(Integer id) {
        return dhyMapper.showXiangQing(id);
    }

    @Override
    public Zhanghao showXiangQing2(Integer id) {
        return dhyMapper.showXiangQing2(id);
    }

    @Override
    public void updateStatus(Integer id) {
        dhyMapper.updateStatus(id);
    }

    @Override
    public void updateStatus2(Integer id) {
        dhyMapper.updateStatus2(id);
    }

    @Override
    public List<Tree> getTreeAll(Integer userId) {

        return dhyMapper.getTreeAll(userId);
    }

    @Override
    public List<Role> getPerById(Integer id) {

        //查出  角色 id  所对应的 菜单 的id
        List<String> list =  userRoleMapper.queryRoleByid(id);
        // 查询所有 的菜单
        List<Role>  listTwo = userRoleMapper.queryRoleAll();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listTwo.size(); j++) {
                // 用  原来 选中的 菜单id  和所有的  菜单id  对比 ，对比成功 就选中
                if(list.get(i).equals(listTwo.get(j).getId().toString())){
                    listTwo.get(j).setChecked("true");

                }
            }
        }
        return listTwo;
    }

    @Override
    public void updateRole(Integer[] ids, Integer id) {
        //先 删除 原有的 关联
        int i  = userRoleMapper.deleteRole(id);
        //再建立  新的 关联
        if(i >=0){
            for (int j = 0; j < ids.length; j++) {
                UserRole rpm = new UserRole();

                rpm.setRoleid(ids[j]);
                rpm.setUserid(id);
                i = userRoleMapper.insert(rpm);
            }
        }
    }

    @Override
    public List<Tree> queryPerById(Integer id) {
        //查出  角色 id  所对应的 菜单 的id
        List<String> list =  rolePerMapper.queryPerById(id);

        // 查询所有 的菜单
        List<Tree>  listTwo = rolePerMapper.queryPerAll();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listTwo.size(); j++) {
                // 用  原来 选中的 菜单id  和所有的  菜单id  对比 ，对比成功 就选中
                if(list.get(i).equals(listTwo.get(j).getId().toString())){
                    listTwo.get(j).setChecked(true);
                }
            }
        }
        return listTwo;
    }

   /* @Override
    public void updatePer(Integer[] ids, Integer roleid) {
        //先 删除 原有的 关联
        int i  = rolePerMapper.deletePerById(roleid);
        //再建立  新的 关联
        if(i >=0){
            for (int j = 0; j < ids.length; j++) {
                RolePer rpm = new RolePer();
                rpm.setPerid(ids[j]);
                rpm.setRoleid(roleid);
                i = rolePerMapper.insert(rpm);
            }
        }
    }*/


    @Override
    public void UpdateTree(Integer[] ids, Integer roleid) {
        //先 删除 原有的 关联
        int i  = rolePerMapper.deletePerById(roleid);
        //再建立  新的 关联
        if(i >= 0){
            for (int j = 0; j < ids.length; j++) {
                RolePer rpm = new RolePer();
                rpm.setPerid(ids[j]);
                rpm.setRoleid(roleid);
                i = rolePerMapper.insert(rpm);
            }
        }
    }

    @Override
    public List<Tree> querytreebyrid(Integer id, int pid) {
        JSONObject json =new JSONObject();
        List <Tree> list =queryOrgAll3(pid);
        List <Tree> list2= queryOrgAll2(id,pid);
        Map map=new HashMap();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if(list.get(i).getId()==list2.get(j).getId()){
                    list.get(i).getId();
                    json.put("checked", true);
                    list.get(i).setState(json);
                }
            }
            if(list.size()>0){
                for (int s = 0; s < list.size(); s++) {
                    List<Tree> list3 = querytreebyrid(id,list.get(s).getId());
                    list.get(s).setNodes(list3);
                }
            }
        }
        return list;
    }

    //角色权限
    @Override
    public List<Role> editrole(Integer id) {
        //查出  角色 id  所对应的 菜单 的id
        List<String> list =  userRoleMapper.queryrolebyid(id);
        // 查询所有 的菜单
        List<Role>  listTwo = userRoleMapper.queryRoleAll();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listTwo.size(); j++) {
                // 用  原来 选中的 菜单id  和所有的  菜单id  对比 ，对比成功 就选中
                if(list.get(i).equals(listTwo.get(j).getId().toString())){
                    listTwo.get(j).setChecked("true");
                }
            }
        }
        return listTwo;
    }

    @Override
    public List<String> queryRoleById(Integer id) {
        List<String> list =  userRoleMapper.queryrolebyid(id);
        System.err.println(list.get(0));
        return list;
    }

    @Override
    public void updateRoleCount(int i, Integer ids) {
        userRoleMapper.updateRoleCount1(i);
        userRoleMapper.updateRoleCount2(ids);
    }

    @Override
    public void updateRole2(Integer ids, Integer id) {
        userRoleMapper.updateRole2(ids,id);
    }


    private List<Tree> queryOrgAll2(Integer id, int pid) {

        // 根据pid查询子节点
        List<Tree> orgs = dhyMapper.queryOrgAll2(id,pid);
        // 如果查询到子节点集合
        if(orgs != null && orgs.size()>0){
            // 循环集合，将每个机构对象的id作为pid 继续查询子节点集合
            for (int i = 0; i < orgs.size(); i++) {
                List<Tree> orgs2 = queryOrgAll2(id,orgs.get(i).getId());
                // 将查询的子节点集合放到该结构对象的children属性中
                orgs.get(i).setNodes(orgs2);
            }
        }
        return orgs;

    }

    private List<Tree> queryOrgAll3(int pid) {

        // 根据pid查询子节点
        List<Tree> orgs = dhyMapper.queryOrgAll3(pid);
        // 如果查询到子节点集合
        if(orgs != null && orgs.size()>0){
            // 循环集合，将每个机构对象的id作为pid 继续查询子节点集合
            for (int i = 0; i < orgs.size(); i++) {
                List<Tree> orgs2 = queryOrgAll3(orgs.get(i).getId());
                // 将查询的子节点集合放到该结构对象的children属性中
                orgs.get(i).setNodes(orgs2);
            }
        }
        return orgs;

    }


}
