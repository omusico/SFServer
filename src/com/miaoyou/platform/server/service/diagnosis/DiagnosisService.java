package com.miaoyou.platform.server.service.diagnosis;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.DiagnosistbExample;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.DiagnosistbMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class DiagnosisService implements DiagnosisServiceIF {
	private static final Log log = LogFactory.getLog(DiagnosisService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	DiagnosistbMapper diagnosistbMapper;

	@Override
	public Diagnosistb findDataByKey(Long id) {
		log.info("find data:" + id);
		return diagnosistbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<Diagnosistb> findAll(Pager page, String conditionSql) {

		CommFindEntity<Diagnosistb> result = new CommFindEntity<Diagnosistb>();
		DiagnosistbExample example = new DiagnosistbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		}else{
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = diagnosistbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("diagnosis_id DESC");

		List<Diagnosistb> ls = diagnosistbMapper.selectByExample(example);
		result.setResult(ls);
		return result;
	}

	@Override
	public int saveData(Diagnosistb bean) {
		log.info("saveData:" + bean.getDiagnosisName());
		long key = pkgeneratorService.getPrimaryKey("diagnosistb",
				"diagnosistb_id");
		bean.setDiagnosisId(key);
		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getDiagnosisName());
		bean.setZujima(zujima);
		
		/* 从session里面获取当前操作的用户 */
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof CommUserDetails) {
				CommUserDetails user = (CommUserDetails) principal;
				UserAll session = user.getUserSessionEntity();
				if (session != null) {
					bean.setCreateperson(session.getUserName());
				}
			}
		}

		return diagnosistbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		Diagnosistb tb = diagnosistbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		return diagnosistbMapper.updateByPrimaryKeySelective(tb);
	}

	@Override
	public int updateData(Diagnosistb bean) {
		log.info("updateData:" + bean.getDiagnosisId());
		bean.setUpdatedate(new Date());
		
		/* 从session里面获取当前操作的用户 */
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof CommUserDetails) {
				CommUserDetails user = (CommUserDetails) principal;
				UserAll session = user.getUserSessionEntity();
				if (session != null) {
					bean.setUpdateperson(session.getUserName());
				}
			}
		}
		return diagnosistbMapper.updateByPrimaryKeySelective(bean);
	}

}
