package Core.Adapters;

import Entities.concretes.IndividualAccount;

public interface CustomerCheckService {
    /*
    Bu servis ana kimlik doğrulama servisi. İleride mernis ile çalışmayı bırakıp başka bir sevisle (örneğin mernisV2 extra
    olarak seri numarası, doğum yeri gibi bilgiler istiyor. Bu yazılımda iki sistem de entegre edildi.)
    çalışmaya başladığımızda tüm kodları o servise göre düzenlememiz gerekecekti. Ancak bu interface sayesinde tüm
    doğrulama servislerinin referansını tek bir yerde tutup, katmanlar arasındaki iletişimi bu ana servis üzerinden
    gerçekleştiriyoruz.
     */

    boolean isRealPerson(IndividualAccount individualAccount) throws Exception;
}
