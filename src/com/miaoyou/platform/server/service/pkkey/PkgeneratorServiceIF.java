/*
 * 2014 Chengdu JunChen Technology
 */

package com.miaoyou.platform.server.service.pkkey;

import com.miaoyou.platform.server.entity.Pkgenerator;
import com.miaoyou.platform.server.service.CommServiceIF;


/**
 *
 * @author 305027939
 */
public interface PkgeneratorServiceIF extends CommServiceIF<Pkgenerator, Integer>{
    
    public Long getPrimaryKey(String TABLE_NAME,String COLUMN_NAME);
    
}
