package com.jk.dao;

import com.jk.model.Coupon;
import com.jk.model.Member;
import com.jk.model.User;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ClientDao {


    List<User> queryUserList(ParameUtil params);

    List<Member> queryMemberList(ParameUtil params);


    void updateClient(Map map);

    User queryUserName(String userAccount);

    void addCoupon(Coupon coupon);

    List<Coupon> queryCoupon(ParameUtil params);
}

