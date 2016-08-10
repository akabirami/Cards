

import java.util.ArrayList;
import java.util.List;

public class Player {
	protected ArrayList<Card> cardsInHand;
	protected double score;
	
	Player(ArrayList<Card> cards){
		cardsInHand=new ArrayList<Card>(cards);
	}	
	
}
