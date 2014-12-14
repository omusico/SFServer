/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.service.user;

import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.UsertbExample;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.mapper.UsertbMapper;

/**
 *
 * @author 305027939
 */
@Service
public class LoginService implements LoginServiceIF {
	public static BeanCopier copier = BeanCopier.create(Usertb.class, UserAll.class, false);
    private static final Log log = LogFactory.getLog(LoginService.class);

    @Resource
    private UsertbMapper mapper;
    @Resource
    private RolesServiceIF roleService;
    @Resource
    private DepartmentServiceIF departService;

    @Override
    public UserAll login(String userName, String passed) {
        
    	UserAll userall = new UserAll();
        log.debug("try to login with:" + userName);
        UsertbExample userExm = new UsertbExample();
        userExm.createCriteria().andUserNameEqualTo(userName).andUserPasswordEqualTo(passed);
        List<Usertb> users = mapper.selectByExample(userExm);
        if (users != null && users.size() > 0) {
            Usertb user = users.get(0);
            if (user.getDepartmentId() != null && user.getDepartmentId() > 0) {
                Departmenttb department = departService.findDepartmentById(user.getDepartmentId());
                userall.setDepartmenttb(department);
            }
            copier.copy(user, userall, null);
            userall.setUserRolestb(roleService.findUsersRoles(user.getUserRoles()));
        }

        return userall;
    }

}
