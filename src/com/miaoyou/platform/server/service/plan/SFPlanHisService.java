package com.miaoyou.platform.server.service.plan;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Patientsurveytb;
import com.miaoyou.platform.server.entity.PatientsurveytbExample;
import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.RsplantelsvHistoryExample;
import com.miaoyou.platform.server.entity.RsplantelsvHistoryKey;
import com.miaoyou.platform.server.entity.SfplanHistorytb;
import com.miaoyou.platform.server.entity.SfplanHistorytbExample;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.PlanHisAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.PatientsurveytbMapper;
import com.miaoyou.platform.server.mapper.RsplantelsvHistoryMapper;
import com.miaoyou.platform.server.mapper.SfplanHistorytbMapper;
import com.miaoyou.platform.server.service.patient.PatientServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.survey.SurveyServiceIF;
import com.miaoyou.platform.server.service.user.UserServiceIF;
import com.miaoyou.platform.server.utils.Pager;

@Service
public class SFPlanHisService implements SFPlanHisServiceIF {
	public static BeanCopier copier = BeanCopier.create(SfplanHistorytb.class,
			PlanHisAll.class, false);
	private static final Log log = LogFactory.getLog(SFPlanHisService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SfplanHistorytbMapper sfplanHistorytbMapper;

	@Resource
	RsplantelsvHistoryMapper rsplantelsvHistoryMapper;

	@Resource
	SurveyServiceIF surveyService;

	@Resource
	UserServiceIF userService;
	
	@Resource
	PatientServiceIF patientService;
	
	@Resource
	PatientsurveytbMapper patientsurveytbMapper;

	@Override
	public PlanHisAll findDataByKey(Long id) {
		log.info("find data:" + id);
		SfplanHistorytb plan = sfplanHistorytbMapper.selectByPrimaryKey(id);
		PlanHisAll planAll = new PlanHisAll();
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
	public CommFindEntity<PlanHisAll> findAll(Pager page, String conditionSql) {
		CommFindEntity<PlanHisAll> result = new CommFindEntity<PlanHisAll>();
		List<PlanHisAll> temp = new ArrayList<>();
		SfplanHistorytbExample example = new SfplanHistorytbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		} else {
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = sfplanHistorytbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("plan_id DESC");

		List<SfplanHistorytb> ls = sfplanHistorytbMapper.selectByExample(example);
		if (ls != null) {
			for (SfplanHistorytb plan : ls) {
				PlanHisAll planAll = new PlanHisAll();
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
	public int saveData(PlanHisAll bean) {
		log.info("saveData:" + bean.getPlanname());
		return sfplanHistorytbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		return sfplanHistorytbMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateData(PlanHisAll bean) {
		log.info("updateData:" + bean.getPlanId());
		return sfplanHistorytbMapper.updateByPrimaryKeySelective(bean);
	}

	@Override
	public CommFindEntity<Surveytb> findSurveyByPlanId(Long planId) {
		log.info("findSurveyByPlanId:" + planId);
		CommFindEntity<Surveytb> result = new CommFindEntity<Surveytb>();
		List<Surveytb> surveryArray = new ArrayList<>();
		result.setResult(surveryArray);

		RsplantelsvHistoryExample example = new RsplantelsvHistoryExample();
		example.createCriteria().andPlanIdEqualTo(planId);
		List<RsplantelsvHistoryKey> plantelKey = rsplantelsvHistoryMapper
				.selectByExample(example);
		if (plantelKey != null) {
			for (RsplantelsvHistoryKey key : plantelKey) {
				Surveytb array = surveyService
						.findDataByKey(key.getSurveryId());
				surveryArray.add(array);
			}
		}
		result.setCount(surveryArray.size());
		return result;
	}
	
	
	@Override
	public CommFindEntity<Surveytb> findSurveyByPlanIdForCalling(int status,Long planId) {
		log.info("findSurveyByPlanId:" + planId);
		CommFindEntity<Surveytb> result = new CommFindEntity<Surveytb>();
		List<Surveytb> surveryArray = new ArrayList<>();
		result.setResult(surveryArray);

		PatientsurveytbExample psurExample = new PatientsurveytbExample();
		psurExample.createCriteria().andPlanIdEqualTo(planId);
		List<Patientsurveytb> patientSurLs=patientsurveytbMapper.selectByExample(psurExample);
		
		
		RsplantelsvHistoryExample example = new RsplantelsvHistoryExample();
		example.createCriteria().andPlanIdEqualTo(planId);
		List<RsplantelsvHistoryKey> plantelKey = rsplantelsvHistoryMapper.selectByExample(example);
		if (plantelKey != null) {
			loop1:for (RsplantelsvHistoryKey key : plantelKey) {
				long surveyId = key.getSurveryId();
				if(patientSurLs!=null&&patientSurLs.size()>0){
					for(Patientsurveytb psui:patientSurLs){
						if(psui.getSurveryId()==surveyId&&psui.getStatus()!=status){
							continue loop1;
						}
					}
				}
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
		RsplantelsvHistoryKey sv = new RsplantelsvHistoryKey();
		sv.setPlanId(planId);
		sv.setSurveryId(surveryId);
		
		
		//剔除一样的计划和调查问卷
		RsplantelsvHistoryExample example = new RsplantelsvHistoryExample();
		example.createCriteria().andPlanIdEqualTo(planId).andSurveryIdEqualTo(surveryId);
		int count = rsplantelsvHistoryMapper.countByExample(example);
		if(count>0){
			log.warn(""+count+" are existing here, not insert new.");
			return 0;
		}
		
		return rsplantelsvHistoryMapper.insert(sv);
	}

	@Override
	public int deleteDataByKeyForPatientSurvey(Long planId, Long surveryId) {
		log.info("deleteDataByKey,planId:" + planId + ",survey:" + surveryId);
		RsplantelsvHistoryExample example = new RsplantelsvHistoryExample();
		example.createCriteria().andPlanIdEqualTo(planId)
				.andSurveryIdEqualTo(surveryId);
		return rsplantelsvHistoryMapper.deleteByExample(example);
	}

}
