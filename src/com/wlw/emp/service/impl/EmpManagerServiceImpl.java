package com.wlw.emp.service.impl;

import com.wlw.emp.dao.EmpManagerDao;
import com.wlw.emp.dao.impl.EmpManagerDaoImpl;
import com.wlw.emp.entity.EmpManager;
import com.wlw.emp.service.EmpManagerService;
import com.wlw.emp.utils.DbUtils;

public class EmpManagerServiceImpl implements EmpManagerService {
    private EmpManagerDao empManagerDao = new EmpManagerDaoImpl();

    @Override
    public EmpManager login(String username, String password) {
        EmpManager result = null;
        try {
            DbUtils.begin();
            EmpManager empManager = empManagerDao.select(username);
            if(empManager != null) {
                if(empManager.getPassword().equals(password)) {
                    result = empManager;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
