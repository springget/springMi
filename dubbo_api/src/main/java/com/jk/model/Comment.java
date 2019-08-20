package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.annotation.Documented;
import java.util.Collection;
import java.util.Date;
/*@Documented(Collection="Comment")*/
public class Comment   implements Serializable {

    private Integer commentId;     //评论ID
    private String commentInfo;    //评论内容
    private String reply;//回复内容

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;    //评论时间
    private Integer userId;//用户Id
    private Integer goodsId;//商品Id
    private Integer commentDj;//商品等级 1 好评  2 中评  3 差评

    //临时
    private String goodsName; //商品名称
    private String userName;//用户姓名

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCommentDj() {
        return commentDj;
    }

    public void setCommentDj(Integer commentDj) {
        this.commentDj = commentDj;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
