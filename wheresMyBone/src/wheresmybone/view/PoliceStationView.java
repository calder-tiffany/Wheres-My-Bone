/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;

/**
 *
 * @author Jan
 */
public class PoliceStationView extends View {
    //private String promptMessage;{
//}
GameMenuView gameMenu = new GameMenuView();
    public PoliceStationView() {
            super("\n*********************************************************"
                + "\n             OFFICER PETE   "
                + "\n********************************************************"
                + "\n"
                + "\nYou start heading across town.  Maybe you'll run into DeVil "
		+ "\non your way.  Your excellent nose picks up some scents you"
		+ "\nknow.  Ah, Barney was here.  And Princess.  Max, too."
		+ "\nAs you sniff your way downt he street, you hear a commotion."
		+ "\nYou look up to see a big man with a mask running away from "
		+ "\nOfficer Pete, the local law enforcement."
		+"\n"
		+"\nWhat do you do?"
                + "\n"
                + "\n********************************************************"
                + "\nH - Help Officer Pete."
                + "\nR - Return to Game Menu"
                + "\n********************************************************");
            this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "H":
                this.helpPete();
                break;
            case "R":
                gameMenu.display();

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        gameMenu.display();
        return true;

    }

    private void helpPete() {
        this.console.println     ("\n"
				+ "\nYou decide to help your old friend.  Just as the man with the "
				+ "\nmask gets close, you step out in front of him.  He can’t dodge "
				+ "\nfast enough and trips right over you, face-planting on the sidewalk."
				+ "\nOfficer Pete comes up quickly and slaps handcuffs on the man."
				+ "\n“Good work, " + StartProgramView.player.getName() + "!” he praises.  “We should put you on the force!"
				+ "\nThanks for the help.”"
				+ "\n"
				+ "\n“You’re welcome, Officer.  By any chance, have you seen DeVil?”"
				+ "\n“DeVil?  Why are you looking for that mean thing?”"
				+ "\n“I think he stole my bone.”"
				+ "\n“Well, have you checked the Alley?” Officer Pete asks.  "
                                + "\n“He’s most likely hanging with his buddies.”"
                                + "\n"
                                + "\n***************************************************************");
    }

    public double timeLeft() {
        double travelTime = 15;
        GameControl calcTimeLeft = new GameControl();
        double timeLeft = 0;
        try {
            timeLeft = calcTimeLeft.calcTimeLeft(travelTime);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
        return timeLeft;
    }
        }

