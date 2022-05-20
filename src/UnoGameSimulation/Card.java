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
public class Card
{
    private Colour s;
    private Face f;

    /**
     *
     * @param s colour of the card
     * @param f face of the card
     */
    public Card(Colour s, Face f){
        this.s=s;
        this.f=f;
    }

    /**
     *
     * @return colour
     */
    public Colour getColour(){
        return s;
    }

    /**
     *
     * @return face
     */
    public Face getFace(){
        return f;
    }
   
    @Override
    public String toString(){
        return s.getDisplayColour()+" "+f.getDisplay();
    }
}

