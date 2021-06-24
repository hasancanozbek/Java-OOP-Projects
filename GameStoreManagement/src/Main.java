import Concretes.*;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class Main {

    public static void main(String[] args) {

        //OBJECTS CREATED
        Game game1 = new Game("EU4",100);
        Game game2 = new Game("Far Cry 3",50);

        Campaign campaign = new Campaign("Summer Sale",20);

        Gamer gamer = new Gamer("Hasan Can","Özbek","11111111111",2001);

        //--------------------------------------------------------------------------------------------------------\\

        //TESTS
        GameSaleManager saleManager = new GameSaleManager();
        GamerManager gamerManager = new GamerManager(new FakeValidationManager());
        CampaignManager campaignManager = new CampaignManager();

        campaignManager.addCampaign(campaign,game1);
        gamerManager.add(gamer);
        saleManager.sale(gamer,game2);
        saleManager.bargainSale(gamer,game1,campaign);
    }
}
