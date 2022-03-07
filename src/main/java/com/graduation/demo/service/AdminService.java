package com.graduation.demo.service;

import com.graduation.demo.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<Admin> findAll();
}
