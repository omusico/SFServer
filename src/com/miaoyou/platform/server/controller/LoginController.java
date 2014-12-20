/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.controller;

	
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.service.log.LogIF;
import com.miaoyou.platform.server.service.user.LoginServiceIF;

/**
 *
 * @author 305027939
 */
@Controller
public class LoginController {

    private static final Log log = LogFactory.getLog(UserController.class);
    @Resource
    LoginServiceIF loginService;
    @Resource
    LogIF logService;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
    
    @RequestMapping(method = RequestMethod.GET, value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    UserAll login() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            if (principal instanceof CommUserDetails) {
            	CommUserDetails user = (CommUserDetails) principal;
                log.info("LoginController,Got UserDetails object." + user.getUsername());
                UserAll usertb = user.getUserSessionEntity();
                if (usertb != null) {
                    log.info("LoginController," + usertb.getUserName() + ",logined.");
                } else {
                    log.error("LoginController,user is not exist.");
                }
                logService.saveLog("登录系统");

                return usertb;
            } else {
                log.error("LoginController,login failed. principal is not a  UserDetails object!");
                return null;
            }
        } else {
            log.error("LoginController,login failed. principal is null!");
            return null;
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/timeout", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ComResponse<String> errorInfo(HttpServletRequest request, HttpServletResponse response) {
        ComResponse<String> comResponse = new ComResponse<String>();
        SecurityContextHolder.clearContext();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); //使当前会话失效       
        }
        log.info("LoginController,session timeout.");
        comResponse.setResponseStatus(ComResponse.STATUS_TIMEOUT);
        comResponse.setErrorMessage("当前回话已经过期.");

        return comResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout/clear")
    public @ResponseBody
    ComResponse<String> logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        ComResponse<String> comResponse = new ComResponse<String>();
        SecurityContextHolder.clearContext();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); //使当前会话失效       
        }
        log.info("LoginController,logout.invalidate session");
        comResponse.setResponseStatus(ComResponse.STATUS_OK);
        return comResponse;
    }
}

