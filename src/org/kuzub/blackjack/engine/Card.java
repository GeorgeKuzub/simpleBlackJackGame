package org.kuzub.blackjack.engine;

import org.kuzub.blackjack.enums.Rank;
import org.kuzub.blackjack.enums.Suit;

public final class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return rank == card.rank;
    }

    public int getPoint() {
        return rank.getPoint();
    }
}
