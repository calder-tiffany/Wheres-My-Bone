/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.control.MapControl;
import wheresmybone.exceptions.MapControlException;
import wheresmybone.model.Game;
import wheresmybone.model.Location;
import wheresmybone.model.Map;

/**
 *
 * @author tCalder
 */
public class MapSymbolSceneName extends View {

public MapSymbolSceneName() {
    super ("\n*****************************************************************"
         + "\n    Find out where each Map Symbol will take you     "
         + "\n"
         + "\nTo see what location the map symbol will take you to, input the"
         + "\nmap symbol from the map above."
         + "\n"
         + "\n    Or choose (X) to return to Help Menu      "
         + "\n"
         + "\n*****************************************************************"
    ); 
    this.console.println("\n");
    viewMap();
    this.console.println("\n");
    
}
/*TEST MATRIX
        ******************************************
        |Location and Name of chosen MapSymbol   |
        ******************************************
        |          |  VALID       |  INVALID     |
        ******************************************
        | INPUT     | PK           |     LX      |
        ******************************************
        | OUTPUT    |  0, The Park |     false   |
        ******************************************
        |   Error  |              | Please choose| 
        |                         | a valid Map  |
        |                         | Symbol       |
        ******************************************
        */
        
        /* ALGORITHM for displaying location of item
           Receive user input of valid mapSymbol and then
            process the below for statement to locate the item within the Scene[] scenes
           array, utilizing the SceneType enum, bothlocated in the MapControl Layer.
           Use the ordinal() function to find the location of the scene in 
                        the map and the .getSceneName() function to find the
                        sceneName.
           Display the location and Name of the scene corresponding with the
            MapSymbol on the screen, or the error message regarding selecting a
            valid Map Symbol
        */   
@Override
public boolean doAction(String value) {
    MapControl doSceneFromSymbol = new MapControl();
    boolean retVal = false;
    try {
        String resultStr = doSceneFromSymbol.doMapSymbolSceneName(value); 
        if (resultStr.isEmpty()) 
            retVal = true;
        else 
            this.console.println(resultStr);
    } catch (MapControlException ex) {
        ErrorView.display(this.getClass().getName(),ex.getMessage());
    }
        if (!retVal)
            viewMap();
    
    return retVal;
}

public void viewMap() {

        //Console console = System.console(); Displays Map
        String leftIndicator;
        String rightIndicator;
        Game game = WheresMyBone.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        try {
            this.console.print("  |");
            for (int column = 0; column < locations[0].length; column++) {
                this.console.print("  " + column + " |"); // print col numbers to side of map
            }
            this.console.println();
            for (int row = 0; row < locations[0].length; row++) {
                this.console.print(row + " "); // print row numbers to side of map
                for (int column = 0; column < locations[row].length; column++) {
                    leftIndicator = " ";
                    rightIndicator = " ";
                    if (locations[row][column] == map.getCurrentLocation()) {
                        leftIndicator = "*"; // can be stars or whatever these are indicators showing visited
                        rightIndicator = "*"; // same as above
                    } else if (locations[row][column].isVisited()) {
                        leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                        rightIndicator = "<"; // same as above
                    }
                    this.console.print("|"); // start map with a |
                    if (locations[row][column].getScene() == null) {
                        this.console.print(leftIndicator + "??" + rightIndicator);
                    } else {
                        this.console.print(leftIndicator + locations[row][column].getScene().getMapSymbol() + rightIndicator);

                    }
                }
                this.console.println("|");
            }
        } catch (Exception e) {
            this.console.println(e.getMessage());
        }

}
}
