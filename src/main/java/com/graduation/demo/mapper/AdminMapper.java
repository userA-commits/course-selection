package com.graduation.demo.mapper;

import com.graduation.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<Admin> findAll();
}
