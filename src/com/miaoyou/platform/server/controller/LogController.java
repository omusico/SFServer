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

import com.miaoyou.platform.server.entity.Logtb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * log
 * 
 * @author 305027939
 *
 */
@Controller
public class LogController {
	private static final Log log = LogFactory.getLog(LogController.class);

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/log")
	public @ResponseBody CommFindEntity<Logtb> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@RequestParam(value = "conditionSql", defaultValue = "") String conditionSql,
			@RequestParam(value = "startDate", defaultValue = "") String startDate,
			@RequestParam(value = "endDate", defaultValue = "") String endDate) {
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);
		CommFindEntity<Logtb> result = logService.findAll(pager, conditionSql,
				startDate, endDate);
		return result;
	}

}
