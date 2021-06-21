package Business.concretes;

import Business.abstracts.BankService;
import DataAccess.abstracts.BaseDao;
import DataAccess.concretes.DbHelper;
import Entities.concretes.IndividualAccount;

import java.sql.*;

public class BankManager implements BankService {


    /*
    Banka hizmetlerini yapan class.
        deposit : belirtilen tutarda hesaba para yatırır.
        withdraw : belirtilen tutarda hesaptan para çeker.
        eft : kullanıcının hesabından bir başka kayıtlı kullanıcının hesabına para gönderir.
        draw : özel hesaplar arasındaki çekilişi düzenler.
     */

    //Constructor injection yapıldı.
    BaseDao baseDao;
    public BankManager(BaseDao baseDao){ this.baseDao = baseDao; }

    DbHelper dbHelper = new DbHelper();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet;

    @Override
    public void deposit(IndividualAccount individualAccount, int amount) throws SQLException {
        baseDao.deposit(individualAccount,amount);
    }

    @Override
    public void withdraw(IndividualAccount individualAccount, int amount) throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "SELECT balance FROM individual_accounts WHERE customer_tc = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,individualAccount.getCustomerTC());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
               int balance = resultSet.getInt("balance");
               if(amount <= balance){
                    baseDao.withdraw(individualAccount,amount);
                }
               else{
                   System.out.println("Hesaptan para çekilemedi.");
               }
            }

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public void eft(IndividualAccount individualAccount, int amount, String iban) throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "SELECT customer_tc FROM individual_accounts WHERE account_id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,iban);
            resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    baseDao.transfer(individualAccount, amount, iban);
                }
                else{
                    System.out.println("Havale yapılamadı.");
                }
        }
        catch (SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

}
