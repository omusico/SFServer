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

import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.survey.SurveyServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * 随访问卷模版
 * 
 * @author 305027939
 *
 */
@Controller
public class SurveyController {
	private static final Log log = LogFactory.getLog(SurveyController.class);

	@Resource
	SurveyServiceIF surveyService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sv/{id}")
	public @ResponseBody Surveytb getById(@PathVariable Long id) {
		log.debug("get:" + id);
		Surveytb bean = surveyService.findDataByKey(id);
		return bean;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sv")
	public @ResponseBody CommFindEntity<Surveytb> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
            @RequestParam(value = "key", defaultValue = "") String name,
            @RequestParam(value = "type", defaultValue = "-1") int type) {
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);
		 //构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
        StringBuilder sb = new StringBuilder();
        String andSplit = " and ";
        if(!name.equals("")){
        	sb.append("(survery_name").append(" like ").append("\"%"+name+"%\"").append(" or ").append("zujima").append(" like ").append("\""+name+"%\")").append(andSplit);
        }
       
        if(type>-1){
           sb.append("svtype").append(" = ").append(type).append(andSplit);
        }
        if(sb.length()>andSplit.length()){
        	sb.delete((sb.length()-andSplit.length()), sb.length()-1);
        }
        
		CommFindEntity<Surveytb> result = surveyService.findAll(pager,
				sb.toString());
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sv/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Surveytb> add(@RequestBody Surveytb bean) {
		if (bean != null) {
			log.debug("add:" + bean.getSurveryName());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<Surveytb> comResponse = new ComResponse<Surveytb>();
		try {
			int result = surveyService.saveData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("新建调查问卷模版");
			comResponse.setExtendResponseContext("创建调查问卷模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建调查问卷模版失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sv/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Surveytb> update(@RequestBody Surveytb bean) {
		if (bean != null) {
			log.debug("update:" + bean.getSurveryName());
		} else {
			log.error("update: bean is null!");
		}
		ComResponse<Surveytb> comResponse = new ComResponse<Surveytb>();
		try {
			int result = surveyService.updateData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("更新调查问卷模版");
			comResponse.setExtendResponseContext("更新调查问卷模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新调查问卷模版失败." + e.getMessage());
		}
		log.debug("updated:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sv/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Surveytb> delete(@PathVariable Long id) {
		log.debug("delete:" + id);
		ComResponse<Surveytb> comResponse = new ComResponse<Surveytb>();
		try {
			int result = surveyService.deleteDataByKey(id);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除调查问卷模版");
			comResponse.setExtendResponseContext("删除调查问卷模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除调查问卷模版失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}

}
