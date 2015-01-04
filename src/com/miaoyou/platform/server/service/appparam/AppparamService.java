

package com.miaoyou.platform.server.service.appparam;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Appparamtb;
import com.miaoyou.platform.server.entity.AppparamtbExample;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.AppparamtbMapper;
import com.miaoyou.platform.server.service.CommServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 *
 * @author 305027939
 */
@Service
public class AppparamService implements CommServiceIF<Appparamtb, Integer> {
     private static final Log log = LogFactory.getLog(AppparamService.class);

    @Resource
    private AppparamtbMapper mapper;
    
	@Resource
	PkgeneratorServiceIF pkgeneratorService;

    @Override
    public Appparamtb findDataByKey(Integer id) {
        Appparamtb pin = mapper.selectByPrimaryKey(id);
        log.debug("AppparamtbService,find: " + pin.getAppparamName());
        return pin;
    }

    @Override
    public CommFindEntity<Appparamtb> findAll(Pager page, String conditionSql) {
        AppparamtbExample example = new AppparamtbExample();
        CommFindEntity<Appparamtb> allData = new CommFindEntity<Appparamtb>();

        if (conditionSql != null && !conditionSql.trim().equals("")) {
            example.createCriteria().addConditionSql(conditionSql);
        }
        //必须先设置count数，再设置limtStart/limitEnd
        int count = mapper.countByExample(example);
        log.debug("found Appparamtb total:" + count);
        page.setCount(count);
        example.setLimitStart(page.getStartDataIndex());
        example.setLimitEnd(page.getPageSize());
        //排序
        example.setOrderByClause("appparam_id DESC");

        allData.setCount(count);

        //查询数据库
        List<Appparamtb> results = mapper.selectByExample(example);
        allData.setResult(results);
        return allData;
    }

    @Override
    public int saveData(Appparamtb bean) {
        log.debug("Appparamtb,save: " + bean.getAppparamName());
        long key = pkgeneratorService.getPrimaryKey("appparamtb",
				"appparam_id");
        bean.setAppparamId((int)key);
        int result = mapper.insertSelective(bean);
        return result;
    }

    @Override
    public int deleteDataByKey(Integer id) {
        log.debug("Appparamtb,delete: " + id);
        int result = mapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public int updateData(Appparamtb bean) {
        log.debug("Appparamtb,update: " + bean.getAppparamId());
        int result = mapper.updateByPrimaryKeySelective(bean);
        return result;
    }
}
