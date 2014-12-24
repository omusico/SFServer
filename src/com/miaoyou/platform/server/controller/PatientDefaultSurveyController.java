package com.miaoyou.platform.server.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.survey.PatientDefaultSurveyServiceIF;

@Controller
public class PatientDefaultSurveyController {
	private static final Log log = LogFactory.getLog(SurveyController.class);

	@Resource
	PatientDefaultSurveyServiceIF patientDefaultSurveyService;

	@Resource
	LogIF logService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/defaultsv/{patientId}")
	public @ResponseBody CommFindEntity<Surveytb> getAll(@PathVariable Long patientId) {
		log.info("get default survey for patient:"+patientId);
		CommFindEntity<Surveytb> result = patientDefaultSurveyService.findPatientSurvey(patientId);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/defaultsv/add/{patientId}/{surveyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Surveytb> add(@PathVariable Long patientId,@PathVariable Long surveyId) {
		log.debug("add default survey for patient:"+patientId+",survey:"+surveyId);

		ComResponse<Surveytb> comResponse = new ComResponse<Surveytb>();
		try {
			int result = patientDefaultSurveyService.savePatientSv(patientId, surveyId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(null);
			logService.saveLog("增加默认随访问卷为病案ID:"+patientId);
			comResponse.setExtendResponseContext("增加默认随访问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("增加默认随访问卷失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/defaultsv/delete/{patientId}/{surveyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Surveytb> delete(@PathVariable Long patientId,@PathVariable Long surveyId) {
		log.debug("delete default survey for patient:" + patientId+",delete survey:"+surveyId);
		ComResponse<Surveytb> comResponse = new ComResponse<Surveytb>();
		try {
			int result = patientDefaultSurveyService.deletePatientSv(patientId, surveyId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除默认随访问卷");
			comResponse.setExtendResponseContext("删除默认随访问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除默认随访问卷失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}

}
