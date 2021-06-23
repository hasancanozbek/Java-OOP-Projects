package Business.abstracts;

import Entites.concretes.Customer;

public interface CustomerCheckService {

    boolean isRealPerson(Customer customer) throws Exception;
}
