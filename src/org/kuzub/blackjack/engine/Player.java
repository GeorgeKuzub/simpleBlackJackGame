package org.kuzub.blackjack.engine;

import java.util.Arrays;

public class Player implements Comparable<Player> {
    private String name;
    private Card[] pocketCards = new Card[Deck.TOTAL_CARDS];
    private int countPocketCards = 0;
    private Strategy strategy;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public void takeCard(Deck deck) {
        Card pulledCard = deck.pull();

        pocketCards[countPocketCards++] = pulledCard;
    }

    public void dropPocketCards(Deck deck) {
        deck.mergePocketCards(pocketCards);
        clearHand();
    }

    private void clearHand() {
        Arrays.fill(pocketCards, null);
        countPocketCards = 0;
    }

    public int getValuePocketCards() {
        int sum = 0;
        for (Card card : pocketCards) {
            if (card == null) {
                break;
            }

            sum += card.getPoint();
        }
        return sum;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return  name.equalsIgnoreCase(player.name) ? true : false;
    }


    @Override
    public int compareTo(Player p) {
        return this.name.compareTo(p.name);
    }
}
