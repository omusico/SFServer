package com.miaoyou.platform.server.entity.child;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miaoyou.platform.server.entity.Sfplantb;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanAll extends Sfplantb implements Serializable{

	private UserAll userAll;

	public UserAll getUserAll() {
		return userAll;
	}

	public void setUserAll(UserAll userAll) {
		this.userAll = userAll;
	}
	
}
