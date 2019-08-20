package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.mapper.DhyMapper;
import com.jk.mapper.RolePerMapper;
import com.jk.mapper.UserRoleMapper;
import com.jk.model.*;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Select;
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

        map.put("gname",parameUtil.getGname());
        System.err.println(parameUtil.getGname());
        List<Zhanghao> list = dhyMapper.queryZhanghao(map);

        PageInfo<Zhanghao> pageInfo = new PageInfo<>(list);

        PageUtil page= new PageUtil((int)pageInfo.getTotal(),parameUtil.getPageNumber(), parameUtil.getPageSize());

        page.setList(list);

        return page;

    }

    @Override
    public Gangwei showXiangQing(Integer id) {
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
    public List<Tree> getTreeAll() {
        // TODO Auto-generated method stub
        Integer id=0;
        List<Tree> node =getNode(id);
        return node;
    }

    private List<Tree> getNode(Integer id) {
        List<Tree> findTreeListByPid = dhyMapper.getTreeAll(id);
        for (Tree tree : findTreeListByPid) {
            Integer id2 = tree.getId();
            List<Tree> node = getNode(id2);
            tree.setNodes(node);
        }
        return findTreeListByPid;

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
                    listTwo.get(j).setChecked("true");
                }
            }
        }
        return listTwo;
    }

    @Override
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
    }


}
