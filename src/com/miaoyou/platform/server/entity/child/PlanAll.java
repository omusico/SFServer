package com.miaoyou.platform.server.entity.child;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miaoyou.platform.server.entity.PatienttbWithBLOBs;
import com.miaoyou.platform.server.entity.Sfplantb;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanAll extends Sfplantb implements Serializable{

	private UserAll userAll;
	
	private PatienttbWithBLOBs patienttb;

	public UserAll getUserAll() {
		return userAll;
	}

	public void setUserAll(UserAll userAll) {
		this.userAll = userAll;
	}

	public PatienttbWithBLOBs getPatienttb() {
		return patienttb;
	}

	public void setPatienttb(PatienttbWithBLOBs patienttb) {
		this.patienttb = patienttb;
	}
	
}
