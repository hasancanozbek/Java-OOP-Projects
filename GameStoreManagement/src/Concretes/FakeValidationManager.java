package Concretes;

import Abstracts.PersonCheckService;
import Entities.Gamer;

public class FakeValidationManager implements PersonCheckService {
    @Override
    public boolean realPerson(Gamer gamer) {
        System.out.println("Fake service runned. Person verified.");
        return true;
    }
}
