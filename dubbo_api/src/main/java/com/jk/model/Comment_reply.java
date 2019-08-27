package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: Comment_reply
 * describe:
 *
 * @author wanghang
 * @date 2019/08/26 11:25
 */
public class Comment_reply implements Serializable {

    private Integer comment_id;     //评论ID
    private Integer user_id;        //用户ID
    private Integer replyuser_id;   //被回复人ID
    private String content;         //回复内容
    private Integer prase_count;    //点赞数
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;        //点赞时间

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getReplyuser_id() {
        return replyuser_id;
    }

    public void setReplyuser_id(Integer replyuser_id) {
        this.replyuser_id = replyuser_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPrase_count() {
        return prase_count;
    }

    public void setPrase_count(Integer prase_count) {
        this.prase_count = prase_count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
