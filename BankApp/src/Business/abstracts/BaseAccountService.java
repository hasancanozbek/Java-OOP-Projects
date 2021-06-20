package Business.abstracts;

import Entities.concretes.IndividualAccount;

import java.sql.SQLException;

public interface BaseAccountService {
    /*
    Her classın bir base interface'i olmalı. Bu bağımlılığı ve kodun genişletilebilirliğini sağlamak için gerekli bir adım.
    Hesap işlemleri için base servisimiz 'BaseAccountService'.
     */

    void addAccount(IndividualAccount individualAccount) throws Exception;
    void updateAccount(IndividualAccount individualAccount,String nameUpdate, String surnameUpdate) throws SQLException;
    void deleteAccount(IndividualAccount individualAccount) throws SQLException;
}
