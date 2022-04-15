package gege.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mr.xu
 * @create 2022/03/27/20:14
 * Description:
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    static{
        try {
            Properties properties = new Properties();
            //读取jdbc。properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //获取数据库连接池中的连接
    public static Connection getConnection(){
        Connection conn = conns.get();
        if (conn == null){
            try {
                conn = dataSource.getConnection();//从数据库连接池中获取连接
                conns.set(conn);//保存到threadlocal中
                conn.setAutoCommit(false);//设置为手动提交
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;

    }



    //提交并关闭连接
    public static void commitAndClose(){
        Connection conn = conns.get();
        if (conn != null){
            try {
                conn.commit();//提交事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }


    //回滚并关闭连接
    public static void rollbackAndClose(){
        Connection conn = conns.get();
        if (conn != null){
            try {
                conn.rollback();//回滚事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    conn.close();//关闭连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }

//    //关闭连接
//    public static void close(Connection conn){
//        if(conn != null){
//            try {
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//
//    }
}
