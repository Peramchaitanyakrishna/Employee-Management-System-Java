package com.ems;

public interface EmployeeDaoIntrf {
    // Employee create cheyadam
    public void createEmployee(Employee emp);
    // Andari details chupinchadam
    public void showAllEmployee();
    // ID batti employee ni chupinchadam
    public void showEmployeeBasedOnID(int id);
    // Employee ni update cheyadam
    public void updateEmployee(int id, String name);
    // Employee ni delete cheyadam
    public void deleteEmployee(int id);
}