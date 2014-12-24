package com.miaoyou.platform.server.service.survey;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Rspatientdpdns;
import com.miaoyou.platform.server.entity.RspatientdpdnsExample;
import com.miaoyou.platform.server.entity.Rspatientsvadd;
import com.miaoyou.platform.server.entity.RspatientsvaddExample;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.mapper.RspatientdpdnsMapper;
import com.miaoyou.platform.server.mapper.RspatientsvaddMapper;
import com.miaoyou.platform.server.service.diagnosis.DiagnosisSurveyServiceIF;
import com.miaoyou.platform.server.service.patient.PatientService;

@Service
public class PatientDefaultSurveyService implements PatientDefaultSurveyServiceIF{
	private static final Log log = LogFactory.getLog(PatientService.class);
	@Resource
	RspatientdpdnsMapper rspatientdpdnsMapper;
	
	@Resource
	RspatientsvaddMapper rspatientsvaddMapper;
	
	@Resource
	DiagnosisSurveyServiceIF diagnosisSurveyService;
	
	@Resource
	SurveyServiceIF surveyService;
	
	@Override
	public CommFindEntity<Surveytb> findPatientSurvey(Long patientId) {
	
		log.info("findPatientSurvey:"+patientId);
		CommFindEntity<Surveytb> result = new CommFindEntity<Surveytb>();
		List<Surveytb> lsArray = new ArrayList<>();
		
		result.setResult(lsArray);
		
		RspatientdpdnsExample example =new RspatientdpdnsExample();
		example.createCriteria().andPatientidEqualTo(patientId);
		
		List<Rspatientdpdns> rspatientdnsArray = rspatientdpdnsMapper.selectByExample(example);
		if(rspatientdnsArray!=null){
			log.info("found Rspatientdpdns count:"+rspatientdnsArray.size());
			for(Rspatientdpdns rs:rspatientdnsArray){
				 CommFindEntity<Surveytb> modelEntity = diagnosisSurveyService.findAllSurveyWithAddedSurvey(rs.getDiagnosisId(),rs.getDepartmentId());
				 if(modelEntity!=null){
					 log.debug("found findAllSurveyWithAddedSurvey count:"+modelEntity.getCount());
				    lsArray.addAll(modelEntity.getResult());
				 }
			}
		}
		
		RspatientsvaddExample rseample = new RspatientsvaddExample();
		rseample.createCriteria().andPatientidEqualTo(patientId);
		List<Rspatientsvadd> adsvArray = rspatientsvaddMapper.selectByExample(rseample);
		if(adsvArray!=null){
			log.info("found Rspatientsvadd count:"+adsvArray.size());
			for(Rspatientsvadd add:adsvArray){
				Surveytb surveytb = surveyService.findDataByKey(add.getSurveryId());
				if(surveytb!=null){
					lsArray.add(surveytb);
				}
			}
		}
		result.setCount(lsArray.size());
		return result;
	}

	@Override
	public int savePatientSv(Long patientId, Long surveyId) {
		log.info("savePatientSv:"+patientId+",surveyId:"+surveyId);
		Rspatientsvadd add = new Rspatientsvadd();
		add.setPatientid(patientId);
		add.setSurveryId(surveyId);
		return rspatientsvaddMapper.insert(add);
	}

	@Override
	public int deletePatientSv(Long patientId, Long surveyId) {
		log.info("deletePatientSv:"+patientId+",surveyId:"+surveyId);
		RspatientsvaddExample example =new RspatientsvaddExample();
		example.createCriteria().andPatientidEqualTo(patientId).andSurveryIdEqualTo(surveyId);
		return rspatientsvaddMapper.deleteByExample(example);
	}

}
