package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.RessDao;
import com.jk.model.Payment;
import com.jk.model.Ress;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RessServiceImpl implements RessService {
    @Autowired
    private RessDao ressDao;


    @Override
    public List<Ress> queryRess(Integer id) {
        return ressDao.queryRess(id);
    }

    @Override
    public void addRess(Integer id,Ress ress) {
        ress.setUserId(id);
        ressDao.addRess(ress);
    }

    @Override
    public void deleteOrderUrl(String id) {
        ressDao.deleteOrderUrl(id);
    }

    @Override
    public Ress findRessByid(Integer id) {
        return ressDao.findRessByid(id);
    }

    @Override
    public void updateOrderUrls(Ress ress) {
        ressDao.updateOrderUrls(ress);
    }

    @Override
    public List<Payment> findPaymentListAll() {
        return ressDao.findPaymentListAll();
    }

    @Override
    public Integer queryzPrice() {
        return ressDao.queryzPrice();
    }

    @Override
    public Integer queryzSum() {
        return ressDao.queryzSum();
    }


}