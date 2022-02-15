package nextstep.blackjack.controller;

import java.util.List;

import nextstep.blackjack.model.Dealer;
import nextstep.blackjack.model.Deck;
import nextstep.blackjack.model.HitOrStay;
import nextstep.blackjack.model.Player;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

public class BlackjackGame {
	private final Dealer dealer;
	private final List<Player> players;
	private final Deck deck;

	public BlackjackGame() {
		dealer = new Dealer();
		players = inputPlayerNames();
		players.forEach(this::inputPlayerBetAmount);
		deck = new Deck();
	}

	public void start() {
		dealCardsFirstly();
		dealCardsAdditionally();
		printResult();
	}

	private List<Player> inputPlayerNames() {
		OutputView.printInputPlayerNames();
		return InputView.inputPlayerNames();
	}

	private void inputPlayerBetAmount(Player player) {
		OutputView.printInputPlayerBetAmount(player);
		player.decideBetAmount(InputView.inputPlayerBetAmount());
	}

	private void dealCardsFirstly() {
		deck.dealCards(dealer, 2);
		players.forEach(player -> deck.dealCards(player, 2));
		OutputView.printPlayingCards(dealer, players);
	}

	private void dealCardsAdditionally() {
		players.forEach(this::dealCardUntilStayOrBust);
		if (dealer.hasLessThanOrEqual16()) {
			OutputView.printDealCardToDealer();
			deck.dealCards(dealer, 1);
			OutputView.printPlayingCards(dealer);
		}
	}

	private void dealCardUntilStayOrBust(Player player) {
		if (player.hasBlackjack()) {
			return;
		}

		HitOrStay hitOrStay;
		do {
			OutputView.printInputPlayerHitOrStay(player);
			hitOrStay = InputView.inputPlayerHitOrStay();
			if (hitOrStay == HitOrStay.HIT) {
				deck.dealCards(player, 1);
				OutputView.printPlayingCards(player);
			}
		} while (hitOrStay == HitOrStay.HIT && !player.hasBurst());
	}

	private void printResult() {
		OutputView.printGameResult(dealer, players);
		OutputView.printFinalEarning();
		OutputView.printEarning(dealer, players);
	}
}
