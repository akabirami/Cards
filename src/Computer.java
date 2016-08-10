import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Computer extends Player{

	public Computer(ArrayList<Card> cards) {
		super(cards);

		// TODO Auto-generated constructor stub
	}

	public String getNextBid(Card bidCard) {
		// TODO Auto-generated method stub

		int rank=getValue(bidCard.rank);
		int min=rank/2;
		Card nextCard;
 
		for(int i=1;i<cardsInHand.size();i++)
		{
			if(getValue(cardsInHand.get(i).rank) >rank)
			{	
				nextCard=cardsInHand.get(i);
				cardsInHand.remove(i);
				return nextCard.rank;
			}
		}
		
		if(getValue(cardsInHand.get(0).rank) >rank)
		{	
			nextCard=cardsInHand.get(0);
			cardsInHand.remove(0);
			return nextCard.rank;
		}
		
		nextCard=cardsInHand.get(cardsInHand.size()-1);
		return nextCard.rank;	 
	}
		
//        int index=rank;
//        nextCard=getNextCard(index);
//        if(!nextCard.rank.equals("0")){
//			cardsInHand.remove(nextCard);
//			return nextCard.rank;
//		}
//
//        
//		index =min+((int)Math.random()*(rank-min));
//		nextCard=getNextCard(index);
//
//		if(!nextCard.rank.equals("0")){
//			cardsInHand.remove(nextCard);
//			return nextCard.rank;
//		}
//
//		for(int i=min;i<=rank;i++){
//			nextCard=getNextCard(i);
//			if(!nextCard.rank.equals("0")){
//				cardsInHand.remove(nextCard);
//				return nextCard.rank;
//			}
//		}
//
//		for(int i=0;i<min;i++){
//			nextCard=getNextCard(i);
//			if(!nextCard.rank.equals("0")){
//				cardsInHand.remove(nextCard);
//				return nextCard.rank;
//			}
//		}
//		 nextCard=cardsInHand.get(0);
//		 cardsInHand.remove(nextCard);
//		 return nextCard.rank;
//	}
//	
//	public Card getNextCard(int index){
//		Card nextCard=new Card(4,13);
//		for(Card c:cardsInHand){
//			if(getValue(c.rank)==index)
//			{
//				nextCard=c;		
//				return nextCard;
//			}
//		}
//		return nextCard;
//	}
//	
	private int getValue(String bid) {
		// TODO Auto-generated method stub
		switch(bid){

		case "King" : return 13;
		case "Queen" :return 12;
		case "Jack" : return 13;
		case  "Ace" : return 14;
		default: return Integer.parseInt(bid);  
		}
	}	

	public void updateScore(double d) {
		// TODO Auto-generated method stub
		score+=d;	
	}
	public double getScore(){
		return score;
	}
}
