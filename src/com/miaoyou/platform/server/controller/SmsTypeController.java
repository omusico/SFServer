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

import com.miaoyou.platform.server.entity.Smstypetb;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.sms.SMSTypeServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * 随访问卷模版
 * 
 * @author 305027939
 *
 */
@Controller
public class SmsTypeController {
	private static final Log log = LogFactory.getLog(SmsTypeController.class);

	@Resource
	SMSTypeServiceIF sMSTypeService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/smstype/{id}")
	public @ResponseBody Smstypetb getById(@PathVariable Long id) {
		log.debug("get:" + id);
		Smstypetb bean = sMSTypeService.findDataByKey(id);
		return bean;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/smstype")
	public @ResponseBody CommFindEntity<Smstypetb> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
            @RequestParam(value = "key", defaultValue = "") String name) {
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);
		 //构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
        StringBuilder sb = new StringBuilder();
        String andSplit = " and ";
        if(!name.equals("")){
        	sb.append("(survery_name").append(" like ").append("\"%"+name+"%\"").append(" or ").append("zujima").append(" like ").append("\""+name+"%\")").append(andSplit);
        }
        if(sb.length()>andSplit.length()){
        	sb.delete((sb.length()-andSplit.length()), sb.length()-1);
        }
        
		CommFindEntity<Smstypetb> result = sMSTypeService.findAll(pager,
				sb.toString());
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/smstype/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Smstypetb> add(@RequestBody Smstypetb bean) {
		if (bean != null) {
			log.debug("add:" + bean.getSmstypeName());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<Smstypetb> comResponse = new ComResponse<Smstypetb>();
		try {
			int result = sMSTypeService.saveData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("新建短信类型");
			comResponse.setExtendResponseContext("创建短信类型成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建短信类型失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/smstype/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Smstypetb> update(@RequestBody Smstypetb bean) {
		if (bean != null) {
			log.debug("update:" + bean.getSmstypeName());
		} else {
			log.error("update: bean is null!");
		}
		ComResponse<Smstypetb> comResponse = new ComResponse<Smstypetb>();
		try {
			int result = sMSTypeService.updateData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("更新短信类型");
			comResponse.setExtendResponseContext("更新短信类型成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新短信类型失败." + e.getMessage());
		}
		log.debug("updated:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/smstype/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Smstypetb> delete(@PathVariable Long id) {
		log.debug("delete:" + id);
		ComResponse<Smstypetb> comResponse = new ComResponse<Smstypetb>();
		try {
			int result = sMSTypeService.deleteDataByKey(id);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除短信类型");
			comResponse.setExtendResponseContext("删除短信类型成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除短信类型失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}

}
