import Business.abstracts.BaseCustomerManager;
import Business.concretes.MernisCheckService;
import Business.concretes.NeroCustomerManager;
import Business.concretes.StarbucksCustomerManager;
import Entites.concretes.Customer;

public class Main {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Hasan Can","Özbek",2001,"11111111111");

        Customer customer2 = new Customer();
        customer2.setFirstName("Engin");
        customer2.setLastName("Demiroğ");
        customer2.setBirthOfDate(1978);
        customer2.setNationalityId("xxxxxxxxxxx");


        BaseCustomerManager starbucksManager = new StarbucksCustomerManager(new MernisCheckService());
        BaseCustomerManager neroManager = new NeroCustomerManager();

        starbucksManager.save(customer1);
        neroManager.save(customer2);

        System.out.println("----------------------------------------------------------------------------");

        starbucksManager.saleCoffee(customer1);
        starbucksManager.saleCoffee(customer1);
    }
}
