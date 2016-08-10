public class Card{
    String rank;

	String suit;

    private static String[] suits = { "hearts", "spades", "diamonds", "clubs","joker" };
    private static String[] ranks  = { "Ace", "2", "3", "4", "5", "6", "7", 
                   "8", "9", "10", "Jack", "Queen", "King" ,"0"};

    public static String rankAsString( int __rank ) {
        return ranks[__rank];
    }

    public Card(int suit, int rank)
    {
        this.rank=ranks[rank];
        this.suit=suits[suit];
    }
   public String toString(){
	   if(this.getRankIndex()!=13)
		return this.rank+" Of "+this.suit;
	   else
		 return this.suit;	
   }
    
   public String getRank() {
         return rank;
    }

   public int getRankIndex(){
	 int index = -1;
	  for (int i=0;i<ranks.length;i++) {
	      if (ranks[i].equals(this.rank)) {
	           index = i;
	           break;
	       }
	  }
	  return index;
   }
    public String getSuit() {
        return suit;
    }
    
    public int getSuitIndex(){
   	 int index = -1;
   	  for (int i=0;i<suits.length;i++) {
   	      if (suits[i].equals(this.suit)) {
   	           index = i;
   	           break;
   	       }
   	  }
   	  return index;
      }
}