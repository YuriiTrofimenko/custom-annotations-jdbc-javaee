/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.sqlitejavasimple;
import java.sql.*;

/**
 *
 * @author Yurii
 */
public class SQLiteJavaSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //Соединение
        Connection connection = null;
        //Ответ из РБД
        ResultSet resultSet = null;
        //Запрос
        Statement statement = null;
               
        /*try
        {*/
            //Подключаем драйвер нужного типа
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            connection = DriverManager.getConnection("jdbc:sqlserver://WIN-MPSA8PU541E\\SQLEXPRESS1;"
                    + "databaseName=TestDb;integratedSecurity=false;user=sa;password=1");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Test_table_1");
           
            while(resultSet.next())
            {
                 //System.out.print(resultSet.getString(1) + "\t");
                 System.out.print(resultSet.getString("first_name") + "\t");
                 System.out.println();
            }
        /*} catch (Exception e)
        {
            System.out.println("Ошибка обращения к БД");
        }
        //В любом случае нужно освободить ресурсы       
        finally
        { 
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(Exception e)
            {
                
            }
        }*/
    }
}
    

