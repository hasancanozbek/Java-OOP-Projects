import Business.abstracts.BankService;
import Business.abstracts.BaseAccountService;
import Business.concretes.AccountManager;
import Business.concretes.BankManager;
import DataAccess.concretes.PostgreSqlDao;
import Entities.concretes.IndividualAccount;


public class Main {

    public static void main(String[] args) throws Exception {

        //Bir hesap nesnesi oluşturuldu.
        IndividualAccount account1 = new IndividualAccount();
        account1.setCustomerFirstName("Hasan Can");
        account1.setCustomerLastName("Özbek");
        account1.setCustomerTC("11111111111"); //Gerçek bir tc kimlik numarası girin
        account1.setCustomerBirthOfYear(2001);
        account1.setAccountId("11111111111");
        account1.setBalance(1000);

        IndividualAccount account2 = new IndividualAccount("01010101010","İbrahim","Özbek","11111111111",1968,5000);
        /*
        Servislerimizi test etmek için base interface'imizi kullandık. Hesap yönetiminin varsayılan database'inin
        postgre olduğunu belirttik. Bu kısım ileride değiştirilebilir (Örn : MySql,Oracle). Ancak bizim kodda tek
        değiştireceğimiz kısım burada konfigrasyon kısmında "new yeniVeritabanı" olacak. Böylece programımıza kolayca
        yeni veritabanı yönetim sistemi ekleyebileceğiz.
         */
        BaseAccountService baseAccountService = new AccountManager(new PostgreSqlDao());

        //Mernis doğrulaması ile yeni hesap açılması kontrol edildi.
        baseAccountService.addAccount(account1);
        baseAccountService.addAccount(account2);

        //Veritabanında var olan bir hesabın kullanıcısının ismini ve soyadını değiştirebilmesi kontorl edildi.
        baseAccountService.updateAccount(account1,"Ebubekir","Sıddık");

        //Veritabanında kayıtlı olan bir hesabın kalıcı olarak silinmesi kontrol edildi.
        baseAccountService.deleteAccount(account1);

        BankService bankService = new BankManager(new PostgreSqlDao());

        //Hesaba para yatırma fonksiyonu test edildi.
        bankService.deposit(account1,1000);

        //Hesaptan para çekme fonksiyonu test edildi.
        bankService.withdraw(account1,1000);

        //Bir hesaptan başka hesaba para gönderme fonksiyonu test edildi.
        bankService.eft(account1,200,"xxxxxxxxxxx");

        //Listeleme operasyonu test edildi.
        baseAccountService.getAllAccounts();
    }
}