package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Rspatientdpdns;
import com.miaoyou.platform.server.entity.RspatientdpdnsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RspatientdpdnsMapper {
    int countByExample(RspatientdpdnsExample example);

    int deleteByExample(RspatientdpdnsExample example);

    int insert(Rspatientdpdns record);

    int insertSelective(Rspatientdpdns record);

    List<Rspatientdpdns> selectByExample(RspatientdpdnsExample example);

    int updateByExampleSelective(@Param("record") Rspatientdpdns record, @Param("example") RspatientdpdnsExample example);

    int updateByExample(@Param("record") Rspatientdpdns record, @Param("example") RspatientdpdnsExample example);
}