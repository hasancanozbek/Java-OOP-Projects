package DataAccess.concretes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    /*
    DbHelper veritabanında bağlanmamız için gereken işlemleri yaptığımız class.
    Her bağlantıda aşağıdaki kodları tekrar yazmamak için bir class oluşturdum ve gerekli yerlerde newleyip kullandım.
     */

    String dbUserName = "postgres";
    String dbPassword = "123456";
    String dbUrl = "jdbc:postgresql://localhost:5432/bank";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
    }

    public void showErrorMessage(SQLException exception){
        System.out.println("Veritabanına bağlanırken bir sorun oluştu...");
        System.out.println("Hata Mesajı : " + exception.getMessage());
        System.out.println("Hata Kodu : " + exception.getErrorCode());
    }

}
