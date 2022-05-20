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
public class GameSimulation
{
    private CircularDoublyLinkedList<Player> playerList;
    private Deck deck;
    private Card lastCard;
    
    public GameSimulation(){
        deck=new Deck();
        playerList= new CircularDoublyLinkedList<>();
        lastCard=null;
    }

    public GameSimulation(Deck d,CircularDoublyLinkedList<Player> p){
        deck=d;
        playerList=p;
    }

    public Deck getDeck(){
        return deck;
    }

    public void deal(){
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        for(int i=0;i<playerList.size();i++){
            for(int j=0;j<7;j++){playerList.first().addCard(deck.deal());
            }
            playerList.rotateForward();
        }
    }
    
    public int findPlayableIndex(Card LastCard){
        int a=-1;        
        for(int i=0;i<playerList.first().getSize();i++){
            Card c=playerList.first().peekCard(i);
            if(a==-1){
                if(lastCard.getColour()==c.getColour()){
                    a=i;
                }
            }
        }
        if(a==-1){
            for(int i=0;i<playerList.first().getSize();i++){
                Card c=playerList.first().peekCard(i);
                if(a==-1){
                    if(lastCard.getFace()==c.getFace()){
                        a=i;
                    }
                }
            }
        }
        if(a==-1){
            for(int j=0;j<playerList.first().getSize();j++){
                Card c=playerList.first().peekCard(j);
                if(c.getFace().isWild()){a=j;}
            }}
        return a;

    }
    public void direction(int i){
        if(i==1){
            playerList.rotateReverse();
        }
        if(i==0){
            playerList.rotateForward();
        }
    }

    public void playGame(){

        boolean finished=false;
        lastCard=deck.deal();
        System.out.println("First Card:\n"+lastCard);
        int noteDirection=0;
        while(!finished){
            int indexOfPlayable=findPlayableIndex(lastCard);
            Card drawnCard;
            System.out.println(playerList.first());
            if(indexOfPlayable==-1){
                drawnCard=deck.deal();
                playerList.first().addCard(drawnCard);
                indexOfPlayable=findPlayableIndex(lastCard);
                System.out.println("no cards to play, draws "+drawnCard);
            }
            if(indexOfPlayable!=-1){
                lastCard=playerList.first().playCard(indexOfPlayable); 
                System.out.println(playerList.first().getName()+" plays "+lastCard+"\n");
                
                if(lastCard.getFace().isWild()){
                    Card c=playerList.first().peekCard(0);int i=0;
                    if(playerList.first().getSize()!=1){
                    while(c.getColour().isBlack()){
                        c=new Card(playerList.first().peekCard(i).getColour(),Face.WILD);
                        i++;
                    }
                    }
                    
                    lastCard=c;
                    System.out.println("Colour is now "+lastCard.getColour().getDisplayColour());

                }
                
                if(lastCard.getFace()==Face.SKIP){
                    if(playerList.first().getSize()==1){
                        System.out.println(playerList.first().getName()+" yells UNO!\n");
                    }
                    direction(noteDirection);
                            System.out.println(playerList.first().getName()+" misses a turn\n");
                }
               
                if(lastCard.getFace()==Face.REVERSE){
                    if(noteDirection==1){
                        noteDirection=0;
                    }
                    else if(noteDirection==0){
                    noteDirection=1; 
                    }System.out.println("Game reverses direction\n");
                    if(playerList.first().getSize()==1){
                        System.out.println(playerList.first().getName()+" yells UNO!\n");
                    }
                }
                
            }
            else{ 
                System.out.println(playerList.first().getName()+" does not play anything.\n");}
            if(playerList.first().getSize()==1&& lastCard.getFace()!=Face.SKIP){
                System.out.println(playerList.first().getName()+" yells UNO!\n");
            }
            if(playerList.first().getSize()==0){
                System.out.println(playerList.first().getName()+" Wins");
                finished=true;
            }
            direction(noteDirection);
        }
    }

    


}

