package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.sql.*;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb", "clinicUser", "clinic123");
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from TBL_USER;");
            rs.next();
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}