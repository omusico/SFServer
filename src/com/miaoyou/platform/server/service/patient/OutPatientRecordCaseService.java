package com.miaoyou.platform.server.service.patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

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
import com.miaoyou.platform.server.entity.RecordcaseopdtbExample;
import com.miaoyou.platform.server.entity.RspatientdpdnsExample;
import com.miaoyou.platform.server.entity.RecordcaseopdtbExample.Criteria;
import com.miaoyou.platform.server.entity.RecordcaseopdtbWithBLOBs;
import com.miaoyou.platform.server.entity.Rspatientdpdns;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.UsertbExample;
import com.miaoyou.platform.server.entity.child.OutPatienttbRecordCase;
import com.miaoyou.platform.server.entity.child.PlanAll;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.DepartmenttbMapper;
import com.miaoyou.platform.server.mapper.DiagnosistbMapper;
import com.miaoyou.platform.server.mapper.PatienttbMapper;
import com.miaoyou.platform.server.mapper.RecordcaseopdtbMapper;
import com.miaoyou.platform.server.mapper.RspatientdpdnsMapper;
import com.miaoyou.platform.server.mapper.UsertbMapper;
import com.miaoyou.platform.server.service.diagnosis.DiagnosisSurveyServiceIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.plan.SFPlaneServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class OutPatientRecordCaseService implements OutPatientRecordCaseServiceIF {

	public static BeanCopier copier = BeanCopier.create(
			RecordcaseopdtbWithBLOBs.class, OutPatienttbRecordCase.class, false);

	private static final Log log = LogFactory
			.getLog(OutPatientRecordCaseService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	PatientServiceIF patientService;

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

	@Resource
	private RecordcaseopdtbMapper recordcaseopdtbMapper;

	@Resource
	PatienttbMapper patienttbMapper;

	@Override
	public OutPatienttbRecordCase findDataByKey(Long id) {
		OutPatienttbRecordCase all = new OutPatienttbRecordCase();
		log.info("find data:" + id);
		RecordcaseopdtbWithBLOBs records = recordcaseopdtbMapper
				.selectByPrimaryKey(id);
		copier.copy(records, all, null);
		if (records != null) {
			Patienttb patient = patientService.findDataByKey(records
					.getPatientid());
			all.setPatienttb(patient);
		}

		return all;
	}

	@Override
	public CommFindEntity<OutPatienttbRecordCase> findAll(Pager page,
			String conditionSql) {
		CommFindEntity<OutPatienttbRecordCase> result = new CommFindEntity<OutPatienttbRecordCase>();
		RecordcaseopdtbExample example = new RecordcaseopdtbExample();
		if (conditionSql != null && !conditionSql.trim().equals("")) {
			log.info("conditionSql:" + conditionSql);
			example.createCriteria().addConditionSql(conditionSql);
		} else {
			example.createCriteria().andDeleteFlagEqualTo(0);
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = recordcaseopdtbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("recordcaseid DESC");

		List<RecordcaseopdtbWithBLOBs> ls = recordcaseopdtbMapper
				.selectByExampleWithBLOBs(example);
		List<OutPatienttbRecordCase> allResult = new ArrayList<>();

		if (ls != null) {
			for (RecordcaseopdtbWithBLOBs recordcaseopdtbWithBLOBs : ls) {
				OutPatienttbRecordCase all = new OutPatienttbRecordCase();
				copier.copy(recordcaseopdtbWithBLOBs, all, null);

				Patienttb patient = patientService
						.findDataByKey(recordcaseopdtbWithBLOBs.getPatientid());
				all.setPatienttb(patient);

				allResult.add(all);
			}
		}

		result.setResult(allResult);

		return result;
	}

	@Override
	public int saveData(OutPatienttbRecordCase bean) {
		log.info("save OutPatienttbRecordCase:" + bean.getKeshi());

		Patienttb patient = bean.getPatienttb();
		if (patient != null) {
			if (patient.getPatientid() == null || patient.getPatientid() <= 0) {

				// 如果当前数据库中，已经有相同的 【姓名】和【手机号】,就不用创建新病患。
				PatienttbExample pexample = new PatienttbExample();
				pexample.createCriteria().andNameEqualTo(patient.getName())
						.andPhoneEqualTo(patient.getPhone());
				int pcount = patienttbMapper.countByExample(pexample);
				if (pcount > 0) {
					log.info("patient id is null,but patient name and phone are  existing,  only update patient."
							+ patient.getName());
					List<Patienttb> lsPatient = patienttbMapper
							.selectByExample(pexample);
					patient.setPatientid(lsPatient.get(0).getPatientid()); //获取得到的病人ID
					bean.setPatientid(lsPatient.get(0).getPatientid()); // 获取得到的病人ID
					patient.setMenzhencishu(String.valueOf((pcount+1)));
					patientService.updateData(patient);
				} else {
					log.info("patient id is null,and patient name or phone is not existing, create new patient."
							+ patient.getName());
					patient.setZhuyuancishu(""+1);
					patientService.saveData(patient);
				}
			} else {
				log.info("patient id is not null, update patient."
						+ patient.getName());
				patientService.updateData(patient);
			}

			long key = pkgeneratorService.getPrimaryKey("recordcasetb",
					"recordcaseid");
			bean.setRecordcaseid(key);
			bean.setPatientid(patient.getPatientid());
			bean.setDeleteFlag(0);
			bean.setCreatedate(new Date());
			if (bean.getMenzhenzhengduan() != null) {
				// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
				String zujima = PingYinUtil.getFirstSpell(bean
						.getMenzhenzhengduan());
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
						bean.setCreateperson(session.getUserName());
					}
				}
			}

			savePatientDpDns(bean);

			log.info("relationship done. start to insert to database for patient.");

		} else {
			log.error("no patient data.");
		}

		return recordcaseopdtbMapper.insertSelective(bean);
	}

	/**
	 * 这里主要是根据输入的患者数据，系统自动自动创建计划任务
	 * 
	 * @param bean
	 */
	private void savePatientDpDns(OutPatienttbRecordCase bean) {
		long patientId = bean.getPatientid();
		String dnsList = bean.getMenzhenzhengduan();
		String department = bean.getKeshi();
		log.info("try to insert relationship for patient,deparment,diagnosistb");
		if (dnsList != null && !dnsList.trim().equals("") && department != null
				&& !department.trim().equals("")) {

			/* 首先查询出部门 */
			DepartmenttbExample dpExample = new DepartmenttbExample();
			dpExample.createCriteria().andDepartmentNameLike(
					"%" + department.trim() + "%");
			List<Departmenttb> deparArray = departmenttbMapper
					.selectByExample(dpExample);
			if (deparArray != null && deparArray.size() > 0) {
				log.info("found department count:" + deparArray.size()
						+ " for " + department + ", we only fetch one");
				Departmenttb depart = deparArray.get(0);
				String[] arrayDns = dnsList.split("#");

				/* 为每个患者默认创建一个计划 */
				PlanAll sfPlan = new PlanAll();
				sfPlan.setPlanname("[门诊号:"+bean.getMenzhenhao()+"]["+department+"]["+dnsList.replace("#", "|")+"]电话随访计划");
				sfPlan.setPatientid(patientId);

				// 这里应该把任务默认分配给该用户的门诊医生
				String menzhenyisheng = bean.getMenzhenyisheng();
				if (menzhenyisheng != null && !menzhenyisheng.trim().equals("")) {
					log.info("try to find out the resident doctor.");
					UsertbExample example = new UsertbExample();
					example.createCriteria().andUserNameLike(
							menzhenyisheng + "%");
					List<Usertb> usertbs = mapper.selectByExample(example);
					if (usertbs != null && usertbs.size() > 0) {
						Usertb user = usertbs.get(0);
						log.info("found user:" + user.getUserName());
						sfPlan.setUserId(user.getUserId());
					}
				}

				sFPlaneService.saveData(sfPlan);

				for (String dns : arrayDns) {
					DiagnosistbExample dnsexample = new DiagnosistbExample();
					dnsexample.createCriteria().andDiagnosisNameLike(
							"%" + dns.trim() + "%");
					List<Diagnosistb> dnsArray = diagnosistbMapper
							.selectByExample(dnsexample);
					if (dnsArray != null && dnsArray.size() > 0) {
						log.info("found diagnosis count:" + dnsArray.size()
								+ ",for " + dns + ", we only fetch one");
						Diagnosistb gotdns = dnsArray.get(0);

						//首先查看是否已经有一模一样的数据
						RspatientdpdnsExample example = new RspatientdpdnsExample();
						example.createCriteria().andDepartmentIdEqualTo(depart.getDepartmentId()).andPatientidEqualTo(patientId).andDiagnosisIdEqualTo(gotdns.getDiagnosisId());
						int count = rspatientdpdnsMapper.countByExample(example);
						
						Rspatientdpdns rspatientdpdns = new Rspatientdpdns();
						rspatientdpdns
								.setDepartmentId(depart.getDepartmentId());
						rspatientdpdns.setDiagnosisId(gotdns.getDiagnosisId());
						rspatientdpdns.setPatientid(patientId);
						if(count<=0){
						log.info("create relationship,patient:"
								+ rspatientdpdns.getPatientid() + ",diagnosis"
								+ rspatientdpdns.getDiagnosisId()
								+ ", department:"
								+ rspatientdpdns.getDepartmentId());
						rspatientdpdnsMapper.insert(rspatientdpdns);
						}else{
							log.info("already existing in rspatientdpdns table, does not insert into.");
						}

						try {
							/* 为每个病患插入相关的调查问卷 */
							CommFindEntity<Surveytb> modelEntity = diagnosisSurveyService
									.findAllSurveyWithAddedSurvey(
											rspatientdpdns.getDiagnosisId(),
											rspatientdpdns.getDepartmentId());
							if (modelEntity != null
									&& modelEntity.getResult() != null
									&& modelEntity.getResult().size() > 0) {
								List<Surveytb> surveys = modelEntity
										.getResult();
								log.debug("found findAllSurveyWithAddedSurvey count:"
										+ surveys.size());
								for (Surveytb sur : surveys) {

									log.debug("add survey:"
											+ sur.getSurveryId() + ",for "
											+ patientId);
									sFPlaneService.saveDataForPatientSurvey(
											sfPlan.getPlanId(),
											sur.getSurveryId());
								}
							}
						} catch (Exception e) {
							log.error(e);
						}

						continue;
					} else {
						log.warn("not found diagnosis for :" + dns);
					}

				}
			} else {
				log.warn("not found department, can not insert the rs_patient_dp_dns");
			}
		} else {
			log.warn("dnsList or department is not correct");
		}
	}

	@Override
	public int deleteDataByKey(Long id) {
		log.info("deleteDataByKey:" + id);
		RecordcaseopdtbWithBLOBs tb = recordcaseopdtbMapper.selectByPrimaryKey(id);
		tb.setDeleteFlag(1);
		return recordcaseopdtbMapper.updateByPrimaryKeySelective(tb);
	}

	@Override
	public int updateData(OutPatienttbRecordCase bean) {
		log.info("updateData:" + bean.getPatientid());

		Patienttb patient = bean.getPatienttb();
		if (patient != null) {
			log.info("update patient." + patient.getName());
			patientService.updateData(patient);
		}

		bean.setUpdatedate(new Date());
		// 得到汉字的首字母。，这里还有bug，一些多音字不好区分，以后improve
		if (bean.getMenzhenzhengduan() != null) {
			String zujima = PingYinUtil.getFirstSpell(bean
					.getMenzhenzhengduan());
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
		return recordcaseopdtbMapper.updateByPrimaryKeySelective(bean);
	}

	@Override
	public CommFindEntity<OutPatienttbRecordCase> findAll(Pager page,int type,
			Long patientid, String zhuyuanhao, String keshi,
			Date chuyuanriqi, String zujima) {
		CommFindEntity<OutPatienttbRecordCase> result = new CommFindEntity<OutPatienttbRecordCase>();
		RecordcaseopdtbExample example = new RecordcaseopdtbExample();

        Criteria criteria = example.createCriteria();
		
		log.info("patientid:" + patientid+",zhuyuanhao:"+zhuyuanhao+",keshi:"+keshi+",chuyuanriqi:"+chuyuanriqi+",zujima:"+zujima);
			
		criteria.andDeleteFlagEqualTo(0);
		if(patientid>0){
			criteria.andPatientidEqualTo(patientid);
		}
		if(!zhuyuanhao.trim().equals("")){
			criteria.andMenzhenhaoEqualTo(zhuyuanhao);
		}
		if(!keshi.trim().equals("")){
			criteria.andKeshiEqualTo(keshi);
		}
		if(chuyuanriqi!=null){
			criteria.andChuyuanriqiEqualTo(chuyuanriqi);
		}
		if(!zujima.trim().equals("")){
			criteria.andZujimaLike("%"+zujima+"%");
		}

		// 必须先设置count数，再设置limtStart/limitEnd
		int count = recordcaseopdtbMapper.countByExample(example);
		log.info("findAll count:" + count);
		result.setCount(count);
		page.setCount(count);
		example.setLimitStart(page.getStartDataIndex());
		example.setLimitEnd(page.getPageSize());
		// 排序
		example.setOrderByClause("recordcaseid DESC");

		List<RecordcaseopdtbWithBLOBs> ls = recordcaseopdtbMapper
				.selectByExampleWithBLOBs(example);
		List<OutPatienttbRecordCase> allResult = new ArrayList<>();

		if (ls != null) {
			for (RecordcaseopdtbWithBLOBs recordcaseopdtbExample : ls) {
				OutPatienttbRecordCase all = new OutPatienttbRecordCase();
				copier.copy(recordcaseopdtbExample, all, null);

				Patienttb patient = patientService
						.findDataByKey(recordcaseopdtbExample.getPatientid());
				all.setPatienttb(patient);

				allResult.add(all);
			}
		}

		result.setResult(allResult);

		return result;
	}

}
