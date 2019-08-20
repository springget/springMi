/**
 * Copyright (C), 2015-2019, 金科教育
 * FileName: State
 * Author:   dell
 * Date:     2019/8/16 16:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名 ：刘博文   修改时间   new Date()  版本号              描述
 */
package com.jk.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2019/8/16
 * @since 1.0.0
 *
 * 状态表
 * 1 待结算  2 进行中 3 交易完成 4交易失败 5 退款 6待定
 */
public class State {

private Integer satateId;
private  String stateName;

    public Integer getSatateId() {
        return satateId;
    }

    public void setSatateId(Integer satateId) {
        this.satateId = satateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
