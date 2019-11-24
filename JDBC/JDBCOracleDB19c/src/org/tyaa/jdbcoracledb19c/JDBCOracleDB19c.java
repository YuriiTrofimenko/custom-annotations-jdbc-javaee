/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.jdbcoracledb19c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yurii
 */
public class JDBCOracleDB19c {

    static String url = "jdbc:oracle:thin:@//192.168.0.107:1521/xe";
    static String user = "testuser";
    static String password = "1";
    
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static PreparedStatement getSalaryStatement = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM Emp");
           
        while(resultSet.next())
        {
             System.out.print(resultSet.getString(2) + "\t" + resultSet.getString(3));
             System.out.println();
        }
        // PreparedStatement to return the salary from an employee using the
        // employee number (with Path Notation Query over the document).
        /* getSalaryStatement = connection.prepareStatement(
            "SELECT JSON_VALUE(employee_document, '$.salary') "
            + "FROM JSON_EMP_JDBC_SAMPLE where JSON_VALUE "
            + "(employee_document, '$.employee_number') = ?"); */
    }
    
}
