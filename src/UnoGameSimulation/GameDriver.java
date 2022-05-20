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
public class GameDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck=new Deck();
        
        CircularDoublyLinkedList<Player> players=new CircularDoublyLinkedList<>();
        Player p1=new Player("Simba");
        Player p2=new Player("Nala");
        Player p3=new Player("Timon");
        Player p4=new Player("Pumbaa");
        players.addFirst(p1);
        players.addLast(p2);
        players.addLast(p3);
        players.addLast(p4);
        GameSimulation g=new GameSimulation(deck,players);
        g.deal();
        g.playGame();

         
    }

}
