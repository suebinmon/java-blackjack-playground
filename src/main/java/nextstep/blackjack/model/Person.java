package nextstep.blackjack.model;

import java.util.List;

public abstract class Person {
    private final PlayingCards playingCards;

    public Person() {
        this.playingCards = new PlayingCards();
    }

    protected void receive(List<Card> playingCards) {
        this.playingCards.addAll(playingCards);
    }

    public abstract String getName();

    public PlayingCards getPlayingCards() {
        return playingCards;
    }

    public boolean hasBlackjack() {
        return playingCards.isBlackjack();
    }

    public boolean hasBurst() {
        return playingCards.isBurst();
    }

    public int getSum() {
        return playingCards.sum();
    }

    public String getResultStr() {
        if (hasBlackjack()) {
            return "블랙잭";
        }

        if (hasBurst()) {
            return "버스트";
        }

        return String.valueOf(getSum());
    }
}
