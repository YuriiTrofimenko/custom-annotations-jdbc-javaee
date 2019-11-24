/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlitejavaapplication1.ormservice;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;
import testsqlitejavaapplication1.entity.ClientEntity;

/**
 * Класс сервиса для сущности таблицы "Clients"
 * @author Yurii
 */
public class ClientService {
    // Поле с текстом ссылки на файл РБД "sqlite.db"
    private final String mSqliteUrlString = "jdbc:sqlite:sqlite.db";
    // Поле для объекта "Ресурс соединения"
    private ConnectionSource mConnectionSource;
    // Поле для объекта Dao, обслуживающего сущность "ClientEntity"
    private Dao<ClientEntity, String> mDao;
    // Конструктор класса, в котором инициализируется объект подключения
    //и на его основе - объект Dao
    public ClientService() throws SQLException, ClassNotFoundException {
        mConnectionSource = new JdbcConnectionSource(mSqliteUrlString);
        mDao = DaoManager.createDao(mConnectionSource, ClientEntity.class);
    }
    // Демо-метод: обертка для получения всех данных из таблицы "Clients"
    public List<ClientEntity> getAll() throws SQLException {
        return mDao.queryForAll();
    }
}
