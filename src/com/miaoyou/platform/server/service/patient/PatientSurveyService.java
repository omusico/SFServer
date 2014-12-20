package com.miaoyou.platform.server.service.patient;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Patientsurveytb;
import com.miaoyou.platform.server.entity.PatientsurveytbExample;
import com.miaoyou.platform.server.entity.Rspatientsurveysv;
import com.miaoyou.platform.server.entity.RspatientsurveysvExample;
import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.mapper.PatientsurveytbMapper;
import com.miaoyou.platform.server.mapper.RspatientsurveysvMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;
import com.miaoyou.platform.server.utils.PingYinUtil;

@Service
public class PatientSurveyService implements PatientSurveyServiceIF {
	private static final Log log = LogFactory
			.getLog(PatientSurveyService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	PatientsurveytbMapper patientsurveytbMapper;
	@Resource
	RspatientsurveysvMapper rspatientsurveysvMapper;

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
		return patientsurveytbMapper.updateByPrimaryKeySelective(bean);
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

		List<Rspatientsurveysv> ls = rspatientsurveysvMapper.selectByExample(example);
		result.setResult(ls);
		
		return result;
	}

}
