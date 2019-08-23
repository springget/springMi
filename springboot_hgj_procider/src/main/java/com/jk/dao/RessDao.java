package com.jk.dao;

import com.jk.model.Payment;
import com.jk.model.Ress;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RessDao {
    List<Ress> queryRess(Integer id);

    void addRess(Ress ress);

    void deleteOrderUrl(String id);
@Select("select * from t_ress where ressid=#{value}")
    Ress findRessByid(Integer id);

    void updateOrderUrls(Ress ress);

    List<Payment> findPaymentListAll();

    Integer queryzPrice();

    Integer queryzSum();
}
