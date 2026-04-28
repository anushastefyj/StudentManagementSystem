package com.student.dao;

import java.sql.*;
import com.student.bean.StudentBean;

public class StudentDao {

    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "AInDS@3001"
            );
        } catch(Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(StudentBean s) {
        int status = 0;
        try {
            Connection con = getCon();

            PreparedStatement ps = con.prepareStatement(
            		"insert into student(rollno,name,department,email,feedback,rating)values(?,?,?,?,?,?)");
            ps.setString(1, s.getRollno());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDepartment());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getFeedback());
            ps.setInt(6, s.getRating());

            status = ps.executeUpdate();

            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }
}