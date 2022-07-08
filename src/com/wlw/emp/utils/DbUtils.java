package com.wlw.emp.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
    private static DruidDataSource dataSource;
    //线程，控制事务，确保一个事务是同一个连接
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    static{
        Properties properties = new Properties();
        InputStream is = DbUtils.class.getResourceAsStream("/database.properties");
        try {
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        if(connection == null) {
            try {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public static void begin() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void commit() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(connection, null, null);
        }
    }

    public static void rollback() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(connection, null, null);
        }
    }

    private static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
                threadLocal.remove();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
