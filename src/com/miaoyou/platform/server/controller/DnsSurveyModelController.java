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
	
	@RequestMapping(method = RequestMethod.GET, value = "/rsdnssv/{departmentId}/{diagnosisId}/{surveryId}")
	public @ResponseBody SurveyModelEntity findDnsModelAllWithAddedQuestion(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@PathVariable Integer departmentId,
			@PathVariable Long diagnosisId,@PathVariable Long surveryId){
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage+",diagnosisId:"+diagnosisId+",surveryId:"+surveryId+",departmentId:"+departmentId);
		Pager pager = new Pager(page, perPage);
		SurveyModelEntity modelEntity = diagnosisSurveyService.findDnsModelAllWithAddedQuestion(pager, surveryId, diagnosisId,departmentId);
		return modelEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/rsdnssv/patient/{patientId}/{surveryId}")
	public @ResponseBody SurveyModelEntity findDnsModelAllWithAddedQuestionForPatientDefaultSurvey(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@PathVariable Long patientId,@PathVariable Long surveryId){
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage+",patientId:"+patientId+",surveryId:"+surveryId);
		Pager pager = new Pager(page, perPage);
		SurveyModelEntity modelEntity = diagnosisSurveyService.findDnsModelAllWithAddedQuestionForPatientDefaultSurvey(pager,patientId,surveryId);
		return modelEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/rsdnssv/{departmentId}/{diagnosisId}")
	public @ResponseBody CommFindEntity<Surveytb>  findAllSurveyWithAddedSurvey(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@PathVariable Integer departmentId,
			@PathVariable Long diagnosisId){
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage+",diagnosisId:"+diagnosisId+",departmentId:"+departmentId);
		Pager pager = new Pager(page, perPage);
		 CommFindEntity<Surveytb> modelEntity = diagnosisSurveyService.findAllSurveyWithAddedSurvey(diagnosisId,departmentId);
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

	
	@RequestMapping(method = RequestMethod.POST, value = "/rsdnssv/adddt/{departmentId}/{diagnosisId}/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse saveDnsSurveyModelWidthAddedQuestion(@RequestBody SurveyDetailtb surveyDetailtb,@PathVariable Integer departmentId,@PathVariable Long diagnosisId,@PathVariable Long surveryId) {

			log.debug("add:diagnosisId:" + diagnosisId+",surveryId:"+surveryId+",departmentId:"+departmentId);

		ComResponse comResponse = new ComResponse();
		try {
			int result = diagnosisSurveyService.saveDnsSurveyModelWidthAddedQuestion(surveyDetailtb, departmentId,diagnosisId, surveryId);
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
	
	@RequestMapping(method = RequestMethod.POST, value = "/rsdnssv/addsurvey/{departmentId}/{diagnosisId}/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse saveDnsSurveyModelWithAddedSurvey(@PathVariable Integer departmentId,@PathVariable Long diagnosisId,@PathVariable Long surveryId) {

		log.debug("add:diagnosisId:" + diagnosisId+",surveryId:"+surveryId+",departmentId:"+departmentId);

		ComResponse comResponse = new ComResponse();
		try {
			int result = diagnosisSurveyService.saveDnsSurveyModelWithAddedSurvey(departmentId,diagnosisId, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(null);
			logService.saveLog("创建额外问卷为科室:"+departmentId);
			comResponse.setExtendResponseContext("创建额外问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("创建额外问卷失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}


	@RequestMapping(method = RequestMethod.POST, value = "/rsdnssv/deletedt/{departmentId}/{diagnosisId}/{surveryId}/{surverydetailId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse deleteDnsSurveyModelAddedQuestion(@PathVariable Integer departmentId, @PathVariable Long diagnosisId,@PathVariable Long surveryId,@PathVariable Long surverydetailId) {
		log.debug("delete:diagnosisId:" + diagnosisId+",surveryId:"+surveryId+",departmentId:"+departmentId+",surverydetailId:"+surverydetailId);
		ComResponse comResponse = new ComResponse();
		try {
			int result = diagnosisSurveyService.deleteDnsSurveyModelAddedQuestion(surverydetailId,departmentId, diagnosisId, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除问卷额外问题");
			comResponse.setExtendResponseContext("删除问卷额外问题成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除问卷额外问题失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/rsdnssv/deletesurvey/{departmentId}/{diagnosisId}/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse deleteDnsSurveyModelAddedSurvey(@PathVariable Integer departmentId, @PathVariable Long diagnosisId,@PathVariable Long surveryId) {
		log.debug("delete:diagnosisId:" + diagnosisId+",surveryId:"+surveryId+",departmentId:"+departmentId);
		ComResponse comResponse = new ComResponse();
		try {
			int result = diagnosisSurveyService.deleteDnsSurveyModelAddedSurvey(departmentId, diagnosisId, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除额外问卷");
			comResponse.setExtendResponseContext("删除额外问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除额外问卷额外问题失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}
	

	
}
