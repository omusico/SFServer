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

import com.miaoyou.platform.server.entity.PatienttbWithBLOBs;
import com.miaoyou.platform.server.entity.Rsplantelsv;
import com.miaoyou.platform.server.entity.RsplantelsvExample;
import com.miaoyou.platform.server.entity.Sfplantb;
import com.miaoyou.platform.server.entity.SfplantbExample;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.PlanAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.RsplantelsvMapper;
import com.miaoyou.platform.server.mapper.SfplantbMapper;
import com.miaoyou.platform.server.service.patient.PatientServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.survey.SurveyServiceIF;
import com.miaoyou.platform.server.service.user.UserServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SFPlaneService implements SFPlaneServiceIF {
	public static BeanCopier copier = BeanCopier.create(Sfplantb.class,
			PlanAll.class, false);
	private static final Log log = LogFactory.getLog(SFPlaneService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SfplantbMapper sfplantbMapper;

	@Resource
	RsplantelsvMapper rsplantelsvMapper;

	@Resource
	SurveyServiceIF surveyService;

	@Resource
	UserServiceIF userService;
	
	@Resource
	PatientServiceIF patientService;

	@Override
	public PlanAll findDataByKey(Long id) {
		log.info("find data:" + id);
		Sfplantb plan = sfplantbMapper.selectByPrimaryKey(id);
		PlanAll planAll = new PlanAll();
		if (plan != null) {
			copier.copy(plan, planAll, null);
			if (plan.getUserId()!=null&&plan.getUserId() > 0) {
				// 查询出用户用户信息
				UserAll userAll = userService.findUserAll(plan.getUserId());
				planAll.setUserAll(userAll);
				
				PatienttbWithBLOBs patient = patientService.findDataByKey(plan.getPatientid());
				planAll.setPatienttb(patient);
			}
		}
		return planAll;
	}

	@Override
	public CommFindEntity<PlanAll> findAll(Pager page, String conditionSql) {
		CommFindEntity<PlanAll> result = new CommFindEntity<PlanAll>();
		List<PlanAll> temp = new ArrayList<>();
		SfplantbExample example = new SfplantbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		} else {
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = sfplantbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("plan_id DESC");

		List<Sfplantb> ls = sfplantbMapper.selectByExample(example);
		if (ls != null) {
			for (Sfplantb plan : ls) {
				PlanAll planAll = new PlanAll();
				copier.copy(plan, planAll, null);
				// 查询出用户用户信息
				if (plan.getUserId()!=null&&plan.getUserId() > 0) {
					// 查询出用户用户信息
					UserAll userAll = userService.findUserAll(plan.getUserId());
					planAll.setUserAll(userAll);
					
					PatienttbWithBLOBs patient = patientService.findDataByKey(plan.getPatientid());
					planAll.setPatienttb(patient);
				}
				temp.add(planAll);
			}
		}
		result.setResult(temp);
		return result;
	}

	@Override
	public int saveData(PlanAll bean) {
		log.info("saveData:" + bean.getPlanname());
		long key = pkgeneratorService.getPrimaryKey("sfplantb", "plan_id");
		bean.setPlanId(key);

		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());

		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getPlanname());
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

		return sfplantbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		Sfplantb tb = sfplantbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		return sfplantbMapper.updateByPrimaryKeySelective(tb);
	}

	@Override
	public int updateData(PlanAll bean) {
		log.info("updateData:" + bean.getPlanname());
		bean.setUpdatedate(new Date());
		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getPlanname());
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
		return sfplantbMapper.updateByPrimaryKeySelective(bean);
	}

	@Override
	public CommFindEntity<Surveytb> findSurveyByPlanId(Long planId) {
		log.info("findSurveyByPlanId:" + planId);
		CommFindEntity<Surveytb> result = new CommFindEntity<Surveytb>();
		List<Surveytb> surveryArray = new ArrayList<>();
		result.setResult(surveryArray);

		RsplantelsvExample example = new RsplantelsvExample();
		example.createCriteria().andPlanIdEqualTo(planId);
		List<Rsplantelsv> plantelKey = rsplantelsvMapper
				.selectByExample(example);
		if (plantelKey != null) {
			for (Rsplantelsv key : plantelKey) {
				Surveytb array = surveyService
						.findDataByKey(key.getSurveryId());
				surveryArray.add(array);
			}
		}
		result.setCount(surveryArray.size());
		return result;
	}

	@Override
	public int saveDataForPatientSurvey(Long planId, Long surveryId) {
		log.info("saveData,planId:" + planId + ",survey:" + surveryId);
		Rsplantelsv sv = new Rsplantelsv();
		sv.setPlanId(planId);
		sv.setSurveryId(surveryId);
		return rsplantelsvMapper.insert(sv);
	}

	@Override
	public int deleteDataByKeyForPatientSurvey(Long planId, Long surveryId) {
		log.info("deleteDataByKey,planId:" + planId + ",survey:" + surveryId);
		RsplantelsvExample example = new RsplantelsvExample();
		example.createCriteria().andPlanIdEqualTo(planId)
				.andSurveryIdEqualTo(surveryId);
		return rsplantelsvMapper.deleteByExample(example);
	}

}
