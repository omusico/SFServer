package com.miaoyou.platform.server.service.diagnosis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.RsdnssvtbExample;
import com.miaoyou.platform.server.entity.RsdnssvtbKey;
import com.miaoyou.platform.server.entity.RsdnssvtbaddExample;
import com.miaoyou.platform.server.entity.RsdnssvtbaddKey;
import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.SurveyModelEntity;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.RsdnssvtbMapper;
import com.miaoyou.platform.server.mapper.RsdnssvtbaddMapper;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.service.survey.SurveyDtServiceIF;
import com.miaoyou.platform.server.service.survey.SurveyModelServiceIF;
import com.miaoyou.platform.server.service.survey.SurveyServiceIF;
import com.miaoyou.platform.server.utils.Pager;

@Service
public class DiagnosisSurveyService implements DiagnosisSurveyServiceIF {
	private static final Log log = LogFactory
			.getLog(DiagnosisSurveyService.class);
	@Resource
	PkgeneratorServiceIF pkgeneratorService;
	@Resource
	SurveyServiceIF surveyService;
	@Resource
	SurveyDtServiceIF surveyDtService;
	@Resource
	RsdnssvtbMapper rsdnssvtbMapper;
	@Resource
	RsdnssvtbaddMapper rsdnssvtbaddMapper;
	@Resource
	SurveyModelServiceIF surveyModelService;

	@Override
	public CommFindEntity<Surveytb> findSurvey(Long diagnosisId) {
		log.info("findSurvey:" + diagnosisId);
		CommFindEntity<Surveytb> result = new CommFindEntity<>();
		List<Surveytb> suryveyArray = new ArrayList<>();
		result.setResult(suryveyArray);

		RsdnssvtbExample example = new RsdnssvtbExample();
		example.createCriteria().andDiagnosisIdEqualTo(diagnosisId);
		List<RsdnssvtbKey> lsKey = rsdnssvtbMapper.selectByExample(example);
		if (lsKey != null) {
			log.info("RsdnssvtbKey count:" + lsKey.size());
			result.setCount(lsKey.size());
			for (RsdnssvtbKey key : lsKey) {
				Surveytb survey = surveyService.findDataByKey(key
						.getSurveryId());
				suryveyArray.add(survey);
			}
		}

		return result;
	}

	@Override
	public SurveyModelEntity findDnsModelAll(Pager page, Long surveryId,
			Long diagnosisId) {
		log.info("findDnsModelAll,surveryId:" + surveryId + ",diagnosisId:"
				+ diagnosisId);

		SurveyModelEntity modelEntity = surveyModelService.findModelAll(page,
				surveryId);

		// 最后一页才加上额外增加的问卷问题
		if (page.getStartDataIndex() + page.getPageSize() >= page.getCount()) {
			log.debug("the last page, add addiational question");
			/* 查询是否有增加的项目 */
			RsdnssvtbaddExample exmaple = new RsdnssvtbaddExample();
			exmaple.createCriteria().andDiagnosisIdEqualTo(diagnosisId)
					.andSurveryIdEqualTo(surveryId);
			List<RsdnssvtbaddKey> addtb = rsdnssvtbaddMapper
					.selectByExample(exmaple);
			if (addtb != null) {
				log.info("additonal question count:" + addtb.size());
				for (RsdnssvtbaddKey key : addtb) {
					SurveyDetailtb detail = surveyDtService.findDataByKey(key
							.getSurverydetailId());
					detail.setExt1("add");
					modelEntity.getSurveyArray().getResult().add(detail);
				}
			}
		}else{
			log.debug("not the last page, do not add addiational question");
		}

		return modelEntity;
	}

	@Override
	public int deleteDnsSurveyModel(Long surveryId, Long diagnosisId) {
		log.info("deleteDnsSurveyModel:surveytb:"+surveryId+",diagnosisId:"+diagnosisId);
		
		
		//firstly delete additional questions
		RsdnssvtbaddExample example = new RsdnssvtbaddExample();
		example.createCriteria().andDiagnosisIdEqualTo(diagnosisId).andSurveryIdEqualTo(surveryId);
		rsdnssvtbaddMapper.deleteByExample(example);
		
		RsdnssvtbKey key = new RsdnssvtbKey();
		key.setDiagnosisId(diagnosisId);
		key.setSurveryId(surveryId);

		return rsdnssvtbMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int saveDnsSurveyModel(Long surveryId, Long diagnosisId) {
		log.info("saveDnsSurveyModel:"+surveryId+",diagnosisId:"+diagnosisId);
		RsdnssvtbKey key = new RsdnssvtbKey();
		key.setDiagnosisId(diagnosisId);
		key.setSurveryId(surveryId);
		return rsdnssvtbMapper.insertSelective(key);
	}

	@Override
	public int saveDnsSurveyModelQuestion(SurveyDetailtb surveyDetailtb,
			Long diagnosisId, Long surveryId) {
		log.info("saveDnsSurveyModelQuestion:"+surveryId+",diagnosisId:"+diagnosisId);
		
		if(surveyDetailtb.getSurverydetailId()<=0){
			log.debug("try to create new SurveyDetailtb");
		   surveyDtService.saveData(surveyDetailtb);
		}else{
			log.debug("selected existing SurveyDetailtb");
		}
		
		log.debug("add key for surveyDetailtb:"+surveyDetailtb.getSurverydetailId());
		if(surveyDetailtb.getSurverydetailId()>0){
			RsdnssvtbaddKey addKey = new RsdnssvtbaddKey();
			addKey.setDiagnosisId(diagnosisId);
			addKey.setSurveryId(surveryId);
			addKey.setSurverydetailId(surveyDetailtb.getSurverydetailId());
			return rsdnssvtbaddMapper.insertSelective(addKey);
		}
		
		return 0;
	}

	@Override
	public int deleteDnsSurveyModelAddedQuestion(Long surverydetailId,
			Long diagnosisId, Long surveryId) {
		log.info("deleteDnsSurveyModelAddedQuestion:"+surveryId+",diagnosisId:"+diagnosisId);
		if(surverydetailId>0){
			RsdnssvtbaddKey addKey = new RsdnssvtbaddKey();
			addKey.setDiagnosisId(diagnosisId);
			addKey.setSurveryId(surveryId);
			addKey.setSurverydetailId(surverydetailId);
			return rsdnssvtbaddMapper.deleteByPrimaryKey(addKey);
		}else{
			log.error("error,SurverydetailId <= 0.");
		}
		return 0;
	}

}
