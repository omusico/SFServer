/*
 * 2014 Chengdu JunChen Technology
 */

package com.miaoyou.platform.server.service.user;

import com.miaoyou.platform.server.entity.common.CommUserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author 305027939
 */
public interface LoginUserDetailsService {
    CommUserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException;
}
