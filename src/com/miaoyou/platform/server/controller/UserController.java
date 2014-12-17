package com.miaoyou.platform.server.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.user.DepartmentServiceIF;
import com.miaoyou.platform.server.service.user.UserServiceIF;
import com.miaoyou.platform.server.utils.Pager;

@Controller
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);

    @Resource
    UserServiceIF userService;

    @Resource
    DepartmentServiceIF departmentService;
    
    @Resource
    LogIF logService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public @ResponseBody
    Usertb getUser(@PathVariable String id) {
        log.debug("UserController,getUser:" + id);
        Usertb users = userService.findUser(Integer.parseInt(id));
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public @ResponseBody
    CommFindEntity<UserAll> getAllUsers(
            @RequestParam(value = "psi", defaultValue = "0") int page,
            @RequestParam(value = "pst", defaultValue = "10") int perPage,
            @RequestParam(value = "conditionSql", defaultValue = "") String conditionSql) {
        log.debug("UserController,getAllUser.pageindex" + page + ",perPage:" + perPage);
        Pager pager = new Pager(page, perPage);
        CommFindEntity<UserAll> users = null;
        if (conditionSql.trim().equals("")) {
            users = userService.findAllUsers(pager);
        } else {
            users = userService.findAllUsers(pager, conditionSql);
        }
        return users;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Usertb> addUser(@RequestBody Usertb user) {
        if (user != null) {
            log.debug("UserController,addUser:" + user.getUserName());
        } else {
            log.error("UserController,adduser: user is null!");
        }

        ComResponse<Usertb> comResponse = new ComResponse<Usertb>();
        try {
            int result = userService.saveUser(user);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
            comResponse.setResponseEntity(user);
            logService.saveLog("新建用户");
            comResponse.setExtendResponseContext("创建用户成功.");
        } catch (Exception e) {
            log.error(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage("新建用户失败."+e.getMessage());
        }
        log.debug("UserController,added user:" + comResponse.getResponseStatus());
        
        return comResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Usertb> updateUser(@RequestBody Usertb user) {
        if (user != null) {
            log.debug("UserController,addUser:" + user.getUserName());
        } else {
            log.error("UserController,adduser: user is null!");
        }
        ComResponse<Usertb> comResponse = new ComResponse<Usertb>();
        try {
            int result = userService.updateUser(user);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
            comResponse.setResponseEntity(user);
            logService.saveLog("更新用户");
            comResponse.setExtendResponseContext("更新用户成功.");
        } catch (Exception e) {
        	log.error(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage("更新用户失败."+e.getMessage());
        }
        log.debug("UserController,update user:" + comResponse.getResponseStatus());
        
        return comResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Usertb> deleteUser(@PathVariable int id) {
        log.debug("UserController,delete user:" + id);
        ComResponse<Usertb> comResponse = new ComResponse<Usertb>();
        try {
            int result = userService.deleteUser(id);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
            logService.saveLog("删除用户");
            comResponse.setExtendResponseContext("删除用户成功.");
        } catch (Exception e) {
        	log.error(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage("删除用户失败."+e.getMessage());
        }
        log.debug("UserController,delete user:" + comResponse.getResponseStatus());
         
        return comResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dp")
    public @ResponseBody
    CommFindEntity<Departmenttb> getDepartments() {
        log.debug("UserController,getDepartments");
        CommFindEntity<Departmenttb> allDepartment = departmentService.findDepartments();
        return allDepartment;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/finddp")
    public @ResponseBody
    CommFindEntity<Departmenttb> findDepartments(
            @RequestParam(value = "psi", defaultValue = "1") int page,
            @RequestParam(value = "pst", defaultValue = "100") int perPage,
            @RequestParam(value = "conditionSql", defaultValue = "") String conditionSql) {
        log.debug("UserController,findDepartments.pageindex" + page + ",perPage:" + perPage);
        Pager pager = new Pager(page, perPage);
        CommFindEntity<Departmenttb> departments = null;
        if (conditionSql.trim().equals("")) {
            departments = departmentService.findDepartments();
        } else {
            departments = departmentService.findDepartments(pager, conditionSql);
        }
        return departments;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dp/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Departmenttb> saveDepartment(@RequestBody Departmenttb department) {
        log.debug("UserController,save department:" + department.getDepartmentName());

        ComResponse<Departmenttb> comResponse = new ComResponse<Departmenttb>();
        try {
            int result = departmentService.saveDepartment(department);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
            comResponse.setResponseEntity(department);
        } catch (Exception e) {
            log.equals(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage(e.getMessage());
        }
        log.debug("UserController,saved department:" + comResponse.getResponseStatus());
        return comResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dp/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Departmenttb> updateDepartment(@RequestBody Departmenttb department) {
        log.debug("UserController,update department:" + department.getDepartmentId());

        ComResponse<Departmenttb> comResponse = new ComResponse<Departmenttb>();
        try {
            int result = departmentService.updateDepartment(department);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
            comResponse.setResponseEntity(department);
        } catch (Exception e) {
            log.equals(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage(e.getMessage());
        }
        log.debug("UserController,update department:" + comResponse.getResponseStatus());
         logService.saveLog("更新部门");
        return comResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dp/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<Departmenttb> deleteDepartment(@PathVariable int id) {
        log.debug("UserController,delete department:" + id);
        departmentService.deleteDepartment(id);
        ComResponse<Departmenttb> comResponse = new ComResponse<Departmenttb>();
        try {
            int result = userService.deleteUser(id);
            comResponse.setResponseStatus(ComResponse.STATUS_OK);
        } catch (Exception e) {
            log.equals(e);
            comResponse.setResponseStatus(ComResponse.STATUS_FAIL);
            comResponse.setErrorMessage(e.getMessage());
        }
        log.debug("UserController,delete department:" + comResponse.getResponseStatus());
         logService.saveLog("删除部门");
        return comResponse;
    }
    
}
