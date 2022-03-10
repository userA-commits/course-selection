package com.graduation.demo.mapper;

import com.graduation.demo.entity.Rt;
import com.graduation.demo.entity.RtExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RtMapper {
    long countByExample(RtExample example);

    int deleteByExample(RtExample example);

    int insert(Rt record);

    int insertSelective(Rt record);

    List<Rt> selectByExample(RtExample example);

    int updateByExampleSelective(@Param("record") Rt record, @Param("example") RtExample example);

    int updateByExample(@Param("record") Rt record, @Param("example") RtExample example);
}