/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.entity.common;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.miaoyou.platform.server.entity.child.UserAll;

/**
 *
 * @author 305027939
 */
public class CommUserDetails extends User {

	private static final long serialVersionUID = 1L;
	private UserAll userSessionEntity;

    public CommUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CommUserDetails(UserAll userSessionEntity,Collection<? extends GrantedAuthority> authorities) {
        super(userSessionEntity.getUserName(), userSessionEntity.getUserPassword(), authorities);
        this.userSessionEntity = userSessionEntity;
    }

    public UserAll getUserSessionEntity() {
        return userSessionEntity;
    }

}
