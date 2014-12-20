package com.miaoyou.platform.server.service.patient;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.PatienttbExample;
import com.miaoyou.platform.server.entity.PatienttbWithBLOBs;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.PatienttbMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class PatientService implements PatientServiceIF{
	private static final Log log = LogFactory.getLog(PatientService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	PatienttbMapper patienttbMapper;
	
	@Override
	public PatienttbWithBLOBs findDataByKey(Long id) {
		log.info("find data:" + id);
		return patienttbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<PatienttbWithBLOBs> findAll(Pager page, String conditionSql) {
		CommFindEntity<PatienttbWithBLOBs> result = new CommFindEntity<PatienttbWithBLOBs>();
		PatienttbExample example = new PatienttbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		}else{
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = patienttbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("patientid DESC");

		List<PatienttbWithBLOBs> ls = patienttbMapper.selectByExampleWithBLOBs(example);
		result.setResult(ls);
		return result;
	}

	@Override
	public int saveData(PatienttbWithBLOBs bean) {
		log.info("saveData:" + bean.getName());
		long key = pkgeneratorService.getPrimaryKey("patienttb",
				"patienttb_id");
		bean.setPatientid(key);
		
		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());
		
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getName());
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

		return patienttbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		PatienttbWithBLOBs tb = patienttbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		return patienttbMapper.updateByPrimaryKeyWithBLOBs(tb);
	}

	@Override
	public int updateData(PatienttbWithBLOBs bean) {
		log.info("updateData:" + bean.getPatientid());
		bean.setUpdatedate(new Date());
		//得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getName());
		bean.setZujima(zujima);
		
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
		return patienttbMapper.updateByPrimaryKeySelective(bean);
	}

}
