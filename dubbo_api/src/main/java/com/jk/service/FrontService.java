package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.Luser;
import com.jk.model.Television;
import com.jk.model.TvVersion;

import java.util.List;

public interface FrontService {

    List<Goods> queryPhone1();

    List<Goods> queryPhone2();

    List<Goods> queryPhone3();

    List<Television> queryTv1();

    List<Television> queryTv2();

    List<Television> queryTv3();

    Television querytvxiangQing(Integer tid);

    List<TvVersion> tvVersion();

    Luser register(String username);

    void addUser(Luser user);
}
