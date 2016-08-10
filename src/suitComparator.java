import java.util.Comparator; 

public class suitComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Card c1=(Card) o1;
		Card c2=(Card) o2;
		if(c1.getSuitIndex()==c2.getSuitIndex())
		   return 0;
		else if(c1.getSuitIndex() > c2.getSuitIndex())
		  return 1;
		else
		  return -1;
	}

}
