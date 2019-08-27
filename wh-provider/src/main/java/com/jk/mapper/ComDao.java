package com.jk.mapper;

import com.jk.model.Comment;
import com.jk.model.Comment_main;

import java.util.List;

public interface ComDao {

    List<Comment> queryContent(Integer id);

}
