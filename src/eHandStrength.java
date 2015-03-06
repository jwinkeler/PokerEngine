public enum eHandStrength {
	RoyalFlush(10),
	StraightFlush(9),
	FourOfAKind(8),
	FullHouse(7),
	Flush(6),
	Straight(5),
	ThreeOfAKind(4),
	TwoPair(3),
	OnePair(2),
	NoPair(1);
	
	private int HandStrength;
	
	private eHandStrength(int strength) {
		this.HandStrength = strength;
	}
	
	public int getStrength() {
		return HandStrength;
	}

}
