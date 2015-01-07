package com.miaoyou.platform.server.service.sms;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Smstb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.SmstbMapper;
import com.miaoyou.platform.server.service.CommServiceIF;
import com.miaoyou.platform.server.utils.Pager;

@Service
public class SMSService implements CommServiceIF<Smstb, Long>{
	
	private static final Log log = LogFactory.getLog(SMSService.class);
	
	@Resource
	SmstbMapper smstbMapper;

	@Override
	public Smstb findDataByKey(Long id) {
		log.info("findDataByKey:"+id);
		return smstbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<Smstb> findAll(Pager page, String conditionSql) {
		log.info("findDataByKey:"+conditionSql);
		
		return null;
	}

	@Override
	public int saveData(Smstb bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDataByKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateData(Smstb bean) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
