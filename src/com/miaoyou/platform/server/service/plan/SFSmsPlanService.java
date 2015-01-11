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
import com.miaoyou.platform.server.entity.Sfplansmstb;
import com.miaoyou.platform.server.entity.SfplansmstbExample;
import com.miaoyou.platform.server.entity.child.PlanSmsAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.SfplansmstbMapper;
import com.miaoyou.platform.server.service.patient.PatientServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.user.UserServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SFSmsPlanService implements SFSmsPlanServiceIF {
	public static BeanCopier copier = BeanCopier.create(Sfplansmstb.class,
			PlanSmsAll.class, false);
	private static final Log log = LogFactory.getLog(SFSmsPlanService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SfplansmstbMapper sfplansmstbMapper;

	@Resource
	UserServiceIF userService;
	
	@Resource
	PatientServiceIF patientService;
	


	@Override
	public PlanSmsAll findDataByKey(Long id) {
		log.info("find data:" + id);
		Sfplansmstb plan = sfplansmstbMapper.selectByPrimaryKey(id);
		PlanSmsAll planAll = new PlanSmsAll();
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
	public CommFindEntity<PlanSmsAll> findAll(Pager page, String conditionSql) {
		CommFindEntity<PlanSmsAll> result = new CommFindEntity<PlanSmsAll>();
		List<PlanSmsAll> temp = new ArrayList<>();
		SfplansmstbExample example = new SfplansmstbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		} else {
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = sfplansmstbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("smsplan_id DESC");

		List<Sfplansmstb> ls = sfplansmstbMapper.selectByExample(example);
		if (ls != null) {
			for (Sfplansmstb plan : ls) {
				PlanSmsAll planAll = new PlanSmsAll();
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
	public int saveData(PlanSmsAll bean) {
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

		return sfplansmstbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		return sfplansmstbMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateData(PlanSmsAll bean) {
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
		return sfplansmstbMapper.updateByPrimaryKeySelective(bean);
	}

	

}
