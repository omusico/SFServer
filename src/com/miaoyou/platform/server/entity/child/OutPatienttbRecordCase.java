package com.miaoyou.platform.server.entity.child;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.RecordcaseopdtbWithBLOBs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OutPatienttbRecordCase extends RecordcaseopdtbWithBLOBs implements Serializable{

	private Patienttb patienttb;

	public Patienttb getPatienttb() {
		return patienttb;
	}

	public void setPatienttb(Patienttb patienttb) {
		this.patienttb = patienttb;
	}

	
}