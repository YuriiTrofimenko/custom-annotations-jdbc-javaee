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
    public static void main(String[] args)
    {
        //Соединение
        Connection connection = null;
        //Ответ из РБД
        ResultSet resultSet = null;
        //Запрос
        Statement statement = null;
               
        try
        {
            //Подключаем драйвер нужного типа
            Class.forName("org.sqlite.JDBC");  
            connection = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients");
           
            while(resultSet.next())
            {
                 //System.out.print(resultSet.getString(1) + "\t");
                 System.out.print(resultSet.getString("Adress") + "\t");
                 System.out.println();
            }
        } catch (Exception e)
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
        }
    }
}
    

