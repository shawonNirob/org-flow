package com.db.employee.controller;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestConnection {
    public static void main(String[] args) {
        try {
            String url = "jdbc:sqlserver://vNTDACLSSQLD001:1433;databaseName=DEV_TEST;encrypt=true;trustServerCertificate=true;";
            String user = "dev_test_dbo";
            String password = "dev_test_dbo123";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successful!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
