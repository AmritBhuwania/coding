package cards;

import java.util.List;

public class CardDeck {

	private List<Card> cards;

	public CardDeck() {}

	public CardDeck(List<Card> cards) {
		super();
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCardDeck(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "CardDeck [cards=" + cards + "]";
	}

}
