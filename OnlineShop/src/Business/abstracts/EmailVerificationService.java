package Business.abstracts;

import Entities.concretes.Customer;

public interface EmailVerificationService {

    boolean emailVerified(Customer customer, boolean value);
}
