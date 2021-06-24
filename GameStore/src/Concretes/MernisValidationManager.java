package Concretes;

import Abstracts.PersonCheckService;
import Core.MernisServiceReference.LOKKPSPublicSoap;
import Entities.Gamer;

import java.util.Locale;

public class MernisValidationManager implements PersonCheckService {

    @Override
    public boolean realPerson(Gamer gamer) throws Exception {
        LOKKPSPublicSoap mernisService = new LOKKPSPublicSoap();
       return mernisService.TCKimlikNoDogrula(Long.valueOf(gamer.getNationalityId()),gamer.getFirstName().toUpperCase(new Locale("tr")),gamer.getLastName().toUpperCase(new Locale("tr")),gamer.getBirthOfYear());
    }
}
