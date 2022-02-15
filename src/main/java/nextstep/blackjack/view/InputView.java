package nextstep.blackjack.view;

import nextstep.blackjack.model.HitOrStay;
import nextstep.blackjack.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> inputPlayerNames() {
        String input = scanner.next();
        return inputPlayerNames(input);
    }

    public static List<Player> inputPlayerNames(String input) {
        List<Player> players = new ArrayList<>();
        Stream.of(input.split(",")).forEach(name -> players.add(new Player(name)));
        return players;
    }

    public static int inputPlayerBetAmount() {
        String input = scanner.next();
        return inputPlayerBetAmount(input);
    }

    public static int inputPlayerBetAmount(String input) {
        return Integer.parseInt(input);
    }

    public static HitOrStay inputPlayerHitOrStay() {
        String input = scanner.next();
        return inputPlayerHitOrStay(input);
    }

    public static HitOrStay inputPlayerHitOrStay(String input) {
        return HitOrStay.findBy(input);
    }
}
