package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Pkgenerator;
import com.miaoyou.platform.server.entity.PkgeneratorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PkgeneratorMapper {
    int countByExample(PkgeneratorExample example);

    int deleteByExample(PkgeneratorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pkgenerator record);

    int insertSelective(Pkgenerator record);

    List<Pkgenerator> selectByExample(PkgeneratorExample example);

    Pkgenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pkgenerator record, @Param("example") PkgeneratorExample example);

    int updateByExample(@Param("record") Pkgenerator record, @Param("example") PkgeneratorExample example);

    int updateByPrimaryKeySelective(Pkgenerator record);

    int updateByPrimaryKey(Pkgenerator record);
}