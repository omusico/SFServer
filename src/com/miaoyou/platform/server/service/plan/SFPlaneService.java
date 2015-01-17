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

import com.miaoyou.platform.server.entity.Patientsurveytb;
import com.miaoyou.platform.server.entity.PatientsurveytbExample;
import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.RsplantelsvExample;
import com.miaoyou.platform.server.entity.RsplantelsvKey;
import com.miaoyou.platform.server.entity.Sfplantb;
import com.miaoyou.platform.server.entity.SfplantbExample;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.PlanAll;
import com.miaoyou.platform.server.entity.child.PlanHisAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.PatientsurveytbMapper;
import com.miaoyou.platform.server.mapper.RsplantelsvMapper;
import com.miaoyou.platform.server.mapper.SfplantbMapper;
import com.miaoyou.platform.server.service.patient.PatientServiceIF;
import com.miaoyou.platform.server.service.patient.PatientSurveyServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.survey.SurveyServiceIF;
import com.miaoyou.platform.server.service.user.UserServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class SFPlaneService implements SFPlaneServiceIF {
	public static BeanCopier copier = BeanCopier.create(Sfplantb.class,
			PlanAll.class, false);
	public static BeanCopier copierToHisPlan = BeanCopier.create(PlanAll.class,
			PlanHisAll.class, false);
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

	@Resource
	PatientsurveytbMapper patientsurveytbMapper;

	@Resource
	SFPlanHisServiceIF sFPlanHisService;

	@Override
	public PlanAll findDataByKey(Long id) {
		log.info("find data:" + id);
		Sfplantb plan = sfplantbMapper.selectByPrimaryKey(id);
		PlanAll planAll = new PlanAll();
		if (plan != null) {
			copier.copy(plan, planAll, null);
			if (plan.getUserId() != null && plan.getUserId() > 0) {
				// 查询出用户用户信息
				UserAll userAll = userService.findUserAll(plan.getUserId());
				planAll.setUserAll(userAll);

				Patienttb patient = patientService.findDataByKey(plan
						.getPatientid());
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
				if (plan.getUserId() != null && plan.getUserId() > 0) {
					// 查询出用户用户信息
					UserAll userAll = userService.findUserAll(plan.getUserId());
					planAll.setUserAll(userAll);

					Patienttb patient = patientService.findDataByKey(plan
							.getPatientid());
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
		log.info("updateData:" + bean.getPlanId());
		bean.setUpdatedate(new Date());
		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		if (bean.getPlanname() != null && !bean.getPlanname().trim().equals("")) {
			String zujima = PingYinUtil.getFirstSpell(bean.getPlanname());
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
		int result = sfplantbMapper.updateByPrimaryKeySelective(bean);
		if (bean.getStatus() != 0) {
			// 找出计划关系表中的的数据，该计划总共多少个问卷
			RsplantelsvExample resplanExapl = new RsplantelsvExample();
			resplanExapl.createCriteria().andPlanIdEqualTo(bean.getPlanId());
			List<RsplantelsvKey> rsplanrvLs = rsplantelsvMapper
					.selectByExample(resplanExapl);

			if (rsplanrvLs != null) {
				log.info("move plan data to history table.");
				String[] STATUS_PLAN_TEL = new String[] { "计划中", "已经完成",
						"手动作废", "自动过期" };
				PatientsurveytbExample example = new PatientsurveytbExample();
				example.createCriteria()
						.andPatientidEqualTo(bean.getPatientid())
						.andPlanIdEqualTo(bean.getPlanId());
				List<Patientsurveytb> patientsurs = patientsurveytbMapper
						.selectByExample(example);
				if (patientsurs != null) {
					for (Patientsurveytb ps : patientsurs) {
						if (ps.getStatus() == 0) {// 把已经开始随访的计划，状态为随访中的病人问卷，状态设置为手动作废。
							ps.setStatus(bean.getStatus());
							log.debug("updated patientsurveytb because plan was canceled.");
							patientsurveytbMapper.updateByPrimaryKey(ps);
						}
					}
				}

				// 把数据插入到历史表中
				for (RsplantelsvKey rskey : rsplanrvLs) {
					sFPlanHisService.saveDataForPatientSurvey(
							rskey.getPlanId(), rskey.getSurveryId());
					RsplantelsvKey key = new RsplantelsvKey();
					key.setPlanId(rskey.getPlanId());
					key.setSurveryId(rskey.getSurveryId());
					rsplantelsvMapper.deleteByPrimaryKey(key);
				}

				PlanHisAll hisAll = new PlanHisAll();

				PlanAll sfplan = findDataByKey(bean.getPlanId());
				copierToHisPlan.copy(sfplan, hisAll, null);

				hisAll.setStatus(bean.getStatus());
				if (bean.getStatus() > 3) {
					hisAll.setRemark(hisAll.getRemark() + ". 未知原因");
				} else {
					hisAll.setRemark(hisAll.getRemark() + ". "
							+ STATUS_PLAN_TEL[bean.getStatus()]);
				}
				sFPlanHisService.saveData(hisAll);

				deleteDataByKey(bean.getPlanId());// 删除已经移到历史表中的数据
				log.info("move plan data to history table.==>done");
			}
		}

		return result;
	}

	@Override
	public CommFindEntity<Surveytb> findSurveyByPlanId(Long planId) {
		log.info("findSurveyByPlanId:" + planId);
		CommFindEntity<Surveytb> result = new CommFindEntity<Surveytb>();
		List<Surveytb> surveryArray = new ArrayList<>();
		result.setResult(surveryArray);

		RsplantelsvExample example = new RsplantelsvExample();
		example.createCriteria().andPlanIdEqualTo(planId);
		List<RsplantelsvKey> plantelKey = rsplantelsvMapper
				.selectByExample(example);
		if (plantelKey != null) {
			for (RsplantelsvKey key : plantelKey) {
				Surveytb array = surveyService
						.findDataByKey(key.getSurveryId());
				surveryArray.add(array);
			}
		}
		result.setCount(surveryArray.size());
		return result;
	}

	@Override
	public CommFindEntity<Surveytb> findSurveyByPlanIdForCalling(int status,
			Long planId) {
		log.info("findSurveyByPlanId:" + planId);
		CommFindEntity<Surveytb> result = new CommFindEntity<Surveytb>();
		List<Surveytb> surveryArray = new ArrayList<>();
		result.setResult(surveryArray);

		PatientsurveytbExample psurExample = new PatientsurveytbExample();
		psurExample.createCriteria().andPlanIdEqualTo(planId);
		List<Patientsurveytb> patientSurLs = patientsurveytbMapper
				.selectByExample(psurExample);

		RsplantelsvExample example = new RsplantelsvExample();
		example.createCriteria().andPlanIdEqualTo(planId);
		List<RsplantelsvKey> plantelKey = rsplantelsvMapper
				.selectByExample(example);
		if (plantelKey != null) {
			loop1: for (RsplantelsvKey key : plantelKey) {
				long surveyId = key.getSurveryId();
				if (patientSurLs != null && patientSurLs.size() > 0) {
					for (Patientsurveytb psui : patientSurLs) {
						if (psui.getSurveryId() == surveyId
								&& psui.getStatus() != status) {
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
		RsplantelsvKey sv = new RsplantelsvKey();
		sv.setPlanId(planId);
		sv.setSurveryId(surveryId);

		// 剔除一样的计划和调查问卷
		RsplantelsvExample example = new RsplantelsvExample();
		example.createCriteria().andPlanIdEqualTo(planId)
				.andSurveryIdEqualTo(surveryId);
		int count = rsplantelsvMapper.countByExample(example);
		if (count > 0) {
			log.warn("" + count + " are existing here, not insert new.");
			return 0;
		}

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
