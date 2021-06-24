import Business.abstracts.CustomerService;
import Business.concretes.CustomerManager;
import Core.Adapters.GoogleVerificationAdapter;
import DataAccess.concretes.HibernateCustomerDao;
import Entities.concretes.Customer;

public class Main {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Hasan Can","Özbek","hasancanozbekk@gmail.com","123456");
        Customer customer2 = new Customer("Hasan Can","Özbek","hasancanozbekk@gmail.com","123456");

        CustomerService customerService = new CustomerManager(new HibernateCustomerDao(),new GoogleVerificationAdapter());

        customerService.registerWithThirdParty();

        customerService.register(customer1);
        customerService.register(customer2);

        customerService.Login(customer1,"hasancanozbekk@gmail.com","123456");



    }
}
