package Business.abstracts;

import Entities.concretes.Customer;

public interface CustomerService {

    void register(Customer customer);

    void Login(Customer customer, String email, String pass);

    void registerWithThirdParty();
}
