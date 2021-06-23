package Business.concretes;

import Business.abstracts.BaseCustomerManager;
import Business.abstracts.CustomerCheckService;
import Entites.concretes.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {

    private CustomerCheckService customerCheckService;

    public StarbucksCustomerManager(CustomerCheckService customerCheckService){
        this.customerCheckService = customerCheckService;
    }

    @Override
    public void save(Customer customer) {
        try {
            if (customerCheckService.isRealPerson(customer)){
                System.out.println("Successfully saved : "+customer.getFirstName()+" "+customer.getLastName());
            }
            else{
                System.out.println("Customer could not be verified. : "+customer.getFirstName()+" "+customer.getLastName());
            }
        } catch (Exception e) {
            System.out.println("Can't access MERNİS validation service. Please try again.");
            System.out.println(e.getMessage());
        }

    }

    static int star=0;
    @Override
    public void saleCoffee(Customer customer) {
        super.saleCoffee(customer);
        star++;
        System.out.println("You earn 1 star for your order. Your total stars : "+star);
    }
}
