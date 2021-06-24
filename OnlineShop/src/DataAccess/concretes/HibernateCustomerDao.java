package DataAccess.concretes;

import DataAccess.abstracts.CustomerDao;
import Entities.concretes.Customer;
import java.util.List;


public class HibernateCustomerDao implements CustomerDao {

    @Override
    public void save(Customer customer) {
        customers.add(customer.getEmail());
        System.out.println("Successfully registered : "+customer.getFirstName()+" "+customer.getLastName());
    }

    @Override
    public List<String> getCustomers() {
        return customers;
    }


}
