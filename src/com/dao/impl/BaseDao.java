package com.dao.impl;

import com.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xjm
 * @create 2020-04-16 18:50
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 批量执行sql语句
     * @param params
     * @param sql
     * @return
     */
    public int batch(Object[][] params,String sql){
        Connection connection = JDBCUtils.getConnection();
        try {
//            Object[][] params params[0] 表示一维数组
//            第一维表示sql执行次数，第二维表示当前sql中的可变参数
//            "insert into t_order_item(`name`,`price`,`total_money`,`count`,`order_id`) values(?,?,?,?,?)"
            queryRunner.batch(connection,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     * update()方法用来执行：Insert\Update\Delete语句
     * @return 如果返回-1说明执行失败,返回其他表示影响的行数
     */
    public int update(String sql,Object ... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个JavaBean的SQL语句
     * @param type 返回对象类型
     * @param sql   执行的SQL语句
     * @param args  SQL对应的参数值
     * @param <T>   返回的类型的泛型
     * @return
     */
    public<T> T queryForOne(Class<T> type,String sql,Object ... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 查询返回多个JavaBean的SQL语句
     * @param type 返回对象类型
     * @param sql   执行的SQL语句
     * @param args  SQL对应的参数值
     * @param <T>   返回的类型的泛型
     * @return
     */
    public <T>List<T> queryForList(Class<T> type,String sql,Object ... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的SQL语句
     * @param args SQL对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object ... args){
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
