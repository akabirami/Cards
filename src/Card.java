public class Card{
    private String rank, suit;

    private static String[] suits = { "hearts", "spades", "diamonds", "clubs" };
    private static String[] ranks  = { "Ace", "2", "3", "4", "5", "6", "7", 
                   "8", "9", "10", "Jack", "Queen", "King" };

    public static String rankAsString( int __rank ) {
        return ranks[__rank];
    }

    public Card(int suit, int rank)
    {
        this.rank=ranks[rank];
        this.suit=suits[suit];
    }
   public String toString(){
	return this.rank+" Of "+this.suit;
	   
   }
    public String getRank() {
         return rank;
    }

    public String getSuit() {
        return suit;
    }
}