package Business.abstracts;

import Entities.concretes.IndividualAccount;

import java.sql.SQLException;

public interface BankService {
    //Banka hizmetleri servisi için kullandığım interface.

    void deposit(IndividualAccount individualAccount, int amount) throws SQLException;

    void withdraw(IndividualAccount individualAccount, int amount) throws SQLException;

    void eft(IndividualAccount individualAccount, int amount,String iban) throws SQLException;
}
