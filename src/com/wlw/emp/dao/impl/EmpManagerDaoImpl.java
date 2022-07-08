package com.wlw.emp.dao.impl;

import com.wlw.emp.dao.EmpManagerDao;
import com.wlw.emp.entity.EmpManager;
import com.wlw.emp.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EmpManagerDaoImpl implements EmpManagerDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public EmpManager select(String username) {
        try {
            EmpManager empManager = queryRunner.query(DbUtils.getConnection(),
                    "select * from empmanager where username=?;",
                    new BeanHandler<EmpManager>(EmpManager.class), username);
            return empManager;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
