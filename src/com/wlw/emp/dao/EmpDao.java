package com.wlw.emp.dao;

import com.wlw.emp.entity.Emp;

import java.util.List;

public interface EmpDao {
    public int insert(Emp emp);
    public int update(Emp emp);
    public int delete(int id);
    public Emp select(int id);
    public List<Emp> selectAll();
}
