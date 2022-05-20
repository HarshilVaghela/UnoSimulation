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
public enum Face {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    SKIP("\u2205 "),
    REVERSE("\u21c4"),
    WILD("*");

    private String display;

    private Face(String display) {
        this.display = display;

    }
    public boolean isWild(){
        boolean k=false;
    if(display.equals("*")){
        k= true;
    }
    return k;
    }

    public String getDisplay() {
        return display;
    }

}

