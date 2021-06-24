package Concretes;

import Abstracts.PersonCheckService;
import Abstracts.UserService;
import Entities.Gamer;

public class GamerManager implements UserService {

    private PersonCheckService personCheckService;
    public GamerManager(PersonCheckService personCheckService){
        this.personCheckService = personCheckService;
    }

    @Override
    public void add(Gamer gamer) {
        try {
            if (personCheckService.realPerson(gamer)){
                System.out.println("Gamer verified : "+gamer.getFirstName()+" "+gamer.getLastName());
            }
            else{
                System.out.println("Invalid person.");
            }
        } catch (Exception e) {
            System.out.println("Unable to access validation service. Please try again.");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Gamer gamer) {
        System.out.println("Account deleted.");
    }

    @Override
    public void update(Gamer gamer, String name, String surname) {
        gamer.setFirstName(name);
        gamer.setLastName(surname);
        System.out.println("Your personal information has been updated:");
    }
}
