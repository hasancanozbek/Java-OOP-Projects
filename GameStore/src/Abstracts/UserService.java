package Abstracts;

import Entities.Gamer;

public interface UserService {

    void add(Gamer gamer);

    void delete(Gamer gamer);

    void update(Gamer gamer, String name, String surname);
}
