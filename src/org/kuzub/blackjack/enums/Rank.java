package org.kuzub.blackjack.enums;

public enum Rank {
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(2), QUEEN(3), KING(4), ACE(11);

    private int point;

    Rank(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
