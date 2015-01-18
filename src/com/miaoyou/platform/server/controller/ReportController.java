package com.miaoyou.platform.server.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoyou.platform.server.entity.child.ReportTelDpEntity;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.report.ReportIF;

@Controller
public class ReportController {
	private static final Log log = LogFactory.getLog(ReportController.class);

	@Resource
	ReportIF reportTelService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}


	@RequestMapping(method = RequestMethod.GET, value = "/report/plan")
	public @ResponseBody CommFindEntity<ReportTelDpEntity> findPlanTelDpReport(
			@RequestParam(value = "dpId", defaultValue = "0") int departmentId,
			@RequestParam(value = "startDate", defaultValue = "") String startDate,@RequestParam(value = "endDate", defaultValue = "") String endDate) {
		log.debug("findPlanTelDpReport.pageindex" + departmentId + ",startDate:" + startDate+",endDate:"+endDate);
		CommFindEntity<ReportTelDpEntity> result = reportTelService.findPlanTelDpReport(departmentId, startDate, endDate);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/report/survey")
	public @ResponseBody CommFindEntity<ReportTelDpEntity> findSurveyTelDpReport(
			@RequestParam(value = "surveyId", defaultValue = "0") long surveyId, 
			@RequestParam(value = "dpId", defaultValue = "0") int departmentId,
			@RequestParam(value = "startDate", defaultValue = "") String startDate,@RequestParam(value = "endDate", defaultValue = "") String endDate) {
		log.debug("findSurveyTelDpReport.pageindex" + departmentId + ",startDate:" + startDate+",endDate:"+endDate);
		CommFindEntity<ReportTelDpEntity> result = reportTelService.findSurveyTelDpReport(surveyId, departmentId, startDate, endDate);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/report/sms")
	public @ResponseBody CommFindEntity<ReportTelDpEntity> findSmsDpReport(
			@RequestParam(value = "dpId", defaultValue = "0") int departmentId,
			@RequestParam(value = "startDate", defaultValue = "") String startDate,@RequestParam(value = "endDate", defaultValue = "") String endDate) {
		log.debug("findSmsDpReport.pageindex" + departmentId + ",startDate:" + startDate+",endDate:"+endDate);
		CommFindEntity<ReportTelDpEntity> result = reportTelService.findPlanSmsDpReport(departmentId, startDate, endDate);
		return result;
	}

}
