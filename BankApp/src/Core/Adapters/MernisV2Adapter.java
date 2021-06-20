package Core.Adapters;

import Entities.concretes.IndividualAccount;

public class MernisV2Adapter implements CustomerCheckService{
    /*
    MernisV1 sistemi hizmet vermemeye başladığı zaman yedek olarak bir fake servis yazdım.
    Bu servis tüm kullanıcıları gerçek kabul ederek db'ye kaydediyor. Konfigrasyon tarafında ister fake servisi,
    ister gerçek MERNİS servisini kullanabiliriz.
     */
    @Override
    public boolean isRealPerson(IndividualAccount individualAccount) {
        return true;
    }
}
