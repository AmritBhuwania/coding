package cards;

import java.util.ArrayList;
import java.util.List;

public class GenerateDeck {

	public static void main(String[] args) {

		GenerateDeck generateDeck = new GenerateDeck();

		CardDeck cardDeck = generateDeck.generateCards();

		// Show/Print all cards thathave been genertaed
		System.out.println(String.format("Show all possible cards generated: [%s]", cardDeck));
		
	}

	// Generate cards
	private CardDeck generateCards() {

		Card card;

		// maximum number of cards an ideal deck will hold
		int numberOfCardsPossible = Suits.values().length * Ranks.values().length;

		List<Card> cards = new ArrayList<Card>(numberOfCardsPossible);

		CardDeck cardDeck = new CardDeck();

		try {
			for (Suits suit : Suits.values()) {
				for (Ranks rank : Ranks.values()) {
					card = new Card(suit, rank);
					cards.add(card);
				}
			}

			cardDeck.setCardDeck(cards);

			System.out.println(String.format("Number of cards generated: [%d]", cards.size()));

		} catch (Exception e) {
			System.out.println(String.format("All cards not generated successfully [%s]", e.getMessage()));
		}

		return cardDeck;
	}
}

/*
Output:
Number of cards generated: [52]
Show all possible cards generated: [CardDeck [cards=[Card [suit=CLUBS, rank=ACE],
		Card [suit=CLUBS, rank=DEUCE], Card [suit=CLUBS, rank=THREE], Card [suit=CLUBS, rank=FOUR],
		Card [suit=CLUBS, rank=FIVE], Card [suit=CLUBS, rank=SIX], Card [suit=CLUBS, rank=SEVEN],
		Card [suit=CLUBS, rank=EIGHT], Card [suit=CLUBS, rank=NINE], Card [suit=CLUBS, rank=TEN],
		Card [suit=CLUBS, rank=JACK], Card [suit=CLUBS, rank=QUEEN], Card [suit=CLUBS, rank=KING],
		Card [suit=DIAMONDS, rank=ACE], Card [suit=DIAMONDS, rank=DEUCE], Card [suit=DIAMONDS, rank=THREE],
		Card [suit=DIAMONDS, rank=FOUR], Card [suit=DIAMONDS, rank=FIVE], Card [suit=DIAMONDS, rank=SIX],
		Card [suit=DIAMONDS, rank=SEVEN], Card [suit=DIAMONDS, rank=EIGHT], Card [suit=DIAMONDS, rank=NINE],
		Card [suit=DIAMONDS, rank=TEN], Card [suit=DIAMONDS, rank=JACK], Card [suit=DIAMONDS, rank=QUEEN],
		Card [suit=DIAMONDS, rank=KING], Card [suit=HEARTS, rank=ACE], Card [suit=HEARTS, rank=DEUCE],
		Card [suit=HEARTS, rank=THREE], Card [suit=HEARTS, rank=FOUR], Card [suit=HEARTS, rank=FIVE],
		Card [suit=HEARTS, rank=SIX], Card [suit=HEARTS, rank=SEVEN], Card [suit=HEARTS, rank=EIGHT],
		Card [suit=HEARTS, rank=NINE], Card [suit=HEARTS, rank=TEN], Card [suit=HEARTS, rank=JACK],
		Card [suit=HEARTS, rank=QUEEN], Card [suit=HEARTS, rank=KING], Card [suit=SPADES, rank=ACE],
		Card [suit=SPADES, rank=DEUCE], Card [suit=SPADES, rank=THREE], Card [suit=SPADES, rank=FOUR],
		Card [suit=SPADES, rank=FIVE], Card [suit=SPADES, rank=SIX], Card [suit=SPADES, rank=SEVEN],
		Card [suit=SPADES, rank=EIGHT], Card [suit=SPADES, rank=NINE], Card [suit=SPADES, rank=TEN],
		Card [suit=SPADES, rank=JACK], Card [suit=SPADES, rank=QUEEN], Card [suit=SPADES, rank=KING]]]]

 */
