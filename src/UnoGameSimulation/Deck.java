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
public class Deck{

    public SinglyLinkedList<Card> deck;
    public Deck(){
        deck=new SinglyLinkedList<>();
        for(int i=0;i<4;i++){
            deck.addFirst(new Card(Colour.BLACK, Face.WILD));
        }
        
        for (Colour c : Colour.values()) {
            if (!c.isBlack()){
                for (Face f : Face.values()) {
                    if(!f.isWild()){
                        deck.addLast(new Card(c,f));
                        deck.addLast(new Card(c,f));
                    }
                }
            }  
        }
    }

    public void shuffle(){
        SinglyLinkedList<Card> testDeck1= new SinglyLinkedList<>();
        SinglyLinkedList<Card> testDeck2= new SinglyLinkedList<>();
        int size=deck.size();
        for(int i=0;i<size/2;i++){
            testDeck1.addLast(deck.removeFirst());
        }
        for(int i=0;i<size/2;i++){
            testDeck2.addLast(testDeck1.removeFirst());
            testDeck2.addLast(deck.removeFirst());
        }
        deck=testDeck2;
    }

    public Card deal(){
        Card c=deck.removeFirst();
        return c;
    }

    public int size(){
        return deck.size();
    }

    public String toString(){
        return deck.toString();
    }
}
