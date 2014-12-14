/*
 * 2014 Chengdu JunChen Technology
 */

package com.miaoyou.platform.server.service.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.miaoyou.platform.server.entity.common.CommUserDetails;

/**
 *
 * @author 305027939
 */
public interface LoginUserDetailsService {
    CommUserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException;
}
