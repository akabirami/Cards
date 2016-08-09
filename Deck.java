import java.util.Random;
import java.util.ArrayList;
public class Deck {
   private ArrayList<Card> cards;
	private ArrayList<Card> deck;
	    Deck()
	    {
	    	int index_1, index_2;
	    cards = new ArrayList<Card>();
        Random generator = new Random();
        Card temp;

        for (int a=1; a<=4; a++)
        {
            for (int b=1; b<=13; b++)
             {
               cards.add(new Card(a,b) );
             }
        }
	    int size;       

        for (int i=0; i<100; i++)
        {
            index_1 = generator.nextInt( cards.size() - 1 );
            index_2 = generator.nextInt( cards.size() - 1 );

            temp = cards.get( index_2 );
            cards.set( index_2 , cards.get( index_1 ) );
            cards.set( index_1, temp );
        }
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
}