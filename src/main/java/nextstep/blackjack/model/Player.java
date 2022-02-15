package nextstep.blackjack.model;

public class Player extends Person {
	private final String name;
	private Integer betAmount;

	public Player(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void decideBetAmount(int betAmount) {
		this.betAmount = betAmount;
	}

	public int getBetAmount() {
		return betAmount;
	}

	public double getEarning(Dealer dealer) {
		if (hasBlackjack() && !dealer.hasBlackjack()) {
			return betAmount * 1.5;
		}

		if (hasBlackjack() && dealer.hasBlackjack()) {
			return 0;
		}

		if (dealer.hasBurst()) {
			return betAmount;
		}

		if (hasBurst()) {
			return -betAmount;
		}

		if (getSum() == dealer.getSum()) {
			return 0;
		}

		if (getSum() > dealer.getSum()) {
			return betAmount;
		}

		return -betAmount;
	}
}
