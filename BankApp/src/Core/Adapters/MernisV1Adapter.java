package Core.Adapters;

import Core.MernisV1.AUOKPSPublicSoap;
import Entities.concretes.IndividualAccount;

import java.util.Locale;

public class MernisV1Adapter implements CustomerCheckService{
    /*
    Adapters tasarım deseni, dışarıdan bir servisle çalışmak istediğimizde bağımlılığı azaltmak için kullandığımız bir
    tasarım kalıbdır. Bu kodda dışarıdan almış olduğumuz MERNİS sistemini program içinde direkt kullanmak yerine, bir
    adapter yardımıyla bu servisi kendi yazılımıza uyarlıyoruz ve böylelikle olası bağımlılıkları azaltmış oluyoruz.
    Eğer direkt olarak adapter kullanmadan kodlara entegre etmiş olsaydık MERNİS sisteminin hizmet vermeyi durdurması,
    aksatması vb. durumlarda programımız da çökecekti.
    */

    @Override
    public boolean isRealPerson(IndividualAccount individualAccount) throws Exception {

        AUOKPSPublicSoap mernisVerify = new AUOKPSPublicSoap();
        return mernisVerify.TCKimlikNoDogrula(Long.parseLong(individualAccount.getCustomerTC()),individualAccount.getCustomerFirstName().toUpperCase(new Locale("tr")),individualAccount.getCustomerLastName().toUpperCase(new Locale("tr")),Integer.valueOf(individualAccount.getCustomerBirthOfYear()));
    }
}
