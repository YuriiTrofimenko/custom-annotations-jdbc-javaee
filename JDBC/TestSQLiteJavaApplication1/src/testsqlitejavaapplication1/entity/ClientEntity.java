package testsqlitejavaapplication1.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Класс-сущность для таблицы "Clients"
 * @author Yurii
 */
// Маркируем весь класс как сущность таблицы, которой соответствует
//реальная таблица "Clients" в РБД
@DatabaseTable(tableName = "Clients")
public class ClientEntity {
    // Маркируем каждое поле класса-сущности как сущность-столбец,
    //которому соответствует реальный столбец с указанным в скобках именем,
    //типом, и другими свойствами в РБД
    @DatabaseField(columnName = "id"
            ,dataType = DataType.INTEGER
            ,canBeNull = false
            ,generatedId = true)
    private int mId;
    @DatabaseField(columnName = "record_count"
            ,dataType = DataType.INTEGER
            ,canBeNull = false)
    private int mRecordCount;
    @DatabaseField(columnName = "Familiya"
            ,dataType = DataType.STRING
            ,canBeNull = false)
    private String mFamiliya;
    @DatabaseField(columnName = "Imya"
            ,dataType = DataType.STRING
            ,canBeNull = false)
    private String mImya;
    @DatabaseField(columnName = "Otchestvo"
            ,dataType = DataType.STRING
            ,canBeNull = true)
    private String mOtchestvo;
    @DatabaseField(columnName = "Adress"
            ,dataType = DataType.STRING
            ,canBeNull = false)
    private String mAdress;
    @DatabaseField(columnName = "Phone"
            ,dataType = DataType.INTEGER
            ,canBeNull = false)
    private int mPhone;
    @DatabaseField(columnName = "Email"
            ,dataType = DataType.STRING
            ,canBeNull = true)
    private String mEmail;
    
    // Для каждого поля класса создаем геттеры и сеттеры
    public int getId() {
        return mId;
    }

    public void setId(int _id) {
        mId = _id;
    }

    public int getRecordCount() {
        return mRecordCount;
    }

    public void setRecordCount(int _recordCount) {
        mRecordCount = _recordCount;
    }

    public String getFamiliya() {
        return mFamiliya;
    }

    public void setFamiliya(String _familiya) {
        mFamiliya = _familiya;
    }

    public String getImya() {
        return mImya;
    }

    public void setImya(String _imya) {
        mImya = _imya;
    }

    public String getOtchestvo() {
        return mOtchestvo;
    }

    public void setOtchestvo(String _otchestvo) {
        mOtchestvo = _otchestvo;
    }

    public String getAdress() {
        return mAdress;
    }

    public void setAdress(String _adress) {
        mAdress = _adress;
    }

    public int getPhone() {
        return mPhone;
    }

    public void setPhone(int _phone) {
        mPhone = _phone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String _email) {
        mEmail = _email;
    }

    // Переопределяем метод "toString()" для возможности грубого вывода
    //содержимого экземпляра, например, в консоль
    @Override
    public String toString() {
        return "Client{" +
                "id=" + mId +
                ", recordCount=" + mRecordCount +
                ", familiya='" + mFamiliya + '\'' +
                ", imya='" + mImya + '\'' +
                ", otchestvo=" + mOtchestvo +
                ", adress=" + mAdress +
                ", phone=" + mPhone +
                ", email=" + mEmail +
                '}';
    }
    
    
}
