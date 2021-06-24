package Business.concretes;

import Business.abstracts.CustomerService;
import Business.abstracts.EmailVerificationService;
import Core.Adapters.ThirdPartyRegistrationService;
import Core.Utils.RegexManager;
import DataAccess.abstracts.CustomerDao;
import Entities.concretes.Customer;

public class CustomerManager implements CustomerService, EmailVerificationService {

    private final CustomerDao customerDao;
    private final ThirdPartyRegistrationService thirdPartyRegistrationService;
    public CustomerManager(CustomerDao customerDao, ThirdPartyRegistrationService thirdPartyRegistrationService){
        this.customerDao = customerDao;
        this.thirdPartyRegistrationService = thirdPartyRegistrationService;
    }

    @Override
    public void register(Customer customer) {
        if (    RegexManager.isValidFormat(customer.getEmail()) &&
                customer.getPassword().length()>=6 &&
                customer.getFirstName().length()>=2 &&
                customer.getLastName().length()>=2 &&
                !(customerDao.getCustomers().contains(customer.getEmail()))
                ){
            customerDao.save(customer);
            System.out.println("We send mail for you. Please confirm your email address.");
            emailVerified(customer,true);

        }
        else{
            System.out.println("Registration failed.");
        }
    }

    @Override
    public void Login(Customer customer, String email, String pass) {
        if (customer.getEmail().equals(email)){
            System.out.println("You have successfully logged in. Welcome "+customer.getFirstName());
        }
        else{
            System.out.println("Email or password is incorrect.");
        }
    }


    @Override
    public boolean emailVerified(Customer customer, boolean value) {
        if (value){
            System.out.println("Your e-mail verified.");
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void registerWithThirdParty(){
        thirdPartyRegistrationService.registeredWithThirdPartyAccount();
    }
}
