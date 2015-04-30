/*Matt Reimann cs110
this program simulates the card game war*/
import java.util.Scanner;
import java.util.ArrayList;
public class War
{
   
   //define variables
   private Deck deck = new Deck();
   private Card card = new Card();
   private Card player1card;
   private Card player2card; 
   private Card warloot = new Card();     
   private Card winner = new Card();
   private QueueReferenceBased player1Hand = new QueueReferenceBased();
   private QueueReferenceBased player2Hand = new QueueReferenceBased();
   private Scanner keyboard = new Scanner(System.in);
   private String  str="y", input,p1,p2;
   
   /** no arg constructor that sets up the hands for war
   */  
   public War()
   {
      //create deck of cards
      deck.shuffle();
      
      //deal cards to two different hands
      while(!deck.isEmpty())
      {
         card=deck.dealCard();
         player1Hand.enqueue(card);
         
         card=deck.dealCard();
         player2Hand.enqueue(card);
      }
      
   }  
   
   /**flips a card for war
   @return player1 card returns a card for [layer 1
   */ 
   public Card getPlayer1Card()
   {
      player1card = new Card(player1Hand.dequeue().toString());
      return player1card;
   }
   
   /**flips a card for war
   @return player1 card returns a card for [layer 1
   */
   public Card getPlayer2Card()
   {
      player2card = new Card(player2Hand.dequeue().toString());
      return player2card;
      
   }
   
   /**adds a winning card back to players deck
   @param card is the card added back to the deck
   */
   public void addWinning1(Card card)
   {
      player1Hand.enqueue(card);
   }
   
   /**adds a winning card back to players deck
   @param card is the card added back to the deck
   */
   public void addWinning2(Card card)
   {
      player2Hand.enqueue(card);
   }   
   
   /**this method finds the winner between the two cards
   @param p1 the first card
   @param the second card
   @return str a string that says who won
   */
   
   public String winner(Card p1, Card p2)
   {
      String str="";
      winner = Deck.higherCard(p1,p2);
               //if player 1 wins
      if(winner.equals(p1))
      { 
         player1Hand.enqueue(p1);
         player1Hand.enqueue(p2);
         str =("player 1 wins this round");
      }
               
               //if player 2 wins
      if(winner.equals(p2))
      {
        
         player2Hand.enqueue(p1);
         player2Hand.enqueue(p2);
         str=("player 2 wins this round");
      } 
      return str;
   }   
   
   /**this method finds the winner between the two cards when there is a war
   @param p1 the first card
   @param the second card
   @return warWin a string that says who won
   */
   
   public String cardWarWin(Card p1, Card p2)
   {
      String warWin="";
      winner = Deck.higherCard(p1,p2);
               
      //if player 1 wins
      if(winner.equals(player1card))
      { 
         player1Hand.enqueue(player1card);
         player1Hand.enqueue(player2card); 
         warWin=("player 1 won the war");
      }
               
      //if player 2 wins
      if(winner.equals(player2card))
      {
        
         player2Hand.enqueue(player1card);
         player2Hand.enqueue(player2card);    
         warWin=("player 1 won the war");
      }        
       return warWin;
   }   
      
      
   /**this method finds out who won the game if the game is over
   @return win is a string thats says which player won
   */           
   public String whoWon()
   {  
      String win="";
      if (player1Hand.isEmpty())
      {
         win=("player 2 wins!");
      }
      
      if(player2Hand.isEmpty())
      {
         win=("player 1 wins");
      } 
      
      return win;
   }
   
   /** this method checks to see if the game is over
   @return over boolean true if game is over false if game isn't over
   */     
   public boolean gameOver()
   {
      boolean over = false;
      if (player1Hand.isEmpty()||player2Hand.isEmpty())
      {
         over = true;
      }
      return over;
   }         
   
}         
         