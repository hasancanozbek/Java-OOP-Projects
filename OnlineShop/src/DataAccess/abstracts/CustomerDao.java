package DataAccess.abstracts;

import Entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerDao {

    void save(Customer customer);

    List<String> customers = new ArrayList<>();
    List<String> getCustomers();
}
