package testsqlitejavaapplication1;

import java.sql.SQLException;
import java.util.ArrayList;
import testsqlitejavaapplication1.entity.ClientEntity;
import testsqlitejavaapplication1.ormservice.ClientService;

/**
 * Класс с точкой входа приложения TestSQLiteJavaApplication1
 * @author Yurii
 */
public class TestSQLiteJavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Создаем экземпляр класса сервиса для таблицы "Clients"
        ClientService clientService = new ClientService();
        // Создаем коллекцию для объектов ClientEntity,
        //заполняем ее: вызываем у сервиса таблицы "Clients" метод "взять все" 
        ArrayList<ClientEntity> clientsArrayList =
                (ArrayList) clientService.getAll();
        // В цикле перебираем коллекцию сущностей и выводим в консоль
        //содержимое поля "Imya" из каждой текущей сущности
        for (ClientEntity clientEntity : clientsArrayList) {
            System.out.println(clientEntity.getImya());
        }
    }
    
}
