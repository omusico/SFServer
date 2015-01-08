package com.miaoyou.platform.server.entity.child;

import com.miaoyou.platform.server.entity.Smstb;
import com.miaoyou.platform.server.entity.Smstypetb;

public class SMSAll extends Smstb{

	private Smstypetb smstypetb;

	public Smstypetb getSmstypetb() {
		return smstypetb;
	}

	public void setSmstypetb(Smstypetb smstypetb) {
		this.smstypetb = smstypetb;
	}
}
