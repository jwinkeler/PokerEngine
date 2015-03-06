public enum eSuit {
	Hearts(10),
	Diamonds(20),
	Clubs(30),
	Spades(40);
	
	private int cardSuit;
	
	private eSuit(int value){
	    this.cardSuit = value;
	  }
	 
	public int getCardSuit() {
	    return cardSuit;
	}

}
