package com.mehdi5.mehdi5.service;


import com.mehdi5.mehdi5.dto.AdminDto;
import com.mehdi5.mehdi5.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);
}
