package com.jk.mapper;

import com.jk.model.Tree;

public interface TreeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tree record);

    int insertSelective(Tree record);

    Tree selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);
}