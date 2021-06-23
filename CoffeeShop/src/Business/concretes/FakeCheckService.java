package Business.concretes;

import Business.abstracts.CustomerCheckService;
import Entites.concretes.Customer;

public class FakeCheckService implements CustomerCheckService {

    @Override
    public boolean isRealPerson(Customer customer) {
        return true;
    }
}
