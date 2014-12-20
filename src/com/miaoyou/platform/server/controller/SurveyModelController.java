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
import com.miaoyou.platform.server.entity.child.SurveyModelEntity;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.survey.SurveyModelServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * 问卷模版，包括问卷基本信息和问卷问题
 * 
 * @author 305027939
 *
 */
@Controller
public class SurveyModelController {
	private static final Log log = LogFactory.getLog(SurveyModelController.class);

	@Resource
	SurveyModelServiceIF surveyModelService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}


	@RequestMapping(method = RequestMethod.GET, value = "/rssvsvd/{surveryId}")
	public @ResponseBody SurveyModelEntity getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@PathVariable Long surveryId) {
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);
		SurveyModelEntity modelEntity = surveyModelService.findModelAll(pager, surveryId);
		return modelEntity;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/rssvsvd/add/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SurveyDetailtb> add(@RequestBody SurveyDetailtb surveyDetailtb,@PathVariable Long surveryId) {
		if (surveyDetailtb != null) {
			log.debug("add:" + surveyDetailtb.getSurverydetailId());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<SurveyDetailtb> comResponse = new ComResponse<SurveyDetailtb>();
		try {
			int result = surveyModelService.saveSurveyModelQuestion(surveyDetailtb, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(surveyDetailtb);
			logService.saveLog("新建问卷模版问题");
			comResponse.setExtendResponseContext("创建问卷模版问题成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建问卷模版问题失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/rssvsvd/update/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SurveyDetailtb> update(@RequestBody SurveyDetailtb surveyDetailtb,@PathVariable Long surveryId) {
		if (surveyDetailtb != null) {
			log.debug("update:" + surveyDetailtb.getSurverydetailId());
		} else {
			log.error("update: bean is null!");
		}
		ComResponse<SurveyDetailtb> comResponse = new ComResponse<SurveyDetailtb>();
		try {
			int result = surveyModelService.updateSurveyModelDefaultAnwser(surveyDetailtb, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(surveyDetailtb);
			logService.saveLog("更新问卷模版问题");
			comResponse.setExtendResponseContext("更新问卷模版问题成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新问卷模版问题失败." + e.getMessage());
		}
		log.debug("updated:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/rssvsvd/delete/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SurveyDetailtb> delete(@RequestBody SurveyDetailtb surveyDetailtb,@PathVariable Long surveryId) {
		log.debug("delete:" + surveyDetailtb.getSurverydetailId()+",for "+surveryId);
		ComResponse<SurveyDetailtb> comResponse = new ComResponse<SurveyDetailtb>();
		try {
			int result = surveyModelService.deleteSurveyModelQuestion(surveyDetailtb, surveryId);
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

}
