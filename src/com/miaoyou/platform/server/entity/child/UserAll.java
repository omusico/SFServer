package com.miaoyou.platform.server.entity.child;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.Roletb;
import com.miaoyou.platform.server.entity.Usertb;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAll extends Usertb implements Serializable{

	private static final long serialVersionUID = -4835596275154922961L;

	private Departmenttb departmenttb;
	
	private Roletb userRolestb;
	
	private String message;

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Departmenttb getDepartmenttb() {
		return departmenttb;
	}

	public void setDepartmenttb(Departmenttb departmenttb) {
		this.departmenttb = departmenttb;
	}

	public Roletb getUserRolestb() {
		return userRolestb;
	}

	public void setUserRolestb(Roletb userRolestb) {
		this.userRolestb = userRolestb;
	}
	
	
	
}
