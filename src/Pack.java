import java.util.ArrayList;

public class Pack {

	public ArrayList<Card> cards;
	
	public Pack(int joker){
		cards = new ArrayList<Card>();
		
		for (int a=0; a<4; a++)
        {
            for (int b=0; b<13; b++)
             {
               cards.add(new Card(a,b) );
             }
        }
		int i=0;
	    while(i<joker){
	    	cards.add(new Card(4,13));
	    	i++;
	    }
	}
	
	public ArrayList<Card> getPack(){
		return cards;
	}
}
