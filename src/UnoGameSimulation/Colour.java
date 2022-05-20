/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnoGameSimulation;

/**
 *
 * @author Harshilkumar Vaghela 
 * @date October 8,2020(Assignment1)
 */
public enum Colour {
    BLUE("Blue"),
    GREEN("Green"),
    RED("Red"),
    YELLOW("Yellow"),
    BLACK("Wild");

    private String displayColour;

    private Colour(String displayColour) {
        this.displayColour = displayColour;
    }

    public String getDisplayColour() {
        return displayColour;
    }
    public boolean isBlack(){
        boolean k=false;if(displayColour.equals("Wild")){
            k= true;
        }
    return k;}
}

