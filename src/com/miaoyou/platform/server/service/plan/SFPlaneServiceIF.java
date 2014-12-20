package com.miaoyou.platform.server.service.plan;

import com.miaoyou.platform.server.entity.Sfplantb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.CommServiceIF;

public interface SFPlaneServiceIF extends CommServiceIF<Sfplantb,Long>{
	public CommFindEntity<Surveytb> findSurveyByDns(Long planId);
}
