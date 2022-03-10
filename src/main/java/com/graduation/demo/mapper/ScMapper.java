package com.graduation.demo.mapper;

import com.graduation.demo.entity.Sc;
import com.graduation.demo.entity.ScExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScMapper {
    long countByExample(ScExample example);

    int deleteByExample(ScExample example);

    int insert(Sc record);

    int insertSelective(Sc record);

    List<Sc> selectByExample(ScExample example);

    int updateByExampleSelective(@Param("record") Sc record, @Param("example") ScExample example);

    int updateByExample(@Param("record") Sc record, @Param("example") ScExample example);
}