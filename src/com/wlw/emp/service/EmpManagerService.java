package com.wlw.emp.service;

import com.wlw.emp.entity.EmpManager;

public interface EmpManagerService {
    public EmpManager login(String username, String password);
}
