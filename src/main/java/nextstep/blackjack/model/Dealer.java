package nextstep.blackjack.model;

import java.util.List;

public class Dealer extends Person {
	private static final String NAME = "딜러";

	@Override
	public String getName() {
		return NAME;
	}

	public boolean hasLessThanOrEqual16() {
		return getPlayingCards().sum() <= 16;
	}

	public double getEarning(List<Player> players) {
		Double playersEarning = players.stream()
			.map(player -> player.getEarning(this))
			.reduce(Double::sum)
			.get();

		return -playersEarning;
	}
}
