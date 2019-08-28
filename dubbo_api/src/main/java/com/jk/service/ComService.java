package com.jk.service;

import com.jk.model.Comment;
import com.jk.model.Comment_main;

import java.util.List;

public interface ComService {

    List<Comment> queryContent(Integer id);

}
