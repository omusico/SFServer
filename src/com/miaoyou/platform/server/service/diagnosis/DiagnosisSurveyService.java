package com.miaoyou.platform.server.service.diagnosis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.RsdnssvtbExample;
import com.miaoyou.platform.server.entity.RsdnssvtbKey;
import com.miaoyou.platform.server.entity.Rsdnssvtbadd;
import com.miaoyou.platform.server.entity.RsdnssvtbaddExample;
import com.miaoyou.platform.server.entity.Rspatientdpdns;
import com.miaoyou.platform.server.entity.RspatientdpdnsExample;
import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.SurveyModelEntity;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.RsdnssvtbMapper;
import com.miaoyou.platform.server.mapper.RsdnssvtbaddMapper;
import com.miaoyou.platform.server.mapper.RspatientdpdnsMapper;
import com.miaoyou.platform.server.mapper.RspatientsvaddMapper;
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
	
	@Resource
	RspatientdpdnsMapper rspatientdpdnsMapper;
	
	@Resource
	RspatientsvaddMapper rspatientsvaddMapper;

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
		result.setCount(suryveyArray.size());
		return result;
	}
	
	@Override
	public CommFindEntity<Surveytb> findAllSurveyWithAddedSurvey(Long diagnosisId,Integer departmentId) {
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
		
		//查询出科室单独增加的一些的问卷
		RsdnssvtbaddExample exampleadd  =new RsdnssvtbaddExample();
		exampleadd.createCriteria().andDepartmentIdEqualTo(departmentId).andDiagnosisIdEqualTo(diagnosisId).andSurverydetailIdIsNull();
		List<Rsdnssvtbadd> addArray = rsdnssvtbaddMapper.selectByExample(exampleadd);
		if(addArray!=null){
			for (Rsdnssvtbadd key : addArray) {
				Surveytb survey = surveyService.findDataByKey(key
						.getSurveryId());
				survey.setExt1("add");
				suryveyArray.add(survey);
			}
		}
		
		result.setCount(suryveyArray.size());
		return result;
	}
	
	@Override
	public SurveyModelEntity findDnsModelAllWithAddedQuestion(Pager page, Long surveryId,
			Long diagnosisId,Integer departmentId) {
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
					.andSurveryIdEqualTo(surveryId).andDepartmentIdEqualTo(departmentId);
			List<Rsdnssvtbadd> addtb = rsdnssvtbaddMapper
					.selectByExample(exmaple);
			if (addtb != null) {
				log.info("additonal question count:" + addtb.size());
				for (Rsdnssvtbadd key : addtb) {
					SurveyDetailtb detail = surveyDtService.findDataByKey(key
							.getSurverydetailId());
					if(detail!=null){
					    detail.setExt1("add");
					    modelEntity.getSurveyArray().getResult().add(detail);
					}
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
	public int saveDnsSurveyModelWidthAddedQuestion(SurveyDetailtb surveyDetailtb,
			Integer departmentId,Long diagnosisId, Long surveryId) {
		log.info("saveDnsSurveyModelWidthAddedQuestion:"+surveryId+",diagnosisId:"+diagnosisId+"，departmentId:"+departmentId);
		
		if(surveyDetailtb.getSurverydetailId()<=0){
			log.debug("try to create new SurveyDetailtb");
		   surveyDtService.saveData(surveyDetailtb);
		}else{
			log.debug("selected existing SurveyDetailtb");
		}
		
		log.debug("add key for surveyDetailtb:"+surveyDetailtb.getSurverydetailId());
		if(surveyDetailtb.getSurverydetailId()>0){
			Rsdnssvtbadd addKey = new Rsdnssvtbadd();
			addKey.setDiagnosisId(diagnosisId);
			addKey.setSurveryId(surveryId);
			addKey.setSurverydetailId(surveyDetailtb.getSurverydetailId());
			addKey.setDepartmentId(departmentId);
			return rsdnssvtbaddMapper.insertSelective(addKey);
		}
		
		return 0;
	}
	
	@Override
	public int saveDnsSurveyModelWithAddedSurvey(Integer departmentId,Long diagnosisId, Long surveryId) {
		log.info("saveDnsSurveyModelWithAddedSurvey:"+surveryId+",diagnosisId:"+diagnosisId+"，departmentId:"+departmentId);

		if(surveryId>0){
			Rsdnssvtbadd addKey = new Rsdnssvtbadd();
			addKey.setDiagnosisId(diagnosisId);
			addKey.setSurveryId(surveryId);
			addKey.setDepartmentId(departmentId);
			return rsdnssvtbaddMapper.insertSelective(addKey);
		}
		
		return 0;
	}

	@Override
	public int deleteDnsSurveyModelAddedQuestion(Long surverydetailId,Integer departmentId,Long diagnosisId, Long surveryId) {
		log.info("deleteDnsSurveyModelAddedQuestion:"+surveryId+",diagnosisId:"+diagnosisId);
		if(surverydetailId>0){
			RsdnssvtbaddExample example = new RsdnssvtbaddExample();
			example.createCriteria().andDepartmentIdEqualTo(departmentId)
			.andDiagnosisIdEqualTo(diagnosisId).andSurverydetailIdEqualTo(surverydetailId)
			.andSurveryIdEqualTo(surveryId);
			return rsdnssvtbaddMapper.deleteByExample(example);
		}else{
			log.error("error,SurverydetailId <= 0.");
		}
		return 0;
	}

	@Override
	public int deleteDnsSurveyModelAddedSurvey(Integer departmentId,Long diagnosisId, Long surveryId) {
		log.info("deleteDnsSurveyModelAddedSurvey:"+surveryId+",diagnosisId:"+diagnosisId);
		if(surveryId>0){
			RsdnssvtbaddExample example = new RsdnssvtbaddExample();
			example.createCriteria().andDepartmentIdEqualTo(departmentId)
			.andDiagnosisIdEqualTo(diagnosisId).andSurveryIdEqualTo(surveryId);
			return rsdnssvtbaddMapper.deleteByExample(example);
		}else{
			log.error("error,surveryId <= 0.");
		}
		return 0;
	}

	@Override
	public SurveyModelEntity findDnsModelAllWithAddedQuestionForPatientDefaultSurvey(
			Pager page, Long patientId, Long surveryId) {
		log.info("findDnsModelAllWithAddedQuestionForPatientDefaultSurvey:"+surveryId+",patientId:"+patientId);
		SurveyModelEntity result = new SurveyModelEntity();
		CommFindEntity<SurveyDetailtb> allEntity = new CommFindEntity<SurveyDetailtb>();
		List<SurveyDetailtb> lsArray = new ArrayList<>();
		allEntity.setResult(lsArray);
		result.setSurveyArray(allEntity);
		
		//这里的分页有问题，强烈界面上有分页需求的地方，不要用这个地方来进行分页。页面不准。数据肯定是全的，
		
		RspatientdpdnsExample example = new RspatientdpdnsExample();
		example.createCriteria().andPatientidEqualTo(patientId);
		List<Rspatientdpdns> rspaarray = rspatientdpdnsMapper.selectByExample(example);
		if(rspaarray!=null){
			
			SurveyModelEntity modelEntity = surveyModelService.findModelAll(page,surveryId);
			
			for(Rspatientdpdns rspdns:rspaarray){
				int dpId = rspdns.getDepartmentId();
				long dnsId = rspdns.getDiagnosisId();
				log.debug("the last page, add addiational question");
				
				/* 查询是否有增加的项目 */
				RsdnssvtbaddExample exmaple = new RsdnssvtbaddExample();
				exmaple.createCriteria().andDiagnosisIdEqualTo(dnsId)
						.andSurveryIdEqualTo(surveryId).andDepartmentIdEqualTo(dpId);
				List<Rsdnssvtbadd> addtb = rsdnssvtbaddMapper
						.selectByExample(exmaple);
				if (addtb != null) {
					log.info("additonal question count:" + addtb.size());
					for (Rsdnssvtbadd key : addtb) {
						SurveyDetailtb detail = surveyDtService.findDataByKey(key
								.getSurverydetailId());
						if(detail!=null){
						    detail.setExt1("add");
						    modelEntity.getSurveyArray().getResult().add(detail);
						}
					}
				}
			}
			
			lsArray.addAll(modelEntity.getSurveyArray().getResult());
			allEntity.setCount(modelEntity.getSurveyArray().getCount());
		}
		
		return result;
	}
	
}
