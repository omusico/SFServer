package com.miaoyou.platform.server.service.patient;

import java.util.Date;

import com.miaoyou.platform.server.entity.child.OutPatienttbRecordCase;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.CommServiceIF;
import com.miaoyou.platform.server.utils.Pager;

public interface OutPatientRecordCaseServiceIF extends CommServiceIF<OutPatienttbRecordCase,Long>{

	public CommFindEntity<OutPatienttbRecordCase> findAll(Pager page,int type,Long patientid,String zhuyuanhao, String keshi, Date chuyuanriqi,String zujima);
}
