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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoyou.platform.server.entity.Pkgenerator;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.pkkey.PkgeneratorServiceIF;
import com.miaoyou.platform.server.utils.Pager;

@Controller
public class PkController {
	private static final Log log = LogFactory.getLog(PkController.class);

	@Resource
	PkgeneratorServiceIF pkgeneratorService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}


	@RequestMapping(method = RequestMethod.GET, value = "/pk")
	public @ResponseBody CommFindEntity<Pkgenerator> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "1000") int perPage,
			@RequestParam(value = "key", defaultValue = "") String name) {
		log.debug("RoleController,getAll.pageindex" + page + ",perPage:"
				+ perPage);
		Pager pager = new Pager(page, perPage);
		CommFindEntity<Pkgenerator> roles = pkgeneratorService.findAll(pager,
				"");

		return roles;
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/pk/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Pkgenerator> update(@RequestBody Pkgenerator pkbean) {
		
		log.error("update,update:"+pkbean.getTargettable());
		
		ComResponse<Pkgenerator> comResponse = new ComResponse<Pkgenerator>();
		try {
			int result = pkgeneratorService.updateData(pkbean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(pkbean);
			logService.saveLog("更新主键");
			comResponse.setExtendResponseContext("更新主键成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新主键失败." + e.getMessage());
		}
		log.debug("updated:" + comResponse.getResponseStatus());

		return comResponse;
	}


}
