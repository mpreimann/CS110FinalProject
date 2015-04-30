/*Matt Reimann cs 110
this class represents a playing card
*/
import java.util.StringTokenizer;
public class Card
{
   //define vriables
   public static int SPADES=0;
   public static int CLUBS=1;
   public static int HEARTS=2;
   public static int DIAMONDS=3;
   public static int ACE=1;
   public static int JACK=11;
   public static int QUEEN=12;
   public static int KING=13;
   private int rank;
   private int suit;
   
   /** constructor that gets a cards rank and suite
   @param ra is the rank
   @param su is the suite
   */
   public Card(int ra, int su)
   {
      rank = ra;
      suit = su;
   }
   /** constructor takes a string parameter specifically in the toString() form of a card
    tokenizes it for the rank and class
    @param the string that gets tokenized into rank and suite
    */
   public Card(String str)
   {
      String rast, sust;
      
      StringTokenizer tokenizer = new StringTokenizer(str,"_");
      rast = tokenizer.nextToken();
      sust = tokenizer.nextToken();

      if(sust.equals("s"))
      {
         suit = 0;
      }
      if(sust.equals("c"))
      {
         suit = 1;
      }
      if(sust.equals("h"))
      {
         suit = 2;
      }
      if(sust.equals("d"))
      {
         suit = 3;
      }
         
      
      if(rast.equalsIgnoreCase("king"))
      {
         rank = 13;
      }
      else if(rast.equalsIgnoreCase("queen"))
      {
         rank = 12;
      }
      else if(rast.equalsIgnoreCase("jack"))
      {
         rank = 11;
      }
      else if(rast.equalsIgnoreCase("ace"))
      {
         rank = 14;
      }   
      else
      {
         rank = Integer.parseInt(rast);
      }
   }      
         
   /**no args constructor
   */
   public Card()
   {
   }
   
   
   /** returns suit of card
   @return the suit of the card
   */
   public int getSuit()
   {
      return suit;
   }
   
   /** returns the rank of the card
   @return the rank of the card
   */
   public int getRank()
   {
      return rank;
   }
   
   /**returns the rank and suite in string form
   @return the string form of the rank and suite
   */
   public String toString()
   {
      String str, suitstr="", rankstr="";
         
      if (rank == ACE || rank == 14)
      {
         rankstr="ace";
      }
         
      if (rank == JACK)
      {
         rankstr="jack";
      }
         
      if (rank == QUEEN)
      {
         rankstr="queen";
      }
      if (rank == KING)
      {
         rankstr="king";
      }
      if(rank < 11 && rank > 1)
      {
         rankstr = Integer.toString(rank);
      }
      if (suit == SPADES)
      {
         suitstr = "s";
      }
      if (suit == CLUBS)
      {
         suitstr = "c";
      }
      if (suit == HEARTS)
      {
         suitstr = "h";
      }  
      if (suit == DIAMONDS)
      {
         suitstr = "d";
      } 
      str = (rankstr +"_"+ suitstr);
         
      return str;
   }
   
   /** boolean method checks if two cards ranks are equal
   @return wether or not they are equal
   */
   public boolean equals(Card object1)
   {
      boolean equal = false;
      
      if(rank == object1.rank)
      {
         equal = true;
      }
      return equal;
      
   }
}   
         
          
                        