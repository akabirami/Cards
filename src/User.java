import java.util.ArrayList;
import java.util.Scanner;

public class User extends Player {

	public User(ArrayList<Card> cards) {
		super(cards);
		// TODO Auto-generated constructor stub
	}
	
	public String getNextBid(Card bidCard) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println(cardsInHand);
		String nextCard=s.next();
		Card card=new Card(4,13);
		for(Card c: cardsInHand){
			if(c.rank.contains(nextCard)){
				card=c;
				break;
			}
		}
		if(card.rank.equals("0")){
			System.out.println("Enter Valid Face Value Available in your deck");
			return getNextBid(bidCard);
		}
		else{
		cardsInHand.remove(card);
		return card.rank;
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
