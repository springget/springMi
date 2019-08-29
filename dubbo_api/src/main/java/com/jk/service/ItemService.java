/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ItemService
 * Author:   李辉
 * Date:     2019/8/22 21:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.model.Goods;


import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 李辉
 * @create 2019/8/22
 * @since 1.0.0
 */
public interface ItemService {
    Goods getGoodsById(Integer goodsId);

    /*  TbItem getItemById(Integer itemId);
  *//*  EasyUIDataGridResult getItemList(int page, int rows);
    E3Result addItem(TbItem item, String desc);
    TbItemDesc getItemDescById(long itemId);*/

}