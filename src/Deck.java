
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class Deck {

	private UUID DeckNbr;
	private ArrayList<Card> DeckCards = new ArrayList<Card>(); 
	
	public  Deck() {
		this.DeckNbr = UUID.randomUUID();
		for(int i = 0; i < 4; i++) {
			eSuit suit = eSuit.values()[i];
			for(int j = 0; j < 14; j++) {
				eCardValue value = eCardValue.values()[j];
				DeckCards.add(new Card(suit, value));
			}
		}
	     Collections.shuffle(DeckCards);
	}
	
	
	public Card draw() {
		Card c = DeckCards.get(0);
		DeckCards.remove(c);
		return c;
	}
	
	public int numCards() {
		return DeckCards.size();
	}
}
	
