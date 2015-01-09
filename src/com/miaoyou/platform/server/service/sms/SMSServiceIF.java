package com.miaoyou.platform.server.service.sms;

import com.miaoyou.platform.server.entity.Rsdnssmsaddtb;
import com.miaoyou.platform.server.entity.child.SMSAll;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.CommServiceIF;
import com.miaoyou.platform.server.utils.Pager;

public interface SMSServiceIF extends CommServiceIF<SMSAll, Long> {

	public CommFindEntity<SMSAll> findAll(String smsType);
	
	public  CommFindEntity<Rsdnssmsaddtb> findAllByDpDns(Pager page,Integer dpId,Long dnsId);
	
	public int saveSmsForDpDns(Rsdnssmsaddtb rsdnssmsaddtb);
	
	public int deleteSmsForDpDns(Rsdnssmsaddtb rsdnssmsaddtb);
	
}
