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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.SurveyModelEntity;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.diagnosis.DiagnosisSurveyServiceIF;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * 病理问卷模版，包括问卷基本信息和问卷问题，和自己额外增加的问题
 * 
 * @author 305027939
 *
 */
@Controller
public class DnsSurveyModelController {
	private static final Log log = LogFactory.getLog(DnsSurveyModelController.class);

	@Resource
	DiagnosisSurveyServiceIF diagnosisSurveyService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}


	@RequestMapping(method = RequestMethod.GET, value = "/rsdnssv/{diagnosisId}")
	public @ResponseBody CommFindEntity<Surveytb> findSurvey(@PathVariable Long diagnosisId){
		log.debug("findSurvey.diagnosisId" + diagnosisId);
		return diagnosisSurveyService.findSurvey(diagnosisId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/rsdnssv/{diagnosisId}/{surveryId}")
	public SurveyModelEntity findDnsModelAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@PathVariable Long surveryId,
			@PathVariable Long diagnosisId){
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage+",diagnosisId:"+diagnosisId+",surveryId:"+surveryId);
		Pager pager = new Pager(page, perPage);
		SurveyModelEntity modelEntity = diagnosisSurveyService.findDnsModelAll(pager, surveryId, diagnosisId);
		return modelEntity;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/rsdnssv/add/{diagnosisId}/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse saveDnsSurveyModel(@PathVariable Long diagnosisId,@PathVariable Long surveryId) {

			log.debug("add:diagnosisId:" + diagnosisId+",surveryId:"+surveryId);

		ComResponse comResponse = new ComResponse();
		try {
			int result = diagnosisSurveyService.saveDnsSurveyModel(surveryId, diagnosisId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(null);
			logService.saveLog("关联病理问卷模版");
			comResponse.setExtendResponseContext("关联病理问卷模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("关联病理问卷模版失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}


	@RequestMapping(method = RequestMethod.POST, value = "/rsdnssv/delete/{diagnosisId}/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse deleteDnsSurveyModel(SurveyDetailtb surveyDetailtb,@PathVariable Long diagnosisId,@PathVariable Long surveryId) {
		log.debug("delete:diagnosisId:" + diagnosisId+",surveryId:"+surveryId);
		ComResponse comResponse = new ComResponse();
		try {
			int result = diagnosisSurveyService.deleteDnsSurveyModel(surveryId, diagnosisId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除问卷模版问题");
			comResponse.setExtendResponseContext("删除问卷模版问题成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除问卷模版问题失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/rsdnssv/adddt/{diagnosisId}/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse saveDnsSurveyModelQuestion(@RequestBody SurveyDetailtb surveyDetailtb,@PathVariable Long diagnosisId,@PathVariable Long surveryId) {

			log.debug("add:diagnosisId:" + diagnosisId+",surveryId:"+surveryId);

		ComResponse comResponse = new ComResponse();
		try {
			int result = diagnosisSurveyService.saveDnsSurveyModelQuestion(surveyDetailtb, diagnosisId, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(null);
			logService.saveLog("新建问卷新增问题");
			comResponse.setExtendResponseContext("创建问卷新增问题成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建问卷新增问题失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}


	@RequestMapping(method = RequestMethod.POST, value = "/rsdnssv/deletedt/{diagnosisId}/{surveryId}/{surverydetailId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse deleteDnsSurveyModelAddedQuestion( @PathVariable Long diagnosisId,@PathVariable Long surveryId,@PathVariable Long surverydetailId) {
		log.debug("delete:diagnosisId:" + diagnosisId+",surveryId:"+surveryId);
		ComResponse comResponse = new ComResponse();
		try {
			int result = diagnosisSurveyService.deleteDnsSurveyModelAddedQuestion(surverydetailId, diagnosisId, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除问卷新增问题问题");
			comResponse.setExtendResponseContext("删除问卷新增问题问题成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除问卷新增问题失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}
	

	
}
