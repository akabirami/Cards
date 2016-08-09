import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Hand {
	static ArrayList<Card> inHand=new ArrayList<Card>();
	public static void Play(int ch,Deck d)
	{
		if(ch==1)
		{
			inHand=d.makeDeck(5);
			d.printDeck();
			pokerEvaluate(inHand);
		}
		if(ch==2)
		{
			inHand=d.makeDeck(13);
			d.printDeck();
			//rummyEvaluate(inHand);
		}
		if(ch==3)
		{
			inHand=d.makeDeck(13);
			d.printDeck();
			//heartEvaluate(inHand);
		}
	}
	
	
	public static void rummyEvaluate(ArrayList<Card> deck){
	    
	    //sort(inHand);
		//boolean run=isRun();
	    //boolean set=isSet();
	}
	
	public static void pokerEvaluate(ArrayList<Card> deck)
	{
		int i;
		boolean straight=true;
		String[] EvalString={"Highest Card is : ", "It's a pair!", "It's 2 pairs", "Three of a Kind!", "Straight!!", "Flush!", "Full House!", " Four of a kind", "Straight Flush", "Five of a kind"};
		int[] Ranks=new int[13],Eval=new int[10],SuitFreq=new int[4];
		for(i=0;i<5;i++)
		{
			Ranks[deck.get(i).getRankIndex()]++;
			SuitFreq[deck.get(i).getSuitIndex()]++;
		}
		for(i=0;i<13;i++)
		{
			
			if(Ranks[i]==2 && Eval[1]==1)
				Eval[2]=1;
			else if(Ranks[i]==2 && Eval[3]==1)
				Eval[5]=1;
			else if(Ranks[i]==2)
				Eval[1]=1;
			if(Ranks[i]==3 && Eval[1]==1)
				Eval[6]=1;
			else if(Ranks[i]==3)
				Eval[3]=1;
			if(Ranks[i]==4)
				Eval[7]=1;
			if(Ranks[i]==5)
				Eval[9]=1;
			if(i<4 && SuitFreq[i]==5)
				Eval[5]=1;
		}
		
		int index=0;
		for(int j=0;j<Ranks.length;j++){
			if(Ranks[j]==1){
				index=i;
				break;
			}
		}
		
		if(index>8)
			straight=false;
		else
		{
			for(i=index;i<=index+5;i++)
				if(Ranks[i]!=1)
					straight=false;
		}
		if(straight==true && Eval[5]==1)
			Eval[8]=1;
		else if(straight==true)
			Eval[4]=1;
		for(i=9;i>=0;i--)
		{
			if(i==0)
			{
				System.out.println("Highest Card is : "+(getHighest(deck)+1));
			}
			if(Eval[i]==1)
			{
				System.out.println(EvalString[i]);break;
			}
		}
	}
	
	static int getHighest(ArrayList<Card> deck)
	{
		int i,max=-999;
		for(i=0;i<deck.size();i++)
		{
			if(deck.get(i).getRankIndex()>max)
				max=deck.get(i).getRankIndex();
		}
		return max;
	}


	public static void main(String[] args)
	{
		
		Scanner in=new Scanner(System.in);
		System.out.println("1. Poker Hand Evaluation ");
		System.out.println("2. Rummy Hand Assessment");
		System.out.println("3. Playing Hearts");
		System.out.println("Enter your choice ?");
		int ch=in.nextInt();
		System.out.println("Number of packs to be used ?");
		int packs=in.nextInt();
		System.out.println("Jokers to be included ? Y/N");
		String joker=in.next();
		
		Deck d=new Deck(packs,joker.equalsIgnoreCase("y"));
		
		Play(ch,d);
	
		
	}
	
}
