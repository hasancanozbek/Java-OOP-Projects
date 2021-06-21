package DataAccess.concretes;

import DataAccess.abstracts.BaseDao;
import Entities.concretes.IndividualAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostgreSqlDao implements BaseDao {

    DbHelper dbHelper = new DbHelper();
    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public void addToDb(IndividualAccount individualAccount) throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "insert into individual_accounts (account_id,customer_firstname,customer_lastname,customer_tc,customer_birth_of_year,balance) values (?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,individualAccount.getAccountId());
            statement.setString(2,individualAccount.getCustomerFirstName());
            statement.setString(3,individualAccount.getCustomerLastName());
            statement.setString(4,individualAccount.getCustomerTC());
            statement.setInt(5,individualAccount.getCustomerBirthOfYear());
            statement.setInt(6,individualAccount.getBalance());

            statement.executeUpdate();
            System.out.println("Hesap başarıyla veritabanına eklendi : "+individualAccount.getAccountId());
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    @Override
    public void deleteFromDb(IndividualAccount individualAccount) throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "delete from individual_accounts where account_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,individualAccount.getAccountId());
            statement.executeUpdate();

            System.out.println("Hesap veritabanından başarıyla silindi : " + individualAccount.getAccountId());
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }

    }

    @Override
    public void updateDb(IndividualAccount individualAccount) throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "update individual_accounts set customer_firstname = ?,customer_lastname = ? where customer_tc = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(3,individualAccount.getCustomerTC());
            statement.setString(1,individualAccount.getCustomerFirstName());
            statement.setString(2,individualAccount.getCustomerLastName());
            statement.executeUpdate();

            System.out.println("Kullanıcı bilgileri başarıyla güncellendi : " + individualAccount.getCustomerFirstName()+" "+individualAccount.getCustomerLastName());
        }
        catch (SQLException exception){
            dbHelper.showErrorMessage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public void deposit(IndividualAccount individualAccount, int amount) throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "Update individual_accounts set balance = balance+? where customer_tc = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(2,individualAccount.getCustomerTC());
            statement.setInt(1,amount);
            statement.executeUpdate();

            System.out.println("Hesabınıza "+amount+"$ tutarında para yatırılmıştır.");
        }
        catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }

    }

    @Override
    public void withdraw(IndividualAccount individualAccount, int amount) throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "Update individual_accounts set balance = balance-? where customer_tc = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(2,individualAccount.getCustomerTC());
            statement.setInt(1,amount);
            statement.executeUpdate();
            System.out.println("Hesabınızdan "+amount+"$ tutarında para çekilmiştir.");
        }
        catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public void transfer(IndividualAccount individualAccount, int amount, String iban) throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql1 = "update individual_accounts set balance=balance-? where customer_tc = ?";
            statement = connection.prepareStatement(sql1);
            statement.setInt(1,amount);
            statement.setString(2,individualAccount.getCustomerTC());
            statement.executeUpdate();

            String sql2 = "update individual_accounts set balance=balance+? where customer_tc = ?";
            statement = connection.prepareStatement(sql2);
            statement.setInt(1,amount);
            statement.setString(2,iban);
            statement.executeUpdate();

            System.out.println("Hesabınızdan "+iban+" numaralı hesaba "+amount+"$ tutarında para aktarılmıştır.");
        }
        catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public void getAll() throws SQLException {
        ArrayList<IndividualAccount> allAccounts = new ArrayList<>();
        try {
            connection = dbHelper.getConnection();
            String sql = "Select * From individual_accounts";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                allAccounts.add(new IndividualAccount(
                        resultSet.getString("account_id"),
                        resultSet.getString("customer_firstname"),
                        resultSet.getString("customer_lastname"),
                        resultSet.getString("customer_tc"),
                        resultSet.getInt("customer_birth_of_year"),
                        resultSet.getInt("balance")));
            }
        }
        catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }
        for (IndividualAccount account : allAccounts){
            System.out.println("Adı ve Soyadı: "+account.getCustomerFirstName()+" "+account.getCustomerLastName());
            System.out.println("Hesap Numarası : "+account.getAccountId());
            System.out.println("------------------------------------------------------------------------------------");
        }
        System.out.println("Database içindeki toplam hesap sayısı : "+allAccounts.size());
    }
}
