import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
public class Deck {
  
 
   private static ArrayList<Card> cards;
   private static ArrayList<Card> deck;

   
   public Deck(int numberOfPacks,boolean withJoker)
   {
	   Set<Card> set=new HashSet<Card>();
	   for(int i=0;i<numberOfPacks;i++)
	   {
		   Pack p=new Pack(withJoker);
		   set.addAll(p.getPack());
	   }
	   cards=new ArrayList<Card>(set);
	   shuffle();
   }
	
   public void shuffle(){
	 Collections.shuffle(this.cards); 
   }
     
   public ArrayList<Card> makeDeck(int x)
   {       
	   deck=new ArrayList<Card>();
       for(int i=0;i<x;i++)
       {
       	deck.add(cards.get(i));
       }
       return deck;
       
   }
   
    public Card drawFromDeck()
    {       
        return deck.remove( 0 );
    }

    public int getTotalCards()
    {
        return deck.size();
        //we could use this method when making 
        //a complete poker game to see if we needed a new deck
    }
    
    public static void printDeck(){
    	for(Card c:deck){
    		System.out.println(c);
    	}
    }
}