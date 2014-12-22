package com.miaoyou.platform.server.service.diagnosis;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.utils.Pager;

public interface KeshiDiagnosisServiceIF {
	
	public CommFindEntity<Diagnosistb> findDns(Pager pager,Integer departmentId);
	
	public CommFindEntity<Departmenttb> findDep(Pager pager,Long diagnosisId);
	
	public int saveKeshiDns(Integer departmentId,Long diagnosisId);
	
	public int deleteKeshiDns(Integer departmentId,Long diagnosisId);
	
	public int deleteKeshiByDns(Long diagnosisId);
}
