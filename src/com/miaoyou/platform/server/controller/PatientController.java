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

import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.patient.PatientServiceIF;
import com.miaoyou.platform.server.utils.Pager;


/**
 * 病案
 * @author 305027939
 *
 */
@Controller
public class PatientController {
	  private static final Log log = LogFactory.getLog(PatientController.class);
	  
	@Resource
	PatientServiceIF patientService;
	
    @Resource
    LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
    
	 @RequestMapping(method = RequestMethod.GET, value = "/patient/{id}")
	    public @ResponseBody
	    Patienttb getById(@PathVariable Long id) {
	        log.debug("get:" + id);
	        Patienttb bean = patientService.findDataByKey(id);
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
	    @RequestMapping(method = RequestMethod.GET, value = "/patient")
	    public @ResponseBody
	    CommFindEntity<Patienttb> getAll(
	            @RequestParam(value = "psi", defaultValue = "0") int page,
	            @RequestParam(value = "pst", defaultValue = "20") int perPage,
	            @RequestParam(value = "chuyuanriqi", defaultValue = "") String chuyuanriqi,
	            @RequestParam(value = "keshi", defaultValue = "") String keshi,
	            @RequestParam(value = "key", defaultValue = "") String name,
	            @RequestParam(value = "zhuyuanhao", defaultValue = "") String zhuyuanhao,
	            @RequestParam(value = "phone", defaultValue = "") String phone) {
	        log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
	        Pager pager = new Pager(page, perPage);
	        
	        //构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
	        StringBuilder sb = new StringBuilder();
	        String andSplit = " and ";
	        if(!chuyuanriqi.equals("")){
	        	sb.append("chuyuanriqi").append(" = ").append("\""+chuyuanriqi+"\"").append(andSplit);
	        }
	        if(!zhuyuanhao.equals("")){
	        	sb.append("zhuyuanhao").append(" = ").append("\""+zhuyuanhao+"\"").append(andSplit);
	        }
	        if(!keshi.equals("")){
	        	sb.append("keshi").append(" like ").append("\"%"+keshi+"%\"").append(andSplit);
	        }
	        if(!name.equals("")){
	        	sb.append("(name").append(" like ").append("\"%"+name+"%\"").append(" or ").append("zujima").append(" like ").append("\""+name+"%\")").append(andSplit);
	        }
	       
	        if(!phone.equals("")){
	        	sb.append("(phone").append(" = ").append("\""+phone+"\"").append(" or ").append("telphone").append(" like ").append("\""+phone+"\")").append(andSplit);
	        }
	        
	        if(sb.length()>andSplit.length()){
	        	sb.delete((sb.length()-andSplit.length()), sb.length()-1);
	        }
	        
	        CommFindEntity<Patienttb> result = patientService.findAll(pager, sb.toString());
	        return result;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/patient/add", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Patienttb> add(@RequestBody Patienttb bean) {
	        if (bean!= null) {
	            log.debug("add:" + bean.getName());
	        } else {
	            log.error("add: bean is null!");
	        }

	        ComResponse<Patienttb> comResponse = new ComResponse<Patienttb>();
	        try {
	            int result = patientService.saveData(bean);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            comResponse.setResponseEntity(bean);
	            logService.saveLog("新建病患基本信息");
	            comResponse.setExtendResponseContext("创建病案成功.");
	        } catch (Exception e) {
	            log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("新建病患基本信息失败."+e.getMessage());
	        }
	        log.debug("added:" + comResponse.getResponseStatus());
	        
	        return comResponse;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/patient/update", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Patienttb> update(@RequestBody Patienttb bean) {
	        if (bean != null) {
	            log.debug("update:" + bean.getPatientid());
	        } else {
	            log.error("update: bean is null!");
	        }
	        ComResponse<Patienttb> comResponse = new ComResponse<Patienttb>();
	        try {
	            int result = patientService.updateData(bean);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            comResponse.setResponseEntity(bean);
	            logService.saveLog("更新病患基本信息模版");
	            comResponse.setExtendResponseContext("更新病案成功.");
	        } catch (Exception e) {
	        	log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("更新病患基本信息失败."+e.getMessage());
	        }
	        log.debug("updated:" + comResponse.getResponseStatus());
	        
	        return comResponse;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/patient/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Patienttb> delete(@PathVariable Long id) {
	        log.debug("delete:" + id);
	        ComResponse<Patienttb> comResponse = new ComResponse<Patienttb>();
	        try {
	            int result =patientService.deleteDataByKey(id);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            logService.saveLog("删除病患基本信息");
	            comResponse.setExtendResponseContext("删除病患基本信息成功.");
	        } catch (Exception e) {
	        	log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("删除病患基本信息失败."+e.getMessage());
	        }
	        log.debug("deleted:" + comResponse.getResponseStatus());
	         
	        return comResponse;
	    }
	  
	  
}
