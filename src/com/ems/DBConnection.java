package com.ems;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // Mee Database details ikkada ivvandi
    static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String USER = "root"; // Mee MySQL username (default: root)
    static final String PASS = "2430"; // Mee MySQL password

    public static Connection createConnection() {
        Connection con = null;
        try {
            // Driver Load cheyadam
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection establish cheyadam
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}