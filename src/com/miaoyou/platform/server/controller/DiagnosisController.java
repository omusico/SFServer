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

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.Rskeshidns;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.diagnosis.DiagnosisServiceIF;
import com.miaoyou.platform.server.service.diagnosis.KeshiDiagnosisServiceIF;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.utils.Pager;

@Controller
public class DiagnosisController {
	  private static final Log log = LogFactory.getLog(DiagnosisController.class);
	  
	@Resource
	DiagnosisServiceIF diagnosisService;
	
	@Resource
	KeshiDiagnosisServiceIF keshiDiagnosisService;
	
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
	            @RequestParam(value = "key", defaultValue = "") String name) {
	        log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
	        Pager pager = new Pager(page, perPage);
	        //构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
	        StringBuilder sb = new StringBuilder();
	        String andSplit = " and ";
	        if(!name.equals("")){
	        	sb.append("(diagnosis_name").append(" like ").append("\"%"+name+"%\"").append(" or ").append("zujima").append(" like ").append("\""+name+"%\")").append(andSplit);
	        }
	        if(sb.length()>andSplit.length()){
	        	sb.delete((sb.length()-andSplit.length()), sb.length()-1);
	        }
	        CommFindEntity<Diagnosistb> result = diagnosisService.findAll(pager, sb.toString());
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
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/dns/keshi/{departmentId}")
	    public @ResponseBody
	    CommFindEntity<Diagnosistb> findKeshiDns(
	            @RequestParam(value = "psi", defaultValue = "0") int page,
	            @RequestParam(value = "pst", defaultValue = "20") int perPage,@PathVariable int departmentId) {
	        log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
	        Pager pager = new Pager(page, perPage);
	        CommFindEntity<Diagnosistb> result = keshiDiagnosisService.findDns(pager, departmentId);
	        return result;
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/dp/dns/{diagnosisId}")
	    public @ResponseBody
	    CommFindEntity<Departmenttb> findDnsKeshi(
	            @RequestParam(value = "psi", defaultValue = "0") int page,
	            @RequestParam(value = "pst", defaultValue = "20") int perPage,@PathVariable Long diagnosisId) {
	        log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
	        Pager pager = new Pager(page, perPage);
	        CommFindEntity<Departmenttb> result = keshiDiagnosisService.findDep(pager, diagnosisId);
	        return result;
	    }

	    
	    @RequestMapping(method = RequestMethod.POST, value = "/dnskeshi/add/{departmentId}/{diagnosisId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Rskeshidns> addkeshidns(@PathVariable int departmentId,@PathVariable Long diagnosisId) {
	       
	         log.debug("add:departmentId:" + departmentId+",diagnosisId:"+diagnosisId);
	        
	        ComResponse<Rskeshidns> comResponse = new ComResponse<Rskeshidns>();
	        try {
	            int result = keshiDiagnosisService.saveKeshiDns(departmentId, diagnosisId);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            comResponse.setResponseEntity(null);
	            logService.saveLog("关联科室和病理诊断");
	            comResponse.setExtendResponseContext("关联科室和病理诊断成功.");
	        } catch (Exception e) {
	            log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("关联科室和病理诊断失败."+e.getMessage());
	        }
	        log.debug("added:" + comResponse.getResponseStatus());
	        
	        return comResponse;
	    }

	    @RequestMapping(method = RequestMethod.POST, value = "/dnskeshi/delete/{departmentId}/{diagnosisId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Rskeshidns> deletekeshidns(@PathVariable int departmentId,@PathVariable Long diagnosisId) {
	    	log.debug("add:departmentId:" + departmentId+",diagnosisId:"+diagnosisId);
	        ComResponse<Rskeshidns> comResponse = new ComResponse<Rskeshidns>();
	        try {
	            int result =keshiDiagnosisService.deleteKeshiDns(departmentId, diagnosisId);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            logService.saveLog("删除关联科室和病理诊断");
	            comResponse.setExtendResponseContext("删除关联科室和病理诊断.");
	        } catch (Exception e) {
	        	log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("删除关联科室和病理诊断失败."+e.getMessage());
	        }
	        log.debug("deleted:" + comResponse.getResponseStatus());
	         
	        return comResponse;
	    }
	    
	    @RequestMapping(method = RequestMethod.POST, value = "/dnskeshi/delete/{diagnosisId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ComResponse<Rskeshidns> deletekeshidns(@PathVariable Long diagnosisId) {
	    	log.debug("add:departmentId,diagnosisId:"+diagnosisId);
	        ComResponse<Rskeshidns> comResponse = new ComResponse<Rskeshidns>();
	        try {
	            int result =keshiDiagnosisService.deleteKeshiByDns(diagnosisId);
	            comResponse.setResponseStatus(ComResponse.STATUS_OK);
	            logService.saveLog("删除关联科室和病理诊断,根据诊断ID");
	            comResponse.setExtendResponseContext("根据诊断ID。删除关联科室和病理诊断.");
	        } catch (Exception e) {
	        	log.error(e);
	            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
	            comResponse.setErrorMessage("根据诊断ID,删除关联科室和病理诊断失败."+e.getMessage());
	        }
	        log.debug("deleted:" + comResponse.getResponseStatus());
	         
	        return comResponse;
	    }
	  
	  
}
