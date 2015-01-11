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

import com.miaoyou.platform.server.entity.child.OutPatienttbRecordCase;
import com.miaoyou.platform.server.entity.child.PatienttbRecordCase;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.patient.OutPatientRecordCaseServiceIF;
import com.miaoyou.platform.server.utils.Pager;


/**
 * 门诊病案
 * @author 305027939
 *
 */
@Controller
public class OutPatientRecordCaseController {
	  private static final Log log = LogFactory.getLog(OutPatientRecordCaseController.class);
	  
	@Resource
	OutPatientRecordCaseServiceIF outpatientRecordCaseService;
	
    @Resource
    LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
    
	 @RequestMapping(method = RequestMethod.GET, value = "/outcase/{id}")
	    public @ResponseBody
	    OutPatienttbRecordCase getById(@PathVariable Long id) {
	        log.debug("get:" + id);
	        OutPatienttbRecordCase bean = outpatientRecordCaseService.findDataByKey(id);
	        return bean;
	    }
	    

	    /**
	     * 查询病患
	     * @param page
	     * @param perPage
	     * @param chuyuanriqi
	     * @param keshi
	     * @param name
	     * @param chuyuanhao
	     * @param zujima
	     * @return
	     */
	    @RequestMapping(method = RequestMethod.GET, value = "/outcase")
	    public @ResponseBody
	    CommFindEntity<OutPatienttbRecordCase> getAll(
	            @RequestParam(value = "psi", defaultValue = "0") int page,
	            @RequestParam(value = "pst", defaultValue = "20") int perPage,
	            @RequestParam(value = "chuyuanriqi", defaultValue = "") Date chuyuanriqi,
	            @RequestParam(value = "keshi", defaultValue = "") String keshi,
	            @RequestParam(value = "patientid", defaultValue = "0") Long patientid,
	            @RequestParam(value = "type", defaultValue = "0") int type,
	            @RequestParam(value = "key", defaultValue = "") String key,
	            @RequestParam(value = "zhuyuanhao", defaultValue = "") String zhuyuanhao,
	            @RequestParam(value = "zujima", defaultValue = "") String zujima) {
	        log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
	        Pager pager = new Pager(page, perPage);
	      
	        if(!key.trim().equals("")){
	        	zhuyuanhao = key;
	        }
	        
	        CommFindEntity<OutPatienttbRecordCase> result = outpatientRecordCaseService.findAll(pager,type, patientid,zhuyuanhao,keshi,chuyuanriqi,zujima);
	        return result;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/outcase/add", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<OutPatienttbRecordCase> add(@RequestBody OutPatienttbRecordCase bean) {
	        if (bean.getPatienttb() != null) {
	            log.debug("add:" + bean.getPatienttb().getName());
	        } else {
	            log.error("add: bean is null!");
	        }

	        ComResponse<OutPatienttbRecordCase> comResponse = new ComResponse<OutPatienttbRecordCase>();
	        try {
	            int result = outpatientRecordCaseService.saveData(bean);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            comResponse.setResponseEntity(bean);
	            logService.saveLog("新建门诊病案");
	            comResponse.setExtendResponseContext("创建门诊病案成功.");
	        } catch (Exception e) {
	            log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("新建门诊病案失败."+e.getMessage());
	        }
	        log.debug("added:" + comResponse.getResponseStatus());
	        
	        return comResponse;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/outcase/update", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<OutPatienttbRecordCase> update(@RequestBody OutPatienttbRecordCase bean) {
	        if (bean != null) {
	            log.debug("update:" + bean.getPatientid());
	        } else {
	            log.error("update: bean is null!");
	        }
	        ComResponse<OutPatienttbRecordCase> comResponse = new ComResponse<OutPatienttbRecordCase>();
	        try {
	            int result = outpatientRecordCaseService.updateData(bean);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            comResponse.setResponseEntity(bean);
	            logService.saveLog("更新门诊病案模版");
	            comResponse.setExtendResponseContext("更新门诊病案成功.");
	        } catch (Exception e) {
	        	log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("更新门诊病案失败."+e.getMessage());
	        }
	        log.debug("updated:" + comResponse.getResponseStatus());
	        
	        return comResponse;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/outcase/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<OutPatienttbRecordCase> delete(@PathVariable Long id) {
	        log.debug("delete:" + id);
	        ComResponse<OutPatienttbRecordCase> comResponse = new ComResponse<OutPatienttbRecordCase>();
	        try {
	            int result =outpatientRecordCaseService.deleteDataByKey(id);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            logService.saveLog("删除门诊病案模版");
	            comResponse.setExtendResponseContext("删除门诊病案成功.");
	        } catch (Exception e) {
	        	log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("删除门诊病案失败."+e.getMessage());
	        }
	        log.debug("deleted:" + comResponse.getResponseStatus());
	         
	        return comResponse;
	    }
	  
	  
}
