package com.miaoyou.platform.server.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.miaoyou.platform.server.entity.Patientsurveytb;
import com.miaoyou.platform.server.entity.Rspatientsurveysv;
import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.patient.PatientSurveyServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * 随访问卷调查卷子
 * 
 * @author 305027939
 *
 */
@Controller
public class PatientSurveyController {
	private static final Log log = LogFactory.getLog(PatientSurveyController.class);

	@Resource
	PatientSurveyServiceIF patientSurveyService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patientsv/{id}")
	public @ResponseBody Patientsurveytb getById(@PathVariable Long id) {
		log.debug("get:" + id);
		Patientsurveytb bean = patientSurveyService.findDataByKey(id);
		return bean;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patientsv")
	public @ResponseBody CommFindEntity<Patientsurveytb> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
            @RequestParam(value = "key", defaultValue = "") String name,
            @RequestParam(value = "patientid", defaultValue = "0") Long patientid,
            @RequestParam(value = "surveryid", defaultValue = "0") Long surveryid,
            @RequestParam(value = "status", defaultValue = "0") int status) {
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);
		 //构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
        StringBuilder sb = new StringBuilder();
        String andSplit = " and ";
        if(!name.equals("")){
        	sb.append("(survery_name").append(" like ").append("\"%"+name+"%\"").append(" or ").append("zujima").append(" like ").append("\""+name+"%\")").append(andSplit);
        }
        
        if(surveryid>0){
        	sb.append("survery_id").append(" = ").append(surveryid).append(andSplit);
        }
        if(patientid>0){
        	sb.append("patientid").append(" = ").append(patientid).append(andSplit);
        }
        if(status>=0){
        	sb.append("status").append(" = ").append(status).append(andSplit);
        }
        
        if(sb.length()>andSplit.length()){
        	sb.delete((sb.length()-andSplit.length()), sb.length()-1);
        }
        
		CommFindEntity<Patientsurveytb> result = patientSurveyService.findAll(pager,
				sb.toString());
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/patientsv/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Patientsurveytb> add(@RequestBody Patientsurveytb bean) {
		if (bean != null) {
			log.debug("add:" + bean.getSurveryName());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<Patientsurveytb> comResponse = new ComResponse<Patientsurveytb>();
		try {
			int result = patientSurveyService.saveData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("新建病案调查问卷");
			comResponse.setExtendResponseContext("创建病案调查问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建病案调查问卷失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/patientsv/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Patientsurveytb> update(@RequestBody Patientsurveytb bean) {
		if (bean != null) {
			log.debug("update:" + bean.getSurveryName());
		} else {
			log.error("update: bean is null!");
		}
		ComResponse<Patientsurveytb> comResponse = new ComResponse<Patientsurveytb>();
		try {
			int result = patientSurveyService.updateData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("更新病案调查问卷");
			comResponse.setExtendResponseContext("更新病案调查问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新病案调查问卷失败." + e.getMessage());
		}
		log.debug("updated:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/patientsv/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Patientsurveytb> delete(@PathVariable Long id) {
		log.debug("delete:" + id);
		ComResponse<Patientsurveytb> comResponse = new ComResponse<Patientsurveytb>();
		try {
			int result = patientSurveyService.deleteDataByKey(id);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除病案调查问卷");
			comResponse.setExtendResponseContext("删除病案调查问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除病案调查问卷失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/patientsv/{patientsurveyId}/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SurveyDetailtb> add(@RequestBody SurveyDetailtb bean,@PathVariable Long patientsurveyId) {
		if (bean != null) {
			log.debug("add:" + bean.getSurverydetailName());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<SurveyDetailtb> comResponse = new ComResponse<SurveyDetailtb>();
		try {
			int result = patientSurveyService.saveAnwser(patientsurveyId, bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("新增病案调查反馈.id:"+patientsurveyId);
			comResponse.setExtendResponseContext("创建病案调查反馈.id:"+patientsurveyId);
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建病案调查反馈." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/patientsv/{patientsurveyId}/addarray", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SurveyDetailtb> addList(@RequestBody List<SurveyDetailtb> beans,@PathVariable Long patientsurveyId) {
		if (beans != null) {
			log.debug("add:" + beans.size());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<SurveyDetailtb> comResponse = new ComResponse<SurveyDetailtb>();
		try {
			SurveyDetailtb lastsurDetail = null;
			if(beans!=null){
				for(SurveyDetailtb surDetail:beans){
					lastsurDetail = surDetail;
					int result = patientSurveyService.saveAnwser(patientsurveyId, surDetail);
				}
			
			}
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(lastsurDetail);
			logService.saveLog("新增病案调查反馈.id:"+patientsurveyId);
			comResponse.setExtendResponseContext("创建病案调查反馈.id:"+patientsurveyId);
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建病案调查反馈." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patientsv/answer")
	public @ResponseBody CommFindEntity<Rspatientsurveysv> findAllAnwser(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
            @RequestParam(value = "patientsurveyId", defaultValue = "0") Long patientsurveyId) {
		log.debug("findAllAnswer.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);

        
		CommFindEntity<Rspatientsurveysv> result = patientSurveyService.findAllAnwser(pager, patientsurveyId);
		return result;
	}
	
}
