package com.jk.service;

import com.jk.model.User;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;
import java.util.Map;

public interface ClientService {

    PageUtil queryUserList(ParameUtil params);

	 PageUtil queryMemberList(ParameUtil params);

    void updateClient(String aa,String id);


    User queryUserName(String userAccount);
}
