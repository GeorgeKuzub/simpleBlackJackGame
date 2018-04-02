package org.kuzub.blackjack.engine;

import org.kuzub.blackjack.enums.Rank;
import org.kuzub.blackjack.enums.Suit;

import java.util.Random;

public class Deck {
    static final int TOTAL_CARDS = 32;

    private Card[] cards = new Card[]{
            new Card(Suit.CLUBS, Rank.ACE),
            new Card(Suit.DIAMONDS, Rank.ACE),
            new Card(Suit.SPADES, Rank.ACE ),
            new Card(Suit.HURTS, Rank.ACE ),

            new Card(Suit.CLUBS, Rank.KING ),
            new Card(Suit.DIAMONDS, Rank.KING ),
            new Card(Suit.SPADES, Rank.KING ),
            new Card(Suit.HURTS, Rank.KING ),

            new Card(Suit.CLUBS, Rank.QUEEN ),
            new Card(Suit.DIAMONDS, Rank.QUEEN ),
            new Card(Suit.SPADES, Rank.QUEEN ),
            new Card(Suit.HURTS, Rank.QUEEN ),

            new Card(Suit.CLUBS, Rank.JACK ),
            new Card(Suit.DIAMONDS, Rank.JACK ),
            new Card(Suit.SPADES, Rank.JACK ),
            new Card(Suit.HURTS, Rank.JACK ),

            new Card(Suit.CLUBS, Rank.TEN),
            new Card(Suit.DIAMONDS, Rank.TEN),
            new Card(Suit.SPADES, Rank.TEN),
            new Card(Suit.HURTS, Rank.TEN),

            new Card(Suit.CLUBS, Rank.NINE),
            new Card(Suit.DIAMONDS, Rank.NINE),
            new Card(Suit.SPADES, Rank.NINE),
            new Card(Suit.HURTS, Rank.NINE),

            new Card(Suit.CLUBS, Rank.EIGHT),
            new Card(Suit.DIAMONDS, Rank.EIGHT),
            new Card(Suit.SPADES, Rank.EIGHT),
            new Card(Suit.HURTS, Rank.EIGHT),

            new Card(Suit.CLUBS, Rank.SEVEN),
            new Card(Suit.DIAMONDS, Rank.SEVEN),
            new Card(Suit.SPADES, Rank.SEVEN),
            new Card(Suit.HURTS, Rank.SEVEN),
    };

    private int indexTopCard = TOTAL_CARDS - 1;

    public void shuffle() {
        Random randomizer = new Random();
        int randRange = TOTAL_CARDS - 1;
        do {
            int randInt = randomizer.nextInt(randRange);
            if (randInt != randRange) {
                swap(randInt, randRange);
            }
            randRange--;
        } while (randRange != 1);
    }

    public Card pull() {
        Card pulledCard = cards[indexTopCard];
        cards[indexTopCard] = null;
        indexTopCard--;
        return pulledCard;
    }

    private void swap(int randInt, int randRange) {
        Card tmp = cards[randInt];
        cards[randInt] = cards[randRange];
        cards[randRange] = tmp;
    }

    public void mergePocketCards(Card[] pocketCards) {
        for (Card crd : pocketCards) {
            if (crd == null) break;

            cards[++indexTopCard] = crd;
        }
    }
}
