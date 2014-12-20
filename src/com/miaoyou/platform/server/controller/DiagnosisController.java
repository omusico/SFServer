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

import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.diagnosis.DiagnosisServiceIF;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.utils.Pager;

@Controller
public class DiagnosisController {
	  private static final Log log = LogFactory.getLog(DiagnosisController.class);
	  
	@Resource
	DiagnosisServiceIF diagnosisService;
	
    @Resource
    LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
    
	 @RequestMapping(method = RequestMethod.GET, value = "/dns/{id}")
	    public @ResponseBody
	    Diagnosistb getById(@PathVariable Long id) {
	        log.debug("get:" + id);
	        Diagnosistb bean = diagnosisService.findDataByKey(id);
	        return bean;
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/dns")
	    public @ResponseBody
	    CommFindEntity<Diagnosistb> getAll(
	            @RequestParam(value = "psi", defaultValue = "0") int page,
	            @RequestParam(value = "pst", defaultValue = "20") int perPage,
	            @RequestParam(value = "conditionSql", defaultValue = "") String conditionSql) {
	        log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
	        Pager pager = new Pager(page, perPage);
	        CommFindEntity<Diagnosistb> result = diagnosisService.findAll(pager, conditionSql);
	        return result;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/dns/add", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Diagnosistb> add(@RequestBody Diagnosistb bean) {
	        if (bean != null) {
	            log.debug("add:" + bean.getDiagnosisName());
	        } else {
	            log.error("add: bean is null!");
	        }

	        ComResponse<Diagnosistb> comResponse = new ComResponse<Diagnosistb>();
	        try {
	            int result = diagnosisService.saveData(bean);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            comResponse.setResponseEntity(bean);
	            logService.saveLog("新建病理诊断");
	            comResponse.setExtendResponseContext("创建病理诊断成功.");
	        } catch (Exception e) {
	            log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("新建病理诊断失败."+e.getMessage());
	        }
	        log.debug("added:" + comResponse.getResponseStatus());
	        
	        return comResponse;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/dns/update", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Diagnosistb> update(@RequestBody Diagnosistb bean) {
	        if (bean != null) {
	            log.debug("update:" + bean.getDiagnosisName());
	        } else {
	            log.error("update: bean is null!");
	        }
	        ComResponse<Diagnosistb> comResponse = new ComResponse<Diagnosistb>();
	        try {
	            int result = diagnosisService.updateData(bean);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            comResponse.setResponseEntity(bean);
	            logService.saveLog("更新病理诊断");
	            comResponse.setExtendResponseContext("更新病理诊断成功.");
	        } catch (Exception e) {
	        	log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("更新病理诊断失败."+e.getMessage());
	        }
	        log.debug("updated:" + comResponse.getResponseStatus());
	        
	        return comResponse;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/dns/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Diagnosistb> delete(@PathVariable Long id) {
	        log.debug("delete user:" + id);
	        ComResponse<Diagnosistb> comResponse = new ComResponse<Diagnosistb>();
	        try {
	            int result =diagnosisService.deleteDataByKey(id);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            logService.saveLog("删除病理诊断");
	            comResponse.setExtendResponseContext("删除病理诊断成功.");
	        } catch (Exception e) {
	        	log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("删除病理诊断失败."+e.getMessage());
	        }
	        log.debug("deleted:" + comResponse.getResponseStatus());
	         
	        return comResponse;
	    }
	  
	  
}
