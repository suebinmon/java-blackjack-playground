package nextstep.blackjack.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlayingCards {
	private final List<Card> playingCards;

	public PlayingCards() {
		this.playingCards = new ArrayList<>();
	}

	public void addAll(List<Card> playingCards) {
		this.playingCards.addAll(playingCards);
	}

	@Override
	public String toString() {
		return playingCards.stream()
			.map(Object::toString)
			.collect(Collectors.joining(", "));
	}

	public boolean contains(Card card) {
		return playingCards.contains(card);
	}

	public int size() {
		return playingCards.size();
	}

	public boolean isBlackjack() {
		if (playingCards.size() != 2) {
			return false;
		}

		List<Card> playingCards = new ArrayList<>(this.playingCards);
		playingCards.sort(Comparator.comparingInt(o -> o.getDenomination().getValue()));

		Card first = playingCards.get(0);
		Card second = playingCards.get(1);

		return first.isAce() && second.isKqj();
	}

	public int sum() {
		return playingCards.stream()
			.map(Card::getDenomination)
			.map(Denomination::getValue)
			.reduce(Integer::sum)
			.get();
	}

	public boolean isBurst() {
		return sum() > 21;
	}
}
