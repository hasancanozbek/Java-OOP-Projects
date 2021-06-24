package Concretes;

import Abstracts.CampaignService;
import Entities.Campaign;
import Entities.Game;

public class CampaignManager implements CampaignService {

    @Override
    public void addCampaign(Campaign campaign, Game game){
        game.setPrice(game.getPrice()-(game.getPrice()*campaign.getDiscount()/100));
        System.out.println("The campaign has been applied the game");
    }
    @Override
    public void deleteCampaign(Campaign campaign){
        System.out.println("Campaign has been removed.");
    }
    @Override
    public void updateCampaign(Campaign campaign, Game game, int newDiscount){
        campaign.setDiscount(newDiscount);
        game.setPrice(game.getPrice()-(game.getPrice()*campaign.getDiscount()/100));
        System.out.println("Campaign has been updated.");
    }
}
