/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;

/**
 *
 * @author Jan
 */
public class MainMenuView extends View {

    private String promptMessage;

    // private String menu; ??
    public MainMenuView() {
        super("\n"
                + "\n -------------------------------------------------"
                + "\n    Main Menu                                     "
                + "\n -------------------------------------------------"
                + "\nS - Save Game"
                + "\nG - Return to Game Menu"
                + "\nH - Get Help"
                + "\nE - Exit Game without Saving"
                + "\n --------------------------------------------------"
                + "\nChoose a Menu Option: ");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); //convert choice to upper case

        switch (value) {
            case "S": //save game
                this.saveGame();
                break;
           case "G": //save game
                this.gameMenu();
                break;
           case "H": //display help menu
                this.displayHelpMenu();
                break;
            case "E":
                this.exitGame();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Choose a Menu Option");
                break;
        }
        return false;

    }

    /* startNewGame(): void
BEGIN
Create a new Game
Create a new Game Menu View
Display the Game Menu
END */
    private void startNewGame() {
        //create a new game
        GameControl.createNewGame(WheresMyBone.getPlayer());

        //display the game menu
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();

    }

    private void loadSavedGame() {
        InputView input = new InputView();
        input.loadSavedGame();
    }

    private void saveGame() {
       InputView input = new InputView();
       input.saveGame();
    }

    private void gameMenu() {
        GameMenuView gameMenuView = new GameMenuView();    
        gameMenuView.display();
       
    }
    private void displayHelpMenu() {

        //Create displayHelpMenu object
        HelpMenuView helpMenuView = new HelpMenuView();

        // Display the help menu view
        helpMenuView.display();

    }

    private void exitGame() {
        System.exit(0);
    }
}
