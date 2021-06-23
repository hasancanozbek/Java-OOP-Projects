package Business.abstracts;

import Entites.concretes.Customer;

public abstract class BaseCustomerManager implements CustomerService, SaleService{

    @Override
    public void save(Customer customer) {
        System.out.println("Saved to DB : "+customer.getFirstName()+" "+customer.getLastName());
    }

    @Override
    public void saleCoffee(Customer customer) {
        System.out.println("Thank you for choosing us " + customer.getFirstName());
    }
}
