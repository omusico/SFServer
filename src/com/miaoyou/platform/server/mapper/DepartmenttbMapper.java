package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Departmenttb;
import com.miaoyou.platform.server.entity.DepartmenttbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmenttbMapper {
    int countByExample(DepartmenttbExample example);

    int deleteByExample(DepartmenttbExample example);

    int deleteByPrimaryKey(Integer departmentId);

    int insert(Departmenttb record);

    int insertSelective(Departmenttb record);

    List<Departmenttb> selectByExample(DepartmenttbExample example);

    Departmenttb selectByPrimaryKey(Integer departmentId);

    int updateByExampleSelective(@Param("record") Departmenttb record, @Param("example") DepartmenttbExample example);

    int updateByExample(@Param("record") Departmenttb record, @Param("example") DepartmenttbExample example);

    int updateByPrimaryKeySelective(Departmenttb record);

    int updateByPrimaryKey(Departmenttb record);
}