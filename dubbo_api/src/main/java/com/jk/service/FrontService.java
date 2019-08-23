package com.jk.service;

import com.jk.model.Goods;

import com.jk.model.Luser;
import com.jk.model.Pedition;
import com.jk.model.Television;

import java.util.List;

public interface FrontService {

    List<Goods> queryshouji1();

    List<Television> dianshi();

    List<Pedition> lickMemory();

    Goods pxiangQing(Integer id);

    Luser loginLuser(String username);
}
