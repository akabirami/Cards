import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
public class Deck {
  
 
   private static ArrayList<Card> cards;
   private static ArrayList<Card> deck;

   
   public Deck(int numberOfPacks,int joker)
   {
	   Set<Card> set=new HashSet<Card>();
	   for(int i=0;i<numberOfPacks;i++)
	   {
		   Pack p=new Pack(joker);
		   set.addAll(p.getPack());
	   }
	   cards=new ArrayList<Card>(set);
	   shuffle();
   }
	
   public void shuffle(){
	 Collections.shuffle(this.cards); 
//	 cards.get(0).rank="Ace";
//	 cards.get(0).suit="hearts";
//	 cards.get(1).rank="Queen";
//	 cards.get(1).suit="hearts";
//	 cards.get(2).rank="King";
//	 cards.get(2).suit="hearts";
//	 cards.get(3).rank="Jack";
//	 cards.get(3).suit="hearts";
//	 cards.get(4).rank="10";
//	 cards.get(4).suit="hearts";

	 
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
   
   public ArrayList<Card> getDeck(){
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