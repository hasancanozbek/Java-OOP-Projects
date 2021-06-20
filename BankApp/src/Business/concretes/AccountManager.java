package Business.concretes;

import Business.abstracts.BaseAccountService;
import Core.Adapters.CustomerCheckService;
import Core.Adapters.MernisV1Adapter;
import DataAccess.abstracts.BaseDao;
import Entities.concretes.IndividualAccount;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountManager implements BaseAccountService {

    //**Dependency injection yapıldı.**
    private BaseDao baseDao;
    public AccountManager(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    //Kimlik doğrulama servisimizin nesnesini oluşturduk. MernisV1 versiyonu ile çalışacağımızı belirttik.
    CustomerCheckService customerCheckService = new MernisV1Adapter();


    //CRUD operasyonları yazıldı.
    @Override
    public void addAccount(IndividualAccount individualAccount) throws Exception {
        //Kullanıcının gerçek kişi olup olmadığı mernis doğrulaması üzerinden kontrol edildi.
        if (customerCheckService.isRealPerson(individualAccount)){
            baseDao.addToDb(individualAccount);
            individualAccount.setAccountId(individualAccount.getCustomerTC());
        }
        else{
            System.out.println("Hesap sistem tarafından doğrulanamadı.");
        }
    }

    @Override
    public void updateAccount(IndividualAccount individualAccount,String nameUpdate, String surnameUpdate) throws SQLException {
        individualAccount.setCustomerFirstName(nameUpdate);
        individualAccount.setCustomerLastName(surnameUpdate);
        baseDao.updateDb(individualAccount);
    }

    @Override
    public void deleteAccount(IndividualAccount individualAccount) throws SQLException {
        System.out.println("Tc kimlik numaranızı giriniz : ");
        Scanner scanner = new Scanner(System.in);
        String control = scanner.nextLine();
        if (control.equals(individualAccount.getCustomerTC())){
            baseDao.deleteFromDb(individualAccount);
        }
    }
}
