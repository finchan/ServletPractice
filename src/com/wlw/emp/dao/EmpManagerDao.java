package com.wlw.emp.dao;

import com.wlw.emp.entity.EmpManager;

public interface EmpManagerDao {
    public EmpManager select(String username);
}
