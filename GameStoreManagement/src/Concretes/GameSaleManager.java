package Concretes;

import Abstracts.SaleService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class GameSaleManager implements SaleService {

    @Override
    public void sale(Gamer gamer, Game game) {
        System.out.println(game.getName() + " sold to " + gamer.getFirstName()+" "+gamer.getLastName());
    }

    @Override
    public void bargainSale(Gamer gamer, Game game, Campaign campaign) {
        System.out.println(game.getName() + " sold to " + gamer.getFirstName()+" "+gamer.getLastName()+" for "+game.getPrice()+"$ (-%"+campaign.getDiscount()+")");
    }
}
