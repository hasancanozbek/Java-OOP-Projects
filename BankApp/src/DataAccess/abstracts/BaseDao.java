package DataAccess.abstracts;

import Entities.concretes.IndividualAccount;

import java.sql.SQLException;

public interface BaseDao {
    /*
    BaseDao interface'imiz postgresql, mysql, oracle, mongodb vb. veritabanlarının adresini tutabildiği için
    katmanlar arası haberleşmede (dataAccess <-> business) kullandık. Bu sayede yeni bir database ile çalışacağımız zaman
    tek yapmamız gereken şey çalışacağımız db'yi iş katmanında belirtmek.
     */

    void addToDb(IndividualAccount individualAccount) throws SQLException;

    void deleteFromDb(IndividualAccount individualAccount) throws SQLException;

    void updateDb(IndividualAccount individualAccount) throws SQLException;

    void deposit(IndividualAccount individualAccount, int amount) throws SQLException;

    void withdraw(IndividualAccount individualAccount, int amount) throws SQLException;

    void transfer(IndividualAccount individualAccount, int amount, String iban) throws SQLException;

}
