import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

	private Deck deck = new Deck();
	private ArrayList<Card> hand = new ArrayList<Card>();

	protected Hand() {
		for(int i = 0; i < 5; i++) {
			hand.add(deck.draw());
		}	
	}
	protected Hand(ArrayList<Card> cards){
		hand = cards; 
	}
	public ArrayList <Card> getCards(){
		return this.hand;
	}
    public ArrayList<Card> sort(ArrayList<Card> myHand) {
        int i = 0;
        while (i < 4) {
            Card small = myHand.get(i);
            eCardValue smallv = small.getValue();
            int j = 0;
            while ((j >= i) && (j < 4)) {
                Card c1 = myHand.get(j);
                eCardValue v1 = c1.getValue();
                Card temp = small;
                if (smallv.getCardValue() > v1.getCardValue()) {
                    small = c1;
                    c1 = temp;
                }
                j++;
            }
            i++;
        }

        return myHand;
    }
	public boolean isRoyalFlush(){
		return isRoyalFlush(this);
	}
	public boolean isRoyalFlush(Hand myHand) {
		ArrayList<Card> cards = sort(myHand.getCards());
		int i = 0;
		Card c0 = cards.get(0);
		eCardValue jack = eCardValue.values()[9];
		if (c0.getValue() == jack) {
			while (i < 4) {
				Card c1 = cards.get(i);
				Card c2 = cards.get(i + 1);
				if (c1.getSuit() == c2.getSuit())
					continue;
			}
		} else
			return false;
		return true;
	}
	public boolean isStraightFlush(){
		return isStraightFlush(this);
	}
	public boolean isStraightFlush(Hand myHand) {
		ArrayList<Card> cards = sort(myHand.getCards());
		int i = 0;
		while (i < 4) {
			Card c1 = cards.get(i);
			Card c2 = cards.get(i + 1);
			if ((c1.getValue() == c2.getValue()) 
					&& c1.getSuit() == c2.getSuit()) {
				i++;
			}
			else {

				return false;
			}
		}
		return true;
	}
	private Card getHighStraightFlush(){
		ArrayList<Card> cards = sort(this.getCards());
		return cards.get(4);
	}
	public boolean isFourofaKind(){
		return isFourofaKind(this);
	}
	public boolean isFourofaKind(Hand myHand) {
		ArrayList<Card> cards = sort(myHand.getCards());
		Card c1 = cards.get(0);
		Card c2 = cards.get(1);
		Card c4 = cards.get(3);
		Card c5 = cards.get(4);
		if ((c1.getValue() == c4.getValue())
				|| (c2.getValue() == c5.getValue())) {
			return true;
		} else
			return false;
	}
	private Card getHighFourOfAKind(){
		ArrayList<Card> cards = sort(this.getCards());
		return cards.get(2);
	}
	public eHandStrength getHandStrength(){
		return getHandStrength(this);
	}
	public eHandStrength getHandStrength(Hand myHand) {
		if(isRoyalFlush(myHand)) {
			return eHandStrength.values()[0];
		}
		else if(isStraightFlush(myHand)) {
			return eHandStrength.values()[1];
		}
		else if(isFourofaKind(myHand)) {
			return eHandStrength.values()[2];
		}
		else {
			return eHandStrength.values()[9];
			// for right now, it's just returning the eHandStrength value for no pairs, because we aren't yet testing for the other hand strengths
		}
	}
	public boolean isMyHandStronger (Hand otherHand){
		eHandStrength myStrength = this.getHandStrength();
		eHandStrength otherStrength = getHandStrength(otherHand);
		int difference = myStrength.getStrength()-otherStrength.getStrength();
		if (difference>0){
			return true;
		}
		else if (difference<0){
			return false;
		}
		else{
			switch (myStrength){ 
			case RoyalFlush:
				break;
			case StraightFlush: 
			{
				Card myHigh = this.getHighStraightFlush();
				Card otherHigh = otherHand.getHighStraightFlush();
				int valueDifference = myHigh.getValue().getCardValue() - otherHigh.getValue().getCardValue();
				if (valueDifference > 0){
					return true;					
				}
				else if (valueDifference <0){
					return false;
				}
				break;
			}
			case FourOfAKind:
			{
				Card myHigh = this.getHighFourOfAKind();
				Card otherHigh = otherHand.getHighFourOfAKind();
				if (myHigh.getValue().getCardValue() > otherHigh.getValue().getCardValue()){
					return true;					
				}
				else {
					return false;
				}
			}
			default:
				break;
			}
			System.out.println("Hands are of equal strength!");
			return true;
		}
	}


}
