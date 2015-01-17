package com.miaoyou.platform.server.service.patient;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Patientsurveytb;
import com.miaoyou.platform.server.entity.PatientsurveytbExample;
import com.miaoyou.platform.server.entity.Rspatientsurveysv;
import com.miaoyou.platform.server.entity.RspatientsurveysvExample;
import com.miaoyou.platform.server.entity.RsplantelsvExample;
import com.miaoyou.platform.server.entity.RsplantelsvKey;
import com.miaoyou.platform.server.entity.SfplanHistorytb;
import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.child.PlanAll;
import com.miaoyou.platform.server.entity.child.PlanHisAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.PatientsurveytbMapper;
import com.miaoyou.platform.server.mapper.RspatientsurveysvMapper;
import com.miaoyou.platform.server.mapper.RsplantelsvMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.plan.SFPlanHisServiceIF;
import com.miaoyou.platform.server.service.plan.SFPlaneServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class PatientSurveyService implements PatientSurveyServiceIF {
	private static final Log log = LogFactory
			.getLog(PatientSurveyService.class);
	public static BeanCopier copier = BeanCopier.create(PlanAll.class,
			PlanHisAll.class, false);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	PatientsurveytbMapper patientsurveytbMapper;
	@Resource
	RspatientsurveysvMapper rspatientsurveysvMapper;
	@Resource
	SFPlaneServiceIF sFPlaneService;

	@Resource
	RsplantelsvMapper rsplantelsvMapper;
	
	@Resource
	SFPlanHisServiceIF sFPlanHisService;

	@Override
	public Patientsurveytb findDataByKey(Long id) {
		log.info("find data:" + id);
		return patientsurveytbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<Patientsurveytb> findAll(Pager page,
			String conditionSql) {
		CommFindEntity<Patientsurveytb> result = new CommFindEntity<Patientsurveytb>();
		PatientsurveytbExample example = new PatientsurveytbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		} else {
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = patientsurveytbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("patientsurvey_id DESC");

		List<Patientsurveytb> ls = patientsurveytbMapper
				.selectByExample(example);
		result.setResult(ls);
		return result;
	}

	@Override
	public int saveData(Patientsurveytb bean) {
		log.info("saveData:" + bean.getSurveryName());

		// 我们先根据survey id，paitient id，plan_id找出是否已经有一份调查问卷了
		PatientsurveytbExample example = new PatientsurveytbExample();
		example.createCriteria().andPatientidEqualTo(bean.getPatientid())
				.andSurveryIdEqualTo(bean.getSurveryId())
				.andPlanIdEqualTo(bean.getPlanId());
		List<Patientsurveytb> lsresult = patientsurveytbMapper
				.selectByExample(example);
		if (lsresult != null && lsresult.size() > 0) {
			Patientsurveytb patiensurtb = lsresult.get(0);
			try {
				BeanUtils.copyProperties(bean, patiensurtb);
			} catch (Exception e) {
				bean = lsresult.get(0);
				log.error(e);
			}

			log.info("found existing survey,no create new one. PatientsurveyId:"
					+ bean.getPatientsurveyId());

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

			return 0;
		} else {
			log.info("not found existing survey,create new one.");
		}

		long key = pkgeneratorService.getPrimaryKey("patientsurveytb",
				"patientsurvey_id");
		bean.setPatientsurveyId(key);

		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());

		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSurveryName());
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
					bean.setUserId(session.getUserId());
					bean.setDepartmentId(session.getDepartmentId());
				}
			}
		}

		return patientsurveytbMapper.insertSelective(bean);
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		Patientsurveytb tb = patientsurveytbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		RspatientsurveysvExample example = new RspatientsurveysvExample();
		example.createCriteria().andPatientsurveyIdEqualTo(id);
		rspatientsurveysvMapper.selectByExample(example);

		return patientsurveytbMapper.updateByPrimaryKeySelective(tb);
	}

	@Override
	public int updateData(Patientsurveytb bean) {
		log.info("updateData:" + bean.getPatientsurveyId());
		bean.setUpdatedate(new Date());
		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		String zujima = PingYinUtil.getFirstSpell(bean.getSurveryName());
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

		int result = patientsurveytbMapper.updateByPrimaryKeySelective(bean);

		// 检查是否还有需要把计划设置为完成状态
		if (bean.getStatus() != 0) {
			long planid = bean.getPlanId();
			log.debug("check if all survey have already been finished.");
			// 找出病人问卷中的所有问卷 planid
			PatientsurveytbExample psurExample = new PatientsurveytbExample();
			psurExample.createCriteria().andPlanIdEqualTo(planid);
			List<Patientsurveytb> patientsurArra = patientsurveytbMapper
					.selectByExample(psurExample);

			// 找出计划关系表中的的数据，该计划总共多少个问卷
			RsplantelsvExample resplanExapl = new RsplantelsvExample();
			resplanExapl.createCriteria().andPlanIdEqualTo(planid);
			List<RsplantelsvKey> rsplanrvLs = rsplantelsvMapper
					.selectByExample(resplanExapl);

			if (patientsurArra != null && rsplanrvLs != null) {
				// 检查是不是每一个问卷都完成了。
				boolean allFinished = false;
				loop1:
				for (RsplantelsvKey rskey : rsplanrvLs) {
					for (Patientsurveytb psvLs : patientsurArra) {
					
						if (rskey.getSurveryId().longValue() == psvLs.getSurveryId().longValue()
								&& psvLs.getStatus().intValue() == 0) { // 还有随访的
							allFinished = false;
							log.debug("set allFinished to false, because survey:"+rskey.getSurveryId()+",status is 0");
							break loop1;
						} else if (rskey.getSurveryId().longValue() == psvLs.getSurveryId().longValue()
								&& psvLs.getStatus().intValue() != 0) { // 还有随访的
							allFinished = true;
							log.debug("set allFinished to true, because survey:"+rskey.getSurveryId()+",status is not 0");
							continue loop1;
						}

					}
					log.debug("all finished?" + allFinished+", because survey:"+rskey.getSurveryId()+",not found.");
					allFinished = false;
					break loop1;
				}

				// 如果都完成，就把该计划做成完成状态
				if (allFinished) {
//					PlanAll sfplan = new PlanAll();
//					sfplan.setPlanId(planid);
//					sfplan.setStatus(1);
//					log.debug("update plan status for " + planid);
//					sFPlaneService.updateData(sfplan);
					
					log.info("move plan data to history table.");
					//把数据插入到历史表中
					for (RsplantelsvKey rskey : rsplanrvLs) {
						sFPlanHisService.saveDataForPatientSurvey(rskey.getPlanId(), rskey.getSurveryId());
						RsplantelsvKey key = new RsplantelsvKey();
						key.setPlanId(rskey.getPlanId());
						key.setSurveryId(rskey.getSurveryId());
						rsplantelsvMapper.deleteByPrimaryKey(key);
					}
					
					PlanAll sfplan = sFPlaneService.findDataByKey(planid);
					sfplan.setStatus(1);
					PlanHisAll hisAll = new PlanHisAll();
					copier.copy(sfplan, hisAll, null);
					sFPlanHisService.saveData(hisAll);
					
					sFPlaneService.deleteDataByKey(planid);
					log.info("move plan data to history table.==>done");
				}
			}

		}

		return result;
	}

	@Override
	public int saveAnwser(Long patientsurveyId, SurveyDetailtb surveyDetailtb) {
		log.info("saveAnwser:" + surveyDetailtb.getSurverydetailName());
		Rspatientsurveysv key = new Rspatientsurveysv();
		key.setPatientsurveyId(patientsurveyId);
		key.setSurverydetailAnswer(surveyDetailtb.getSurverydetailAnswer());
		key.setSurverydetailName(surveyDetailtb.getSurverydetailName());
		return rspatientsurveysvMapper.insertSelective(key);
	}

	@Override
	public CommFindEntity<Rspatientsurveysv> findAllAnwser(Pager page,
			Long patientsurveyId) {
		log.info("findAllAnwser:" + patientsurveyId);

		CommFindEntity<Rspatientsurveysv> result = new CommFindEntity<Rspatientsurveysv>();
		RspatientsurveysvExample example = new RspatientsurveysvExample();
		if (patientsurveyId > 0) {
			example.createCriteria().andPatientsurveyIdEqualTo(patientsurveyId);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = rspatientsurveysvMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("patientsurvey_id DESC");

		List<Rspatientsurveysv> ls = rspatientsurveysvMapper
				.selectByExample(example);
		result.setResult(ls);

		return result;
	}

}
