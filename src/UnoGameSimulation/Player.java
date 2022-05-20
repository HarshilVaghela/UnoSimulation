package UnoGameSimulation;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;


/**
 *
 * @author Harshilkumar Vaghela 
 * @date October 8,2020(Assignment1)
 */
public class Player
{
    private ArrayList<Card> hand;
    private String name;
    
    public Player(){
        name="unknown";
        
    }
    public Player(String name){
        this.name=name;
        hand=new ArrayList();
        
    }
    public String getName(){
        return name;
    }
    public ArrayList getHand(){
        return hand;
    }
    
    public void addCard(Card c){
       hand.add(c);
    }
    public Card playCard(int index){
       Card c=hand.get(index);
       hand.remove(c);
       return c;
    }
    public int getSize(){
        return hand.size();
    }
    public Card peekCard(int index){
        Card c=hand.get(index);
        return c;
    }
    public String toString(){String l="("+name+"'s hand: ";
        for(int i=0;i<hand.size()-1;i++){
        l=l+hand.get(i)+", ";
        }
        l=l+hand.get(hand.size()-1)+")";
        return l;
    }
}
