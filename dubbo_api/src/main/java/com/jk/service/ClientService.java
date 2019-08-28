package com.jk.service;

import com.jk.model.Coupon;
import com.jk.model.Goods;
import com.jk.model.User;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

public interface ClientService {

    PageUtil queryUserList(ParameUtil params);

	 PageUtil queryMemberList(ParameUtil params);

    void updateClient(String aa,String id);


    User queryUserName(String userAccount);

    void updateCancel(Integer id);

    void addCoupon(Coupon coupon);

    PageUtil queryCoupon(ParameUtil params);

}
