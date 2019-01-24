package com.hjljy.blog;

import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.mapper.blog.BlogMapper;
import com.hjljy.blog.service.blog.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.sql.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    BlogService service;

    @Autowired
    BlogMapper mapper;

    @Test
    public void contextLoads() {
        Example example = new Example(Blog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orLike("tags", "%spring%");
        example.and(criteria);
        List<Blog> blogs = mapper.selectByExample(example);
        System.out.println(1);
    }


    @Test
    public void JDBCtest() {

        String ClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1/test";
        String username = "root";
        String password = "root";

        //第一步：加载驱动
        try {//加载MySql的驱动类 将驱动注册到DriverManager当中
            Class.forName(ClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败！请检查驱动名称");
            e.printStackTrace();
        }

        Connection con = null;
        Statement statement = null;
        String sql = null;
        ResultSet resultSet = null;
        try {
            //第二步：获取连接
            con = DriverManager.getConnection(url, username, password);
            //第三步：创建sql
            sql = "SELECT T1 FROM test1 ";
            //第四步：获取statement类
            statement = con.createStatement();
            //第五步：获取到执行后的结果集resultSet
             resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                //通过结果集的操作方法进行数据的获取   这里可以进行实际的业务操作，例如存到一个对应的实体类，返回给前端
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败！请检查数据库连接信息");
            e.printStackTrace();
        }finally {
            //先关闭结果集
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //然后关闭Statement对象
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //最后关闭连接
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
