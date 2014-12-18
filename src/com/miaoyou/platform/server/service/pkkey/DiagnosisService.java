package com.miaoyou.platform.server.service.pkkey;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.DiagnosistbMapper;
import com.miaoyou.platform.server.service.CommServiceIF;
import com.miaoyou.platform.server.utils.Pager;

@Service
public class DiagnosisService implements CommServiceIF<Diagnosistb, Long> {
    private static final Log log = LogFactory.getLog(DiagnosisService.class);
    @Resource
    private DiagnosistbMapper mapper;
    
    
	@Override
	public Diagnosistb findDataByKey(Long id) {
		log.debug("findDataByKey:"+id);
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<Diagnosistb> findAll(Pager page, String conditionSql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveData(Diagnosistb bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDataByKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateData(Diagnosistb bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
