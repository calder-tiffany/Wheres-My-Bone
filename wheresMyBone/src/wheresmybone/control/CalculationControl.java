/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import wheresmybone.exceptions.CalculationControlException;


/**
 *
 * @author Jan
 */
public class CalculationControl {
    
    // calcVolumeBox coded by Tif Calder
    public void calcVolumeBox(double length, double width, double height)
                                throws CalculationControlException {
        //box volume calculation
        double volumeBox = length * width * height;
        
        if (volumeBox < 216) {
                throw new CalculationControlException("That box is to small"
                        + "/nfor cat DeVil to fit into.");
            }
         
    }   
   
    //Cylinder Calculations by Jan Hill
    public double calcCylinderVolume(double height, double diameter) {

        
    if (height <= 1 || height >20) {//height is negative or too large
            return -1;
                }
	if (diameter <= 1 || diameter > 16) {//diameter is negative or too large
            return -1;
            }

        // calculation of the volume
	double radius = diameter/2;
	double volume = Math.PI*radius*radius*height;
	return volume;

    //end of calculation of cylinder volume
    }
    
    
}
