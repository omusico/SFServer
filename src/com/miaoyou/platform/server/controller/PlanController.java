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

import com.miaoyou.platform.server.entity.Sfplantb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.PlanAll;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.plan.SFPlaneServiceIF;
import com.miaoyou.platform.server.utils.Pager;

/**
 * 随访问卷模版
 * 
 * @author 305027939
 *
 */
@Controller
public class PlanController {
	private static final Log log = LogFactory.getLog(PlanController.class);

	@Resource
	SFPlaneServiceIF sFPlaneService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/plan/{id}")
	public @ResponseBody PlanAll getById(@PathVariable Long id) {
		log.debug("get:" + id);
		PlanAll bean = sFPlaneService.findDataByKey(id);
		return bean;
	}
	

//	@RequestMapping(method = RequestMethod.GET, value = "/plan")
//	public @ResponseBody CommFindEntity<Sfplantb> getAll(
//			@RequestParam(value = "psi", defaultValue = "0") int page,
//			@RequestParam(value = "pst", defaultValue = "20") int perPage,
//			@RequestParam(value = "conditionSql", defaultValue = "") String conditionSql) {
//		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
//		Pager pager = new Pager(page, perPage);
//		CommFindEntity<Sfplantb> result = sFPlaneService.findAll(pager,
//				conditionSql);
//		return result;
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/plan")
	public @ResponseBody CommFindEntity<PlanAll> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "status", defaultValue = "0") int status,
			@RequestParam(value = "patientid", defaultValue = "0") long patientid,
			@RequestParam(value = "startDate", defaultValue = "") String startDate,
			@RequestParam(value = "endDate", defaultValue = "") String endDate,
			@RequestParam(value = "key", defaultValue = "") String name) {
		log.debug("getAll.pageindex" + page + ",perPage:" + perPage);
		Pager pager = new Pager(page, perPage);

		// 构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
		StringBuilder sb = new StringBuilder();
		String andSplit = " and ";
		
		/*不要删除的数据*/
		sb.append("delete_flag").append(" = ").append(0).append(andSplit);
		
		if (type >= 0) {
			sb.append("plantype").append(" = ").append(type)
					.append(andSplit);
		}
		if (status >= 0) {
			sb.append("status").append(" = ").append(status)
					.append(andSplit);
		}
		
		if (patientid > 0) {
			sb.append("patientid").append(" = ").append(patientid)
					.append(andSplit);
		}
		
		if (!startDate.equals("") && !endDate.equals("")) {
			sb.append("(plannexttime").append(" between ")
					.append("\"" + startDate + "\"").append(andSplit)
					.append("\"" + endDate + "\")").append(andSplit);
		} else if (!startDate.equals("")) {
			sb.append("(plannexttime").append(" >= ")
					.append("\"" + startDate + "\"").append(andSplit);
		} else if (!endDate.equals("")) {
			sb.append("(plannexttime").append(" <= ")
					.append("\"" + endDate + "\"").append(andSplit);
		}

		if (!name.equals("")) {
			sb.append("(planname").append(" like ")
					.append("\"%" + name + "%\"").append(" or ")
					.append("zujima").append(" like ")
					.append("\"" + name + "%\")").append(andSplit);
		}

		if (sb.length() > andSplit.length()) {
			sb.delete((sb.length() - andSplit.length()), sb.length() - 1);
		}

		CommFindEntity<PlanAll> result = sFPlaneService.findAll(pager,
				sb.toString());
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/plan/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<PlanAll> add(@RequestBody PlanAll bean) {
		if (bean != null) {
			log.debug("add:" + bean.getPlanname());
		} else {
			log.error("add: bean is null!");
		}

		ComResponse<PlanAll> comResponse = new ComResponse<PlanAll>();
		try {
			int result = sFPlaneService.saveData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("新建电话随访计划,病案ID:"+bean.getPatientid());
			comResponse.setExtendResponseContext("创建电话随访计划成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建电话随访计划失败." + e.getMessage());
		}
		log.debug("added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/plan/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<PlanAll> update(@RequestBody PlanAll bean) {
		if (bean != null) {
			log.debug("update:" + bean.getPlanname());
		} else {
			log.error("update: bean is null!");
		}
		ComResponse<PlanAll> comResponse = new ComResponse<PlanAll>();
		try {
			int result = sFPlaneService.updateData(bean);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(bean);
			logService.saveLog("更新电话随访计划,病案ID:"+bean.getPatientid());
			comResponse.setExtendResponseContext("更新电话随访计划成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新电话随访计划失败." + e.getMessage());
		}
		log.debug("updated:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/plan/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<PlanAll> delete(@PathVariable Long id) {
		log.debug("delete:" + id);
		ComResponse<PlanAll> comResponse = new ComResponse<PlanAll>();
		try {
			int result = sFPlaneService.deleteDataByKey(id);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除电话随访计划");
			comResponse.setExtendResponseContext("删除电话随访计划成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除电话随访计划失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/plan/survey/{planId}")
	public  @ResponseBody CommFindEntity<Surveytb> getSurveyByDns(@PathVariable Long planId) {
		log.debug("getSurveyByDns:" + planId);
		return sFPlaneService.findSurveyByPlanId(planId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/plan/survey/delete/{planId}/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Sfplantb> deleteForPatientSurvey(@PathVariable Long planId,@PathVariable Long surveryId) {
		log.debug("delete:" + surveryId);
		ComResponse<Sfplantb> comResponse = new ComResponse<Sfplantb>();
		try {
			int result = sFPlaneService.deleteDataByKeyForPatientSurvey(planId, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除电话随访计划问卷");
			comResponse.setExtendResponseContext("删除电话随访计划问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除电话随访计划问卷失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/plan/survey/add/{planId}/{surveryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<PlanAll> addForPatientSurvey(@PathVariable Long planId,@PathVariable Long surveryId) {
		log.debug("delete:" + surveryId);
		ComResponse<PlanAll> comResponse = new ComResponse<PlanAll>();
		try {
			int result = sFPlaneService.saveDataForPatientSurvey(planId, surveryId);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("增加电话随访计划问卷");
			comResponse.setExtendResponseContext("增加电话随访计划问卷成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("增加电话随访计划问卷失败." + e.getMessage());
		}
		log.debug("deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}
	
}
