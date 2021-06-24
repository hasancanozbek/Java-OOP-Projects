package Concretes;

import Abstracts.PersonCheckService;
import Core.MernisServiceReference.CTPKPSPublicSoap;
import Entities.Gamer;

import java.util.Locale;

public class MernisValidationManager implements PersonCheckService {

    @Override
    public boolean realPerson(Gamer gamer) throws Exception {
        CTPKPSPublicSoap mernisService = new CTPKPSPublicSoap();
       return mernisService.TCKimlikNoDogrula(Long.valueOf(gamer.getNationalityId()),gamer.getFirstName().toUpperCase(new Locale("tr")),gamer.getLastName().toUpperCase(new Locale("tr")),gamer.getBirthOfYear());
    }
}
