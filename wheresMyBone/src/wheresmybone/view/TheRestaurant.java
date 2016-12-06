/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.Serializable;
import wheresmybone.WheresMyBone;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;

/**
 *
 * @author Jan
 */
public class TheRestaurant extends View {
    //private String promptMessage;{
//}

    public TheRestaurant() {
        super("\n*********************************************************"
                + "\n                 THE RESTAURANT   "
                + "\n********************************************************"
                + "\n"
                + "\nMr. Stealetti runs the Italian Restaurant in town.  He’s a short,"
                + "\nolder, Italian man with white hair, but he cooks up the most amazing"
		+ "\nmeals.  DeVil likes to sniff around the garbage there.  Maybe he’s "
		+ "\nthere. "
		+ "\nAs you round the building, the wonderful smell of food cooking fills"
		+ "\nthe air.  You don’t see DeVil, but Mr. Stealletti is leaning on the "
		+ "\nlower half of his back door staring out into the lot.  He looks down "
		+ "\nat you and gives you a sad smile."
		+ "\n“What’s wrong, Mr. Stealletti?” you ask."
		+ "\n“Ah," + StartProgramView.player.getName() + ".  I’m-a so worried!  I "
		+ "\nneed a present for me granddaughter’s birthday tonight, but with all "
		+ "\nthe work I have-a to do, I have-a no time to get one!”"
		+ "\n“Maybe I can help.  What did you want to get her?”"
		+ "\n“She loves-a snowglobes.  You know-a, those round-a glass balls with"
		+ "\nthe white flakes on a base.  Ah, but I-a don’t-a know where to get one!”"
                + "\n"
                + "\n********************************************************"
                + "\nG - Get Donuts"
                + "\nX - Leave the Area!"
                + "\n********************************************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "S":
                this.searchYourBackpack();
                break;

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    public void searchYourBackpack() {
     Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "Snowglobe";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            this.console.println("\n“How about this one, Mr. Stealletti?  Will she like"
			+ "\nthis one?”"
			+ "\n“Oh,"+ StartProgramView.player.getName() + "!  You’s a life "
			+ "\nsaver!  Here!  Have a meat-a-ball!”  He tosses you a very large"
			+ "\nmeatball slathered in sauce.  Mmmmm!"
			+ "\n"
                        + "\n****************************************************"
                        + "\nWhere To Now?"
                        + "\n****************************************************");

        } else {
            this.console.println("\n“Gee, I’m sorry.  I don’t have one.  I’ll see if I can "
					+ "\nfind one.”"
                    + "\n****************************************************"
                    + "\nWhere To Now?  "
                    + "\n****************************************************");
        }
    }

}