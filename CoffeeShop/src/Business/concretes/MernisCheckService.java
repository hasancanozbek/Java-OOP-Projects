package Business.concretes;

import Business.abstracts.CustomerCheckService;
import Entites.concretes.Customer;
import MernisService.EAEKPSPublicSoap;

import java.util.Locale;

public class MernisCheckService implements CustomerCheckService {

    @Override
    public boolean isRealPerson(Customer customer) throws Exception {
        EAEKPSPublicSoap mernis = new EAEKPSPublicSoap();
            return mernis.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()), customer.getFirstName().toUpperCase(new Locale("tr")), customer.getLastName().toUpperCase(new Locale("tr")), customer.getBirthOfDate());
    }
}
