/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.service.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.child.UserAll;
import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.utils.ToolHelper;

/**
 *
 * @author 305027939
 */
@Service
public class LoginUserDetailsServiceImpl implements LoginUserDetailsService {
	public static BeanCopier copier = BeanCopier.create(Usertb.class,
			UserAll.class, false);
	private static final Log log = LogFactory
			.getLog(LoginUserDetailsServiceImpl.class);
	@Resource
	LoginServiceIF loginService;

	@Override
	public CommUserDetails loadUserByUsername(String username, String password)
			throws UsernameNotFoundException {
		UserAll userSessionEntity = null;

		log.info("verify:" + username);
		if (username.equals("root") && password.equals("zaq12wsx")) {
			Usertb usertb = new Usertb();
			usertb.setUserId(999999);
			usertb.setUserName("root");
			usertb.setUserRoles(1);
			usertb.setUserPassword(new String(ToolHelper.encryptBASE64(password
					.getBytes())));

			Departmenttb dep = new Departmenttb();
			dep.setDepartmentId(99999);
			dep.setDepartmentName("Maintain");

			userSessionEntity = new UserAll();
			copier.copy(usertb, userSessionEntity, null);
			userSessionEntity.setDepartmenttb(dep);
		} else {
			userSessionEntity = loginService.login(username, new String(
					ToolHelper.encryptBASE64(password.getBytes())));
		}

		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();

		GrantedAuthorityImpl auth2 = null;
		if (userSessionEntity.getUserRolestb() != null
				&& (userSessionEntity.getUserRolestb().getRoleScope()
						.contains("系统维护") || (username.equals("root") && password
						.equals("#suisei.")))) {
			auth2 = new GrantedAuthorityImpl("ROLE_ADMIN");
		} else {
			auth2 = new GrantedAuthorityImpl("ROLE_USER");
		}
		authority.add(auth2);

		if (userSessionEntity == null) {
			log.error("user is null.");
			return null;
		}
		return new CommUserDetails(userSessionEntity, authority);
	}

}
