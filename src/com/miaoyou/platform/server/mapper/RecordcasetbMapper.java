package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Recordcasetb;
import com.miaoyou.platform.server.entity.RecordcasetbExample;
import com.miaoyou.platform.server.entity.RecordcasetbWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordcasetbMapper {
    int countByExample(RecordcasetbExample example);

    int deleteByExample(RecordcasetbExample example);

    int deleteByPrimaryKey(Long recordcaseid);

    int insert(RecordcasetbWithBLOBs record);

    int insertSelective(RecordcasetbWithBLOBs record);

    List<RecordcasetbWithBLOBs> selectByExampleWithBLOBs(RecordcasetbExample example);

    List<Recordcasetb> selectByExample(RecordcasetbExample example);

    RecordcasetbWithBLOBs selectByPrimaryKey(Long recordcaseid);

    int updateByExampleSelective(@Param("record") RecordcasetbWithBLOBs record, @Param("example") RecordcasetbExample example);

    int updateByExampleWithBLOBs(@Param("record") RecordcasetbWithBLOBs record, @Param("example") RecordcasetbExample example);

    int updateByExample(@Param("record") Recordcasetb record, @Param("example") RecordcasetbExample example);

    int updateByPrimaryKeySelective(RecordcasetbWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordcasetbWithBLOBs record);

    int updateByPrimaryKey(Recordcasetb record);
}