public class Card {
	private eCardValue value;
	private eSuit suit;
	
	/*private Card(){
	}*/
	
	
	public Card(eSuit suit, eCardValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	public eSuit getSuit() {
		return this.suit;
	}
	
	public eCardValue getValue() {
		return this.value;
	}

}
