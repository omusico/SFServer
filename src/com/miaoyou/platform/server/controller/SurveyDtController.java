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
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.survey.SurveyDtServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * 随访问卷模版
 * 
 * @author 305027939
 *
 */
@Controller
public class SurveyDtController {
	private static final Log log = LogFactory.getLog(SurveyDtController.class);

	@Resource
	SurveyDtServiceIF surveyDtService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/svd/{id}")
	public @ResponseBody SurveyDetailtb getById(@PathVariable Long id) {
		log.debug("get:" + id);
		SurveyDetailtb bean = surveyDtService.findDataByKey(id);
		return bean;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/svd")
	public @ResponseBody CommFindEntity<SurveyDetailtb> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@RequestParam(value = "conditionSql", defaultValue = "") String conditionSql) {
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);
		CommFindEntity<SurveyDetailtb> result = surveyDtService.findAll(pager,
				conditionSql);
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/svd/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SurveyDetailtb> add(
			@RequestBody SurveyDetailtb bean) {
		if (bean != null) {
			log.debug("add:" + bean.getSurverydetailName());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<SurveyDetailtb> comResponse = new ComResponse<SurveyDetailtb>();
		try {
			int result = surveyDtService.saveData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("新建问卷内容模版");
			comResponse.setExtendResponseContext("创建问卷内容模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建问卷内容模版失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/svd/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SurveyDetailtb> update(
			@RequestBody SurveyDetailtb bean) {
		if (bean != null) {
			log.debug("update:" + bean.getSurverydetailName());
		} else {
			log.error("update: bean is null!");
		}
		ComResponse<SurveyDetailtb> comResponse = new ComResponse<SurveyDetailtb>();
		try {
			int result = surveyDtService.updateData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("更新问卷内容模版");
			comResponse.setExtendResponseContext("更新问卷内容模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新问卷内容模版失败." + e.getMessage());
		}
		log.debug("updated:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/svd/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SurveyDetailtb> delete(
			@PathVariable Long id) {
		log.debug("delete:" + id);
		ComResponse<SurveyDetailtb> comResponse = new ComResponse<SurveyDetailtb>();
		try {
			int result = surveyDtService.deleteDataByKey(id);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除问卷内容模版");
			comResponse.setExtendResponseContext("删除问卷内容模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除问卷内容模版失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}

}
