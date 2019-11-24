/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.demopostgresql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Demo project: jdbc posgresql
 * @author Yurii
 */
public class DemoPostgreSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Внимание! Имена таблиц и полей БД не должны содержать символов верхнего регистра!*/
        Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        //Имя пользователя БД
        String name = "postgres";
        //Пароль
        String password = "";
        try {
            //Загружаем драйвер
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            //Создаём соединение
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");
            //Для использования SQL запросов существуют 3 типа объектов:
            //1.Statement: используется для простых случаев без параметров
            Statement statement = null;

            statement = connection.createStatement();
            //Выполним запрос
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM test_table WHERE id > 0 AND id < 2");
            //result это указатель на первую строку с выборки
            //чтобы вывести данные мы будем использовать 
            //метод next() , с помощью которого переходим к следующему элементу
            System.out.println("Выводим statement");
            while (result1.next()) {
                System.out.println("Номер в выборке: " + result1.getRow()
                        + "\t Номер в таблице: " + result1.getInt("id")
                        + "\t Имя: " + result1.getString("name"));
            }
            // Вставить запись
            /*statement.executeUpdate(
                    "INSERT INTO test_table(id, name) values('3', 'Вася 2')");
            //Обновить запись
            statement.executeUpdate(
                    "UPDATE test_table SET name = 'Vasia 1' where id = 1");*/
            
            //2.PreparedStatement: предварительно компилирует запросы, 
            //которые могут содержать входные параметры
            PreparedStatement preparedStatement = null;
            // ? - место вставки нашего значеня
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM test_table where id > ? and id < ?");
            //Устанавливаем в нужную позицию значения определённого типа
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 10);
            //выполняем запрос
            ResultSet result2 = preparedStatement.executeQuery();
            
            System.out.println("Выводим PreparedStatement");
            while (result2.next()) {
                System.out.println("Номер в выборке: " + result2.getRow()
                        + "\t Номер в таблице: " + result2.getInt("id")
                        + "\t Имя: " + result2.getString("name"));
            }
            
            /*preparedStatement = connection.prepareStatement(
                    "INSERT INTO test_table(id, name) values(?, ?)");
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Вася 4");
            //метод принимает значение без параметров
            //темже способом можно сделать и UPDATE
            preparedStatement.executeUpdate();*/
            
            //3.CallableStatement: используется для вызова хранимых функций,
            // которые могут содержать входные и выходные параметры
            CallableStatement callableStatement = null;
            //Вызываем функцию myFunc, она хранится в БД, тело скрипта ее создания:
            //SELECT id FROM test_table WHERE name = $1 OR name = $2;
            callableStatement = connection.prepareCall(
                    " { call myfunc(?,?) } ");
            //Задаём входные параметры
            callableStatement.setString(1, "Вася 2");
            callableStatement.setString(2, "Vasia 1");
            //Выполняем запрос
            ResultSet result3 = callableStatement.executeQuery();
            //Если CallableStatement возвращает несколько объектов ResultSet,
            //то нужно выводить данные в цикле с помощью метода next
            //у меня функция возвращает один объект
            while(result3.next()){
                System.out.println(result3.getInt(1));
            }
            //если функция вставляет или обновляет, то используется метод executeUpdate()

        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(DemoPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DemoPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
