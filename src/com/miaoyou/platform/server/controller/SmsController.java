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

import com.miaoyou.platform.server.entity.Rsdnssmsaddtb;
import com.miaoyou.platform.server.entity.child.SMSAll;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.sms.SMSServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * 随访问卷模版
 * 
 * @author 305027939
 *
 */
@Controller
public class SmsController {
	private static final Log log = LogFactory.getLog(SmsController.class);

	@Resource
	SMSServiceIF sMSService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sms/{id}")
	public @ResponseBody SMSAll getById(@PathVariable Long id) {
		log.debug("get:" + id);
		SMSAll bean = sMSService.findDataByKey(id);
		return bean;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sms")
	public @ResponseBody CommFindEntity<SMSAll> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
            @RequestParam(value = "key", defaultValue = "") String name) {
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);
		 //构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
        StringBuilder sb = new StringBuilder();
        String andSplit = " and ";
        if(!name.equals("")){
        	sb.append("(sms_name").append(" like ").append("\"%"+name+"%\"").append(" or ").append("zujima").append(" like ").append("\""+name+"%\")").append(andSplit);
        }
        if(sb.length()>andSplit.length()){
        	sb.delete((sb.length()-andSplit.length()), sb.length()-1);
        }
        
		CommFindEntity<SMSAll> result = sMSService.findAll(pager,
				sb.toString());
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sms/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SMSAll> add(@RequestBody SMSAll bean) {
		if (bean != null) {
			log.debug("add:" + bean.getSmsName());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<SMSAll> comResponse = new ComResponse<SMSAll>();
		try {
			int result = sMSService.saveData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("新建短信模版");
			comResponse.setExtendResponseContext("创建短信模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建短信模版失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sms/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SMSAll> update(@RequestBody SMSAll bean) {
		if (bean != null) {
			log.debug("update:" + bean.getSmsName());
		} else {
			log.error("update: bean is null!");
		}
		ComResponse<SMSAll> comResponse = new ComResponse<SMSAll>();
		try {
			int result = sMSService.updateData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("更新短信模版");
			comResponse.setExtendResponseContext("更新短信模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新短信模版失败." + e.getMessage());
		}
		log.debug("updated:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sms/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<SMSAll> delete(@PathVariable Long id) {
		log.debug("delete:" + id);
		ComResponse<SMSAll> comResponse = new ComResponse<SMSAll>();
		try {
			int result = sMSService.deleteDataByKey(id);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除短信模版");
			comResponse.setExtendResponseContext("删除短信模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除短信模版失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/sms/dpdnd/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Rsdnssmsaddtb> addSmsForDnsSp(@RequestBody Rsdnssmsaddtb bean) {
		if (bean != null) {
			log.debug("addSmsForDnsSp:" + bean.getSmsName());
		} else {
			log.error("addSmsForDnsSp: bean is null!");
		}

		ComResponse<Rsdnssmsaddtb> comResponse = new ComResponse<Rsdnssmsaddtb>();
		try {
			int result = sMSService.saveSmsForDpDns(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("新建科室疾病短信模版");
			comResponse.setExtendResponseContext("创建科室疾病短信模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建科室疾病短信模版失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sms/dpdnd/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Rsdnssmsaddtb> deleteSmsForDnsSp(@RequestBody Rsdnssmsaddtb bean) {
		log.debug("deleteSmsForDnsSp:" + bean.getSmsName());
		ComResponse<Rsdnssmsaddtb> comResponse = new ComResponse<Rsdnssmsaddtb>();
		try {
			int result = sMSService.deleteSmsForDpDns(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除科室疾病短信模版");
			comResponse.setExtendResponseContext("删除科室疾病短信模版成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除科室疾病短信模版失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sms/dpdns/{dpId}/{dnsId}")
	public @ResponseBody CommFindEntity<Rsdnssmsaddtb> getAllForDpDns(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,@PathVariable Integer dpId,@PathVariable Long dnsId) {
		log.debug("getAllForDpDns.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);
        
		CommFindEntity<Rsdnssmsaddtb> result = sMSService.findAllByDpDns(pager, dpId, dnsId);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sms/type/{name}")
	public @ResponseBody CommFindEntity<SMSAll> getAllBySmsType( @PathVariable String name) {
		log.debug("getAll.getAllBySmsType,type" + name );

		CommFindEntity<SMSAll> result = sMSService.findAll(name);
		return result;
	}

}
