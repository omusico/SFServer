package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Recordcaseopdtb;
import com.miaoyou.platform.server.entity.RecordcaseopdtbExample;
import com.miaoyou.platform.server.entity.RecordcaseopdtbWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordcaseopdtbMapper {
    int countByExample(RecordcaseopdtbExample example);

    int deleteByExample(RecordcaseopdtbExample example);

    int deleteByPrimaryKey(Long recordcaseid);

    int insert(RecordcaseopdtbWithBLOBs record);

    int insertSelective(RecordcaseopdtbWithBLOBs record);

    List<RecordcaseopdtbWithBLOBs> selectByExampleWithBLOBs(RecordcaseopdtbExample example);

    List<Recordcaseopdtb> selectByExample(RecordcaseopdtbExample example);

    RecordcaseopdtbWithBLOBs selectByPrimaryKey(Long recordcaseid);

    int updateByExampleSelective(@Param("record") RecordcaseopdtbWithBLOBs record, @Param("example") RecordcaseopdtbExample example);

    int updateByExampleWithBLOBs(@Param("record") RecordcaseopdtbWithBLOBs record, @Param("example") RecordcaseopdtbExample example);

    int updateByExample(@Param("record") Recordcaseopdtb record, @Param("example") RecordcaseopdtbExample example);

    int updateByPrimaryKeySelective(RecordcaseopdtbWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordcaseopdtbWithBLOBs record);

    int updateByPrimaryKey(Recordcaseopdtb record);
}