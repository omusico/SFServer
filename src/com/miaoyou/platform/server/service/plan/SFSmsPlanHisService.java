package com.miaoyou.platform.server.service.plan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.SfplansmsHistorytb;
import com.miaoyou.platform.server.entity.SfplansmsHistorytbExample;
import com.miaoyou.platform.server.entity.child.PlanSmsHisAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.SfplansmsHistorytbMapper;
import com.miaoyou.platform.server.service.patient.PatientServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.user.UserServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SFSmsPlanHisService implements SFSmsPlanHisServiceIF {
	public static BeanCopier copier = BeanCopier.create(SfplansmsHistorytb.class,
			PlanSmsHisAll.class, false);
	private static final Log log = LogFactory.getLog(SFSmsPlanHisService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SfplansmsHistorytbMapper sfplansmsHistorytbMapper;

	@Resource
	UserServiceIF userService;
	
	@Resource
	PatientServiceIF patientService;
	


	@Override
	public PlanSmsHisAll findDataByKey(Long id) {
		log.info("find data:" + id);
		SfplansmsHistorytb plan = sfplansmsHistorytbMapper.selectByPrimaryKey(id);
		PlanSmsHisAll planAll = new PlanSmsHisAll();
		if (plan != null) {
			copier.copy(plan, planAll, null);
			if (plan.getUserId()!=null&&plan.getUserId() > 0) {
				// 查询出用户用户信息
				UserAll userAll = userService.findUserAll(plan.getUserId());
				planAll.setUserAll(userAll);
				
				Patienttb patient = patientService.findDataByKey(plan.getPatientid());
				planAll.setPatienttb(patient);
			}
		}
		return planAll;
	}

	@Override
	public CommFindEntity<PlanSmsHisAll> findAll(Pager page, String conditionSql) {
		CommFindEntity<PlanSmsHisAll> result = new CommFindEntity<PlanSmsHisAll>();
		List<PlanSmsHisAll> temp = new ArrayList<>();
		SfplansmsHistorytbExample example = new SfplansmsHistorytbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		} else {
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = sfplansmsHistorytbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("smsplan_id DESC");

		List<SfplansmsHistorytb> ls = sfplansmsHistorytbMapper.selectByExample(example);
		if (ls != null) {
			for (SfplansmsHistorytb plan : ls) {
				PlanSmsHisAll planAll = new PlanSmsHisAll();
				copier.copy(plan, planAll, null);
				// 查询出用户用户信息
				if (plan.getUserId()!=null&&plan.getUserId() > 0) {
					// 查询出用户用户信息
					UserAll userAll = userService.findUserAll(plan.getUserId());
					planAll.setUserAll(userAll);
					
					Patienttb patient = patientService.findDataByKey(plan.getPatientid());
					planAll.setPatienttb(patient);
				}
				temp.add(planAll);
			}
		}
		result.setResult(temp);
		return result;
	}

	@Override
	public int saveData(PlanSmsHisAll bean) {
		log.info("saveData:" + bean.getSmscontext());
		long key = pkgeneratorService.getPrimaryKey("sfsmsplantb", "smsplan_id");
		bean.setSmsplanId(key);

		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());

		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSmscontext());
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

		return sfplansmsHistorytbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		return sfplansmsHistorytbMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateData(PlanSmsHisAll bean) {
		log.info("updateData:" + bean.getSmsplanId());
		bean.setUpdatedate(new Date());
		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		if(bean.getSmscontext()!=null&&!bean.getSmscontext().trim().equals("")){
		String zujima = PingYinUtil.getFirstSpell(bean.getSmscontext());
		bean.setZujima(zujima);
		}

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
		return sfplansmsHistorytbMapper.updateByPrimaryKeySelective(bean);
	}

	

}
