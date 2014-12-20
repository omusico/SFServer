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

import com.miaoyou.platform.server.entity.Roletb;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.user.RolesServiceIF;
import com.miaoyou.platform.server.utils.Pager;

@Controller
public class RoleController {
	private static final Log log = LogFactory.getLog(RoleController.class);

	@Resource
	RolesServiceIF roleService;

	@Resource
	LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/role/{id}")
	public @ResponseBody Roletb getById(@PathVariable Integer id) {
		log.debug("RoleController,get:" + id);
		Roletb role = roleService.findUsersRoles(id);
		return role;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/role")
	public @ResponseBody CommFindEntity<Roletb> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "10") int perPage,
			@RequestParam(value = "name", defaultValue = "") String name) {
		log.debug("RoleController,getAll.pageindex" + page + ",perPage:"
				+ perPage);
		Pager pager = new Pager(page, perPage);
		//构造SQL，注意这里的string都是对应数据库中的字段名，不是entity名
        StringBuilder sb = new StringBuilder();
        String andSplit = " and ";
        if(!name.equals("")){
        	sb.append("(role_name").append(" like ").append("\"%"+name+"%\"").append(" or ").append("zujima").append(" like ").append("\""+name+"%\")").append(andSplit);
        }
        if(sb.length()>andSplit.length()){
        	sb.delete((sb.length()-andSplit.length())-1, sb.length()-1);
        }
		CommFindEntity<Roletb> roles = roleService.findUsersRoles(pager,
				sb.toString());

		return roles;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/role/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Roletb> add(@RequestBody Roletb roletb) {
		if (roletb != null) {
			log.debug("RoleController,add:" + roletb.getRoleName());
		} else {
			log.error("RoleController,add: user is null!");
		}

		ComResponse<Roletb> comResponse = new ComResponse<Roletb>();
		try {
			int result = roleService.saveUserRoles(roletb);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(roletb);
			logService.saveLog("新建角色");
			comResponse.setExtendResponseContext("创建角色成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("新建角色失败." + e.getMessage());
		}
		log.debug("RoleController,added:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/role/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Roletb> update(@RequestBody Roletb roletb) {
		if (roletb != null) {
			log.debug("RoleController,add:" + roletb.getRoleName());
		} else {
			log.error("RoleController,add: user is null!");
		}
		ComResponse<Roletb> comResponse = new ComResponse<Roletb>();
		try {
			int result = roleService.updateUserRoles(roletb);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			comResponse.setResponseEntity(roletb);
			logService.saveLog("更新角色");
			comResponse.setExtendResponseContext("更新角色成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("更新角色失败." + e.getMessage());
		}
		log.debug("RoleController,updated:" + comResponse.getResponseStatus());

		return comResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/role/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ComResponse<Roletb> delete(@PathVariable int id) {
		log.debug("RoleController,delete user:" + id);
		ComResponse<Roletb> comResponse = new ComResponse<Roletb>();
		try {
			int result = roleService.deleteUserRoles(id);
			comResponse.setResponseStatus(ComResponse.STATUS_OK);
			logService.saveLog("删除角色");
			comResponse.setExtendResponseContext("删除角色成功.");
		} catch (Exception e) {
			log.error(e);
			comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
			comResponse.setErrorMessage("删除角色失败." + e.getMessage());
		}
		log.debug("RoleController,deleted:" + comResponse.getResponseStatus());

		return comResponse;
	}

}
