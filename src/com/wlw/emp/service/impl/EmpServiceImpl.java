package com.wlw.emp.service.impl;

import com.wlw.emp.dao.EmpDao;
import com.wlw.emp.dao.impl.EmpDaoImpl;
import com.wlw.emp.entity.Emp;
import com.wlw.emp.service.EmpService;
import com.wlw.emp.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    @Override
    public List<Emp> showAllEmp() {
        List<Emp> results = new ArrayList<>();

        try {
            DbUtils.begin(); //开启事务
            List<Emp> emps = empDao.selectAll();
            if(emps!=null){
                results = emps;
            }
            DbUtils.commit();//提交事务
        } catch (Exception e) {
            DbUtils.rollback();//回滚事务
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int removeEmp(int id) {
        int result = 0;
        try {
            DbUtils.begin();
            result = empDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modify(Emp emp) {
        int result = 0;
        try {
            DbUtils.begin();
            result = empDao.update(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Emp showEmp(int id) {
        Emp emp = null;

        try {
            DbUtils.begin();
            emp = empDao.select(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emp;
    }

    public int addEmp(Emp emp){
        int result = 0;
        try{
            DbUtils.begin();
            result = empDao.insert(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
