package com.miaoyou.platform.server.service.patient;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.DepartmenttbExample;
import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.DiagnosistbExample;
import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.PatienttbExample;
import com.miaoyou.platform.server.entity.Rspatientdpdns;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.UsertbExample;
import com.miaoyou.platform.server.entity.child.PatienttbRecordCase;
import com.miaoyou.platform.server.entity.child.PlanAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.DepartmenttbMapper;
import com.miaoyou.platform.server.mapper.DiagnosistbMapper;
import com.miaoyou.platform.server.mapper.PatienttbMapper;
import com.miaoyou.platform.server.mapper.RspatientdpdnsMapper;
import com.miaoyou.platform.server.mapper.UsertbMapper;
import com.miaoyou.platform.server.service.diagnosis.DiagnosisSurveyServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.plan.SFPlaneServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class PatientService implements PatientServiceIF {
	private static final Log log = LogFactory.getLog(PatientService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	PatienttbMapper patienttbMapper;

	@Resource
	DepartmenttbMapper departmenttbMapper;

	@Resource
	DiagnosistbMapper diagnosistbMapper;

	@Resource
	RspatientdpdnsMapper rspatientdpdnsMapper;

	@Resource
	DiagnosisSurveyServiceIF diagnosisSurveyService;

	@Resource
	SFPlaneServiceIF sFPlaneService;
	
    @Resource
    private UsertbMapper mapper;

	@Override
	public Patienttb findDataByKey(Long id) {
		log.info("find data:" + id);
		return patienttbMapper.selectByPrimaryKey(id);
	}

	@Override
	public CommFindEntity<Patienttb> findAll(Pager page,
			String conditionSql) {
		CommFindEntity<Patienttb> result = new CommFindEntity<Patienttb>();
		PatienttbExample example = new PatienttbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		} else {
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

		List<Patienttb> ls = patienttbMapper
				.selectByExample(example);
		result.setResult(ls);
		return result;
	}

	@Override
	public int saveData(Patienttb bean) {
		log.info("save patient data:" + bean.getName());
		long key = pkgeneratorService
				.getPrimaryKey("patienttb", "patienttb_id");
		bean.setPatientid(key);

		bean.setDeleteFlag(0);
		bean.setCreatedate(new Date());

		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
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

		//savePatientDpDns(bean);

		//log.info("relationship done. start to insert to database for patient.");
		return patienttbMapper.insertSelective(bean);
	}

//	/**
//	 * 这里主要是根据输入的患者数据，系统自动自动创建计划任务
//	 * @param bean
//	 */
//	private void savePatientDpDns(Patienttb bean) {
//		long patientId = bean.getPatientid();
//		String dnsList = bean.getChuyuanzhengduan();
//		String department = bean.getKeshi();
//		log.info("try to insert relationship for patient,deparment,diagnosistb");
//		if (dnsList != null && !dnsList.trim().equals("") && department != null
//				&& !department.trim().equals("")) {
//
//			/* 首先查询出部门 */
//			DepartmenttbExample dpExample = new DepartmenttbExample();
//			dpExample.createCriteria().andDepartmentNameLike(
//					"%" + department.trim() + "%");
//			List<Departmenttb> deparArray = departmenttbMapper
//					.selectByExample(dpExample);
//			if (deparArray != null && deparArray.size() > 0) {
//				log.info("found department count:" + deparArray.size()
//						+ " for " + department + ", we only fetch one");
//				Departmenttb depart = deparArray.get(0);
//				String[] arrayDns = dnsList.split("#");
//
//				/* 为每个患者默认创建一个计划 */
//				PlanAll sfPlan = new PlanAll();
//				sfPlan.setPlanname("默认电话随访计划");
//				sfPlan.setPatientid(patientId);
//
//				// 这里应该把任务默认分配给该用户的住院医生
//				String zhuyuanyisheng = bean.getZhuyuanyisheng();
//				if(zhuyuanyisheng!=null&&!zhuyuanyisheng.trim().equals("")){
//					log.info("try to find out the resident doctor.");
//					UsertbExample example = new UsertbExample();
//					example.createCriteria().andUserNameLike(zhuyuanyisheng+"%");
//					List<Usertb> usertbs = mapper.selectByExample(example);
//					if(usertbs!=null&&usertbs.size()>0){
//						Usertb user = usertbs.get(0);
//						log.info("found user:"+user.getUserName());
//						sfPlan.setUserId(user.getUserId());
//					}
//				}
//
//				sFPlaneService.saveData(sfPlan);
//
//				for (String dns : arrayDns) {
//					DiagnosistbExample dnsexample = new DiagnosistbExample();
//					dnsexample.createCriteria().andDiagnosisNameLike(
//							"%" + dns.trim() + "%");
//					List<Diagnosistb> dnsArray = diagnosistbMapper
//							.selectByExample(dnsexample);
//					if (dnsArray != null && dnsArray.size() > 0) {
//						log.info("found diagnosis count:" + dnsArray.size()
//								+ ",for " + dns + ", we only fetch one");
//						Diagnosistb gotdns = dnsArray.get(0);
//
//						Rspatientdpdns rspatientdpdns = new Rspatientdpdns();
//						rspatientdpdns
//								.setDepartmentId(depart.getDepartmentId());
//						rspatientdpdns.setDiagnosisId(gotdns.getDiagnosisId());
//						rspatientdpdns.setPatientid(patientId);
//						log.info("create relationship,patient:"
//								+ rspatientdpdns.getPatientid() + ",diagnosis"
//								+ rspatientdpdns.getDiagnosisId()
//								+ ", department:"
//								+ rspatientdpdns.getDepartmentId());
//						rspatientdpdnsMapper.insert(rspatientdpdns);
//
//						try {
//							/* 为每个病患插入相关的调查问卷 */
//							CommFindEntity<Surveytb> modelEntity = diagnosisSurveyService
//									.findAllSurveyWithAddedSurvey(
//											rspatientdpdns.getDiagnosisId(),
//											rspatientdpdns.getDepartmentId());
//							if (modelEntity != null
//									&& modelEntity.getResult() != null
//									&& modelEntity.getResult().size() > 0) {
//								List<Surveytb> surveys = modelEntity
//										.getResult();
//								log.debug("found findAllSurveyWithAddedSurvey count:"
//										+ surveys.size());
//								for (Surveytb sur : surveys) {
//									log.debug("add survey:"
//											+ sur.getSurveryId() + ",for "
//											+ patientId);
//									sFPlaneService.saveDataForPatientSurvey(
//											sfPlan.getPlanId(),
//											sur.getSurveryId());
//								}
//							}
//						} catch (Exception e) {
//							log.error(e);
//						}
//
//						continue;
//					} else {
//						log.warn("not found diagnosis for :" + dns);
//					}
//
//				}
//			} else {
//				log.warn("not found department, can not insert the rs_patient_dp_dns");
//			}
//		} else {
//			log.warn("dnsList or department is not correct");
//		}
//	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		Patienttb tb = patienttbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		return patienttbMapper.updateByPrimaryKey(tb);
	}

	@Override
	public int updateData(Patienttb bean) {
		log.info("updateData:" + bean.getPatientid());
		bean.setUpdatedate(new Date());
		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
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
