package nextstep.blackjack.model;

public enum Denomination {
    ACE(1, "1"),
    TWO(2,"2"),
    THREE(3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"10"),
    JACK(10,"J"),
    QUEEN(10,"Q"),
    KING(10,"K");

    private final int value;
    private final String name;

    Denomination(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
