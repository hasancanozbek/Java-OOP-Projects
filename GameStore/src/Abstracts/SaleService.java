package Abstracts;

import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public interface SaleService {

    void sale(Gamer gamer, Game game);

    void bargainSale(Gamer gamer, Game game,Campaign campaign);

}
