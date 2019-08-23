package com.jk.service;

import com.jk.model.Payment;
import com.jk.model.Ress;

import java.util.List;

public interface RessService {

    List<Ress> queryRess(Integer id);

    void addRess(Integer id,Ress ress);


    void deleteOrderUrl(String id);

    Ress findRessByid(Integer id);

    void updateOrderUrls(Ress ress);

    List<Payment> findPaymentListAll();

    Integer queryzPrice();

    Integer queryzSum();
}