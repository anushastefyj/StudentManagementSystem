package com.student.main;

import java.util.Scanner;
import com.student.bean.StudentBean;
import com.student.dao.StudentDao;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentBean s = new StudentBean();

        System.out.println("Enter Roll No:");
        s.setRollno(sc.nextLine());

        System.out.println("Enter Name:");
        s.setName(sc.nextLine());

        System.out.println("Enter Department:");
        s.setDepartment(sc.nextLine());
        System.out.println("Enter Email:");
        s.setEmail(sc.nextLine());
        System.out.println("Enter Feedback:");
        s.setFeedback(sc.nextLine());

        System.out.println("Enter Rating:");
        s.setRating(sc.nextInt());

        int status = StudentDao.save(s);

        if(status > 0)
            System.out.println("Student saved successfully");
        else
            System.out.println("Failed to save");

        sc.close();
    }
}