package com.ems;

import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {
    Connection con;

    @Override
    public void createEmployee(Employee emp) {
        con = DBConnection.createConnection();
        String query = "INSERT INTO employee(id, name, email, salary) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, emp.getId());
            pstm.setString(2, emp.getName());
            pstm.setString(3, emp.getEmail());
            pstm.setDouble(4, emp.getSalary());
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Inserted Successfully !!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createConnection();
        String query = "SELECT * FROM employee";
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Email", "Salary");
        System.out.println("---------------------------------------------");
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%s\t%f\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDouble(4));
            }
            System.out.println("---------------------------------------------");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createConnection();
        String query = "SELECT * FROM employee WHERE id = " + id;
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                 System.out.format("%d\t%s\t%s\t%f\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDouble(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createConnection();
        String query = "UPDATE employee SET name = ? WHERE id = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Details Updated Successfully !!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createConnection();
        String query = "DELETE FROM employee WHERE id = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Deleted Successfully !!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}