/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.service.pkkey;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Pkgenerator;
import com.miaoyou.platform.server.entity.PkgeneratorExample;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.PkgeneratorMapper;
import com.miaoyou.platform.server.utils.Pager;

/**
 *
 * @author 305027939
 */
@Service
public class PkgeneratorService implements PkgeneratorServiceIF {

    private static final Log log = LogFactory.getLog(PkgeneratorService.class);
    @Resource
    private PkgeneratorMapper mapper;

    @Override
    public Pkgenerator findDataByKey(Integer id) {
    	Pkgenerator pin = mapper.selectByPrimaryKey(id);
        log.debug("PkgeneratorService,find: " + pin.getId());
        return pin;
    }

    @Override
    public CommFindEntity<Pkgenerator> findAll(Pager page, String conditionSql) {
        PkgeneratorExample example = new PkgeneratorExample();
        CommFindEntity<Pkgenerator> allData = new CommFindEntity<Pkgenerator>();

    	// 必须先设置count数，再设置limtStart/limitEnd
		int count = mapper.countByExample(example);
		 log.debug("found total:" + count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("role_id DESC");

        //排序
        example.setOrderByClause("id DESC");

        allData.setCount(count);

        //查询数据库
        List<Pkgenerator> results = mapper.selectByExample(example);
        allData.setResult(results);
        return allData;
    }

    @Override
    public int saveData(Pkgenerator bean) {
        log.debug("PkgeneratorService,save: " + bean.getPkcolumnname());
        int result = mapper.insertSelective(bean);
        return result;
    }

    @Override
    public int deleteDataByKey(Integer id) {
        log.debug("PkgeneratorService,delete: " + id);
        int result = mapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public int updateData(Pkgenerator bean) {
        log.debug("PkgeneratorService,update: " + bean.getId());
        int result = mapper.updateByPrimaryKeySelective(bean);
        return result;
    }

    @Override
    public Long getPrimaryKey(String TABLE_NAME, String COLUMN_NAME) {
        long primaryValue = 0;
        PkgeneratorExample example = new PkgeneratorExample();
        example.createCriteria().andPkcolumnnameEqualTo(COLUMN_NAME).andTargettableEqualTo(TABLE_NAME);

        List<Pkgenerator> result = mapper.selectByExample(example);
        if (result != null && result.size() > 0) {
        	Pkgenerator pk = result.get(0);
            primaryValue = pk.getInitialvalue();
            log.debug("table generator,table: " + TABLE_NAME+",colum:"+COLUMN_NAME+",primary value:"+primaryValue);
            pk.setInitialvalue((primaryValue+pk.getAllocationsize()));
            mapper.updateByExampleSelective(pk, example);
        } else {
            log.debug("table generator, NOT FOUND table: " + TABLE_NAME+",colum:"+COLUMN_NAME+",initialize primary value:1");
            primaryValue = 1;
            Pkgenerator pk = new Pkgenerator();
            pk.setInitialvalue(2l);
            pk.setPkcolumnname(COLUMN_NAME);
            pk.setTargettable(TABLE_NAME);
            pk.setAllocationsize(1l);
            mapper.insert(pk);
        }

        return primaryValue;
    }

}
