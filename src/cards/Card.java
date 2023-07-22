package cards;

// We can use lombok library to remove the boiler plate code
public class Card {
	
	private Suits suit;
	private Ranks rank;
	
	public Card() {}
	
	public Card(Suits suit, Ranks rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	public Suits getSuit() {
		return suit;
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	public Ranks getRank() {
		return rank;
	}

	public void setRank(Ranks rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}
	

}
