package nextstep.blackjack.model;

import java.util.*;

public class Deck {
	private static final Set<Card> PLAYING_CARDS;

	static {
		PLAYING_CARDS = new HashSet<>();
		Arrays.stream(Suit.values()).forEach(
			suit -> Arrays.stream(Denomination.values()).forEach(
				denomination -> PLAYING_CARDS.add(new Card(suit, denomination))
			)
		);
	}

	private final Stack<Card> cards;

	public Deck() {
		cards = new Stack<>();
		cards.addAll(PLAYING_CARDS);
		Collections.shuffle(cards);
	}

	public void dealCards(Person person, int count) {
		List<Card> draw = new ArrayList<>();
		while (count-- > 0) {
			draw.add(cards.pop());
		}
		person.receive(draw);
	}
}
