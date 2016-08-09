import java.util.ArrayList;

public class Pack {

	public ArrayList<Card> cards;
	
	public Pack(boolean withJoker){
		cards = new ArrayList<Card>();
		
		for (int a=0; a<4; a++)
        {
            for (int b=0; b<13; b++)
             {
               cards.add(new Card(a,b) );
             }
        }
	    if(withJoker){
	    	cards.add(new Card(4,13));
	    	cards.add(new Card(4,13));
	    }
	}
	
	public ArrayList<Card> getPack(){
		return cards;
	}
}
