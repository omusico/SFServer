package com.miaoyou.platform.server.entity.child;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.Sfplansmstb;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanSmsAll extends Sfplansmstb implements Serializable{

	private UserAll userAll;
	
	private Patienttb patienttb;

	public UserAll getUserAll() {
		return userAll;
	}

	public void setUserAll(UserAll userAll) {
		this.userAll = userAll;
	}

	public Patienttb getPatienttb() {
		return patienttb;
	}

	public void setPatienttb(Patienttb patienttb) {
		this.patienttb = patienttb;
	}
	
}
