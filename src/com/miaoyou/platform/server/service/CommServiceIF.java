/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.service;

import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.utils.Pager;



/**
 *
 * @author 305027939
 * @param <T>  是表的entity
 * @param <C>  是表的主键类型，如果是符合主键或者多个主键，就再写一个service interface， extends CommServiceIF<T, C>来实现自己的service interface
 */
public interface CommServiceIF<T, C> {

    public T findDataByKey(C id);

    public CommFindEntity<T> findAll(Pager page, String conditionSql);

    public int saveData(T bean);

    public int deleteDataByKey(C id);

    public int updateData(T bean);
}
