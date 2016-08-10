import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.html.HTMLDocument.Iterator;


public class Hand {
	static ArrayList<Card> inHand = new ArrayList<Card>();
	public static int POKER_HAND=5;
	public static void Play(int ch, Deck d) {
		if (ch == 1) {
			inHand = d.makeDeck(POKER_HAND);
			d.printDeck();
			pokerEvaluate(inHand);
		}
		//		if (ch == 2) {
		//			inHand = d.makeDeck(13);
		//			d.printDeck();
		//			// rummyEvaluate(inHand);
		//		}
		//		if (ch == 3) {
		//			inHand = d.makeDeck(13);
		//			d.printDeck();
		//			// heartEvaluate(inHand);
		//		}
	}

	public static void pokerEvaluate(ArrayList<Card> deck) {
		int i;
		boolean straight = true;
		String[] EvalString = { "", "It's a pair!", "It's 2 pairs", "Three of a Kind!", "Straight!!", "Flush!",
				"Full House!", " Four of a kind", "Straight Flush", "Five of a kind", "Royal Flush" };
		int[] rankOfHand = new int[13], evaluateHand = new int[11], suitOfHand = new int[4];
		for (i = 0; i < 5; i++) {
			rankOfHand[deck.get(i).getRankIndex()]++;
			suitOfHand[deck.get(i).getSuitIndex()]++;
		}
		for (i = 0; i < 13; i++) {

			if (rankOfHand[i] == 2 && evaluateHand[1] == 1)
				evaluateHand[2] = 1;
			else if (rankOfHand[i] == 2 && evaluateHand[3] == 1)
				evaluateHand[5] = 1;
			else if (rankOfHand[i] == 2)
				evaluateHand[1] = 1;
			if (rankOfHand[i] == 3 && evaluateHand[1] == 1)
				evaluateHand[6] = 1;
			else if (rankOfHand[i] == 3)
				evaluateHand[3] = 1;
			if (rankOfHand[i] == 4)
				evaluateHand[7] = 1;
			if (rankOfHand[i] == 5)
				evaluateHand[9] = 1;
			if (i < 4 && suitOfHand[i] == 5)
				evaluateHand[5] = 1;
		}

		int firstIndex = 0, lastIndex = 0;
		for (int j = 0; j < rankOfHand.length; j++) {
			if (rankOfHand[j] == 1) {
				firstIndex = j;
				break;
			}
		}

		if (firstIndex > 9)
			straight = false;
		else {
			if (firstIndex == 0 && rankOfHand[12] == 1) {
				firstIndex = 9;
				lastIndex = 12;
			} else
				lastIndex = firstIndex + 5;

			for (i = firstIndex; i < lastIndex; i++)
				if (rankOfHand[i] != 1)
					straight = false;
		}
		if (straight == true && evaluateHand[5] == 1 && firstIndex == 9 && lastIndex == 12)
			evaluateHand[10] = 1;
		else if (straight == true && evaluateHand[5] == 1)
			evaluateHand[8] = 1;
		else if (straight == true)
			evaluateHand[4] = 1;
		for (i = 10; i >= 0; i--) {
			if (i == 0) {
				System.out.println("Highest Card is : " + (getHighest(deck)));
			}
			if (evaluateHand[i] == 1) {
				System.out.println(EvalString[i]);
				break;
			}
		}
	}

	static String getHighest(ArrayList<Card> deck) {
		String[] Face = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		int i, max = -999;
		for (i = 0; i < deck.size(); i++) {
			if (deck.get(i).getRankIndex() > max && max != 0)
				max = deck.get(i).getRankIndex();
			if (deck.get(i).getRankIndex() == 0)
				max = deck.get(i).getRankIndex();
		}
		return Face[max];
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("1. Poker Hand Evaluation ");
		System.out.println("2. Rummy Hand Assessment");
		System.out.println("3. Playing Hearts");
		System.out.println("Enter your choice ?");
		int ch = in.nextInt();
		System.out.println("Number of packs to be used ?");
		int packs = in.nextInt();
		System.out.println("Number of Jokers:");
		int joker = in.nextInt();

		Deck d = new Deck(packs, joker);

		Play(ch, d);

//		System.out.println("\nSorting by Rank...");
//		ArrayList<Card> c=d.getDeck();
//		c.sort(new Comparator<Card>(){
//
//			@Override
//			public int compare(Card o1, Card o2) {
//				// TODO Auto-generated method stub
//				Card c1=(Card) o1;
//				Card c2=(Card) o2;
//				if(c1.getRankIndex()==c2.getRankIndex())
//					return 0;
//				else if(c1.getRankIndex() > c2.getRankIndex())
//					return 1;
//				else
//					return -1;
//
//			}
//
//		});
//		d.printDeck();

		// System.out.println("\nSorting by Suit..");
		// ArrayList<Card> c1=d.getDeck();
		// Collections.sort(c1,new suitComparator());
		// d.printDeck();

	}

}
