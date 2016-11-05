/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;

/**
 *
 * @author tCalder
 */
public class HelpMenuView {
      private String promptMessage;{
        
}
    private String menu;
        public HelpMenuView() {
            this.menu = "\n"
                      + "\n -------------------------------------------------"
                      + "\n    Help Menu                                     "
                      + "\n -------------------------------------------------"
                      + "\nP - How to Play"
                      + "\nM - How to Move"
                      + "\nC - Clues"
                      + "\nO - Objects"
                      + "\nH - How to Save/Load Game"
                      + "\nB - Bad Guys"
                      + "\nQ - Quit Help Menu"
                      + "\n --------------------------------------------------";
            
            this.promptMessage = "\nChoose a Menu Option: ";
                    }
                
    public void displayHelpMenuView() {
        
        boolean done = false; //set flag to not done
        do {
            System.out.println("\n" + this.menu);
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit Help Menu
                   return; //exit the menu
            //do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
        }
/*BEGIN
 do
 Prompt for and get the input value/s
 if (value == “X”) then
 exit

 do the action and display the next view
 while the view is not done */

    private String getMenuOption() {

/*    getInput(): value
BEGIN
 WHILE a valid value has not been entered
 DISPLAY a message prompting the user to enter a value
 GET the value entered from keyboard
 Trim front and trailing blanks off of the value
 IF the length of the value is blank THEN
 DISPLAY “Invalid value: The value cannot be blank”
 CONTINUE
 ENDIF
 BREAK
 ENDWHILE
 RETURN value */
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();//removes spaces at front and end
            
            if (value.length() < 1) {
                System.out.println("\n Invalid value: value cannot be blank");
                continue;
            }
            break;
        }
        return value;       }

    /* doAction(choice): void
BEGIN
convert choice to upper case
SWITCH choice
“N”: Start a new game
“G”: Get and start a saved game
“H”: Display the help menu
“S”: Display the save game view
DEFAULT: DISPLAY “Invalid selection”
ENDSWITCH
RETURN false
END */
    
    private boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert choice to upper case
        
        switch (choice) {
            case "P": //How to Play
                this.howPlay();
                break;
            case "M": //How to Move
                this.howMove();
                break;
            case "C": //about Clues
                this.aboutClues();
                break;
            case "O": //about Objects
                this.aboutObjects();
                break;
            case "B": //about bad guys
                this.aboutBadGuys();
                break;
            case "H": //how to save/load game
                this.howSave();
                break;
            case "Q": //quit Help Menu
                this.quitHelp();
            default:
                System.out.println("\n*** Invalid selection *** Choose a Menu Option");
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

    private void howPlay() {
        System.out.println("\n-------------------------------------------------"
                         + "\nHow to Play"
                         + "\n-------------------------------------------------"
                         + "\nAs you travel the map, talk to those you meet"
                         + "\nand solve basic puzzles to get your precious bone"
                         + "\nback. You will be presented with a map and asked "
                         + "\nto choose a location to move to. Pick up items as"
                         + "\nyou come upon them and interact with the game"
                         + "\ncharacters to get clues as you look for the bone."
                         + "\nYou may be asked for input to solve some simple  "
                         + "\nmath puzzles. Your goal Watch out for the Dog"
                         + "\nis to find the bone before your time runs out!"
                         + "\n"
                         + "\n-------------------------------------------------"
        );
    }

    private void howMove() {
        System.out.println("\n-------------------------------------------------"
                         + "\nHow to Move"
                         + "\n-------------------------------------------------"
                         + "\nWhen you are presented with the map grid, pick a "
                         + "\nlocation and input the coordinates. You will then"
                         + "\nbe moved to that location and be able to explore"
                         + "\nand look for the bone."
                         + "\n"
                         + "\n-------------------------------------------------"
        );
    }

    private void aboutClues() {
        System.out.println("\n-------------------------------------------------"
                         + "\nAbout Clues"
                         + "\n-------------------------------------------------"
                         + "\nAs you advance through the game you will meet"
                         + "\ncharacters in various locations on the map."
                         + "\nThese characters, or their surroundings, may give"
                         + "\nyou clues to finding your bone. You'll have to"
                         + "\ndecide if they're trying to help you, or throw you"
                         + "\noff the trail!"
        );
    }

    private void aboutObjects() {
        System.out.println("\n-------------------------------------------------"
                         + "\nAbout Objects"
                         + "\n-------------------------------------------------"
                         + "\nEach location on the map has an object at it for"
                         + "\nyou to find. When you find an item you can pick"
                         + "\nit up and put it in your Backpack. Later, when"
                         + "\nencounter another character on the map, you may"
                         + "\nneed some of these items to gain your clues."
        );
    }

    private void aboutBadGuys() {
        System.out.println("\n-------------------------------------------------"
                         + "\nAbout Bad Guys"
                         + "\n-------------------------------------------------"
                         + "\nCat DeVil Gang: DeVil, the neighbor cat, has"
                         + "\nalways been on the watch list for a number of"
                         + "\ncrimes in the area. Due to her posse and quick"
                         + "\ntongue, she has always been able to avoid getting"
                         + "\ncaught. Keep an eye out for her and her gang as"
                         + "\nthey will not be too happy with you trying to get"
                         + "\nyour bone back."
                         + "\n"
                         + "\nDog Catcher: He randomly moves around from"
                         + "\nsquare to square. If you encounter him, he will"
                         + "\ntake you to the pound. This will cost valuable"
                         + "\ntime, making it harder to retrieve your precious"
                         + "\nin time!"
        );
    }
    
    private void howSave() {
        System.out.println("\n"
                         + "\nHow to Save"
                         + "\n-------------------------------------------------"
                         + "\nIn order to save your game, open the game menu"
                         + "\nand press 'S'. This will save your game. When you"
                         + "\nare ready to come back and start taking a bite"
                         + "\nout of crime again, Press 'L' in the Main Menu."
                         + "\nThis will load the last game saved."
        );
    }

    private void quitHelp() {
        //Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
         // Display the main menu view
        mainMenuView.displayMainMenuView();
    }

    
}