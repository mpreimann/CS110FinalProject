/**Matt Reimann
cs110 simulates Deck holds cards
 */

import java.util.Random;
import java.util.ArrayList;

public class Deck
{

   //to hold cards
   private ArrayList<Card> deck;
   
   
   
   /** no arg constructor creates a new deck
   */
   public Deck()
   {
     deck = new ArrayList<Card>();
      

      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.DIAMONDS;s++)
         {
           deck.add(new Card(r,s));
         }
      }

   }
   
   /** this method deals a card
   @return card is the card being returned
   */   
   public Card dealCard()
   {
      Card card = deck.remove(0);  
      return card;
   }

   /** returns the amount of cards left in the deck
   @return deck.size() is the amoun of cards in the deck
   */
   public int cardsRemaining()
   {  
      return deck.size();
   }

   /**randomizes order of cards in deck
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }

   /*checks if deck is empty
   @return returns true if empty false if it still has cards*/
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
          
         
   /** finds the highest card and returns it
   @return the highest card*/     
   public static Card higherCard(Card...cards)
   {
   
      Card high = cards[0];
      for (int i=1;i<cards.length;i++)
      {
         if (cards[i].getRank() > high.getRank())
         {
         
            high = cards[i];
         }
      }
      return high; 
   }     

}