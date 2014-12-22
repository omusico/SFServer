package com.miaoyou.platform.server.service.diagnosis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.Rskeshidns;
import com.miaoyou.platform.server.entity.RskeshidnsExample;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.DepartmenttbMapper;
import com.miaoyou.platform.server.mapper.DiagnosistbMapper;
import com.miaoyou.platform.server.mapper.RskeshidnsMapper;
import com.miaoyou.platform.server.utils.Pager;

@Service
public class KeshiDiagnosisService implements KeshiDiagnosisServiceIF {
	private static final Log log = LogFactory
			.getLog(KeshiDiagnosisService.class);
	@Resource
	DiagnosistbMapper diagnosistbMapper;

	@Resource
	DepartmenttbMapper departmenttbMapper;

	@Resource
	RskeshidnsMapper rskeshidnsMapper;

	@Override
	public CommFindEntity<Diagnosistb> findDns(Pager pager, Integer departmentId) {
		log.info("findDns:" + departmentId);
		CommFindEntity<Diagnosistb> result = new CommFindEntity<Diagnosistb>();
		List<Diagnosistb> lsArray = new ArrayList<>();
		result.setResult(lsArray);
		RskeshidnsExample example = new RskeshidnsExample();
		example.createCriteria().andDepartmentIdEqualTo(departmentId);

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = rskeshidnsMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		pager.setCount(count);
		example.setLimitStart(pager.getStartDataIndex());
		example.setLimitEnd(pager.getPageSize());

		List<Rskeshidns> rsArray = rskeshidnsMapper.selectByExample(example);
		if (rsArray != null) {
			log.debug("size:" + rsArray.size());
			for (Rskeshidns rsk : rsArray) {
				Diagnosistb dns = diagnosistbMapper.selectByPrimaryKey(rsk
						.getDiagnosisId());
				lsArray.add(dns);
			}
		}
		return result;
	}

	@Override
	public CommFindEntity<Departmenttb> findDep(Pager pager, Long diagnosisId) {
		log.info("findDep:" + diagnosisId);
		CommFindEntity<Departmenttb> result = new CommFindEntity<Departmenttb>();
		List<Departmenttb> lsArray = new ArrayList<>();
		result.setResult(lsArray);
		RskeshidnsExample example = new RskeshidnsExample();
		example.createCriteria().andDiagnosisIdEqualTo(diagnosisId);

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = rskeshidnsMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		pager.setCount(count);
		example.setLimitStart(pager.getStartDataIndex());
		example.setLimitEnd(pager.getPageSize());

		List<Rskeshidns> rsArray = rskeshidnsMapper.selectByExample(example);
		if (rsArray != null) {
			log.debug("size:" + rsArray.size());
			for (Rskeshidns rsk : rsArray) {
				Departmenttb dns = departmenttbMapper.selectByPrimaryKey(rsk
						.getDepartmentId());
				lsArray.add(dns);
			}
		}
		return null;
	}

	@Override
	public int saveKeshiDns(Integer departmentId, Long diagnosisId) {
		Rskeshidns dns = new Rskeshidns();
		log.info("saveKeshiDns:" + departmentId + ",diagnosisId:" + diagnosisId);
		dns.setDepartmentId(departmentId);
		dns.setDiagnosisId(diagnosisId);
		return rskeshidnsMapper.insert(dns);
	}

	@Override
	public int deleteKeshiDns(Integer departmentId, Long diagnosisId) {
		log.info("deleteKeshiDns:" + departmentId + ",diagnosisId:"
				+ diagnosisId);
		RskeshidnsExample example = new RskeshidnsExample();
		example.createCriteria().andDepartmentIdEqualTo(departmentId)
				.andDiagnosisIdEqualTo(diagnosisId);
		return rskeshidnsMapper.deleteByExample(example);
	}
	
	@Override
	public int deleteKeshiByDns(Long diagnosisId) {
		log.info("deleteKeshiDns diagnosisId:"+ diagnosisId);
		RskeshidnsExample example = new RskeshidnsExample();
		example.createCriteria().andDiagnosisIdEqualTo(diagnosisId);
		return rskeshidnsMapper.deleteByExample(example);
	}

}
