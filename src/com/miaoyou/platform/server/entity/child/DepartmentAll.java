package com.miaoyou.platform.server.entity.child;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miaoyou.platform.server.entity.Departmenttb;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentAll extends Departmenttb implements Serializable{

	public DepartmentAll parentDp;

	public DepartmentAll getParentDp() {
		return parentDp;
	}

	public void setParentDp(DepartmentAll parentDp) {
		this.parentDp = parentDp;
	}

	
	
}
