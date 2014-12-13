/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.service.log;

import com.miaoyou.platform.server.entity.Logtb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.utils.Pager;



/**
 *
 * @author li
 */
public interface LogIF {

    public int saveLog(String operateContent);

    public CommFindEntity<Logtb> findAll(Pager page, String conditionSql,String startDate,String endDate);

}
