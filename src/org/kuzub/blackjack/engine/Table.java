package org.kuzub.blackjack.engine;

import org.kuzub.blackjack.statistic.BattleStatistic;
import org.kuzub.blackjack.statistic.StatisticService;

public class Table {
    public final int TOTAL_PLAYERS;
    private final int TOTAL_ROUNDS = 1000;
    private final int WIN_21 = 21;
    private final int MAX_VALUE = 210; //total value of all cards

    private String tableName;
    private Deck deck;
    private Player[] players;
    private BattleStatistic battleStatistic;

    public Table(String name, Player[] players) {
        this.tableName = name;
        deck = new Deck();
        this.players = players;


        TOTAL_PLAYERS = players.length;
        battleStatistic = new BattleStatistic(this);
    }

    private void preparation() {
        for (Player plr : players) {
            plr.dropPocketCards(deck);
        }
        deck.shuffle();
    }

    public void battle() {
        int countRounds = 0;
        do {
            if (!startRound()) {
                countRounds--;
            }
        } while (++countRounds != TOTAL_ROUNDS);
        StatisticService.getInstance().set(battleStatistic);
    }

    private boolean startRound() {
        preparation();

        for (Player plr : players) {
            do {
                plr.takeCard(deck);
            } while (!plr.getStrategy().hasEnoughValue(plr.getValuePocketCards()));
        }

        Player winner = detectWinner();
        if (winner == null) {
            return false;
        } else {
            battleStatistic.addWinner(winner);
            return true;
        }
    }

    public String getTableName() {
        return tableName;
    }

    /**
     * Returns the a player in case the winner is detected uniquely.
     * In all other cases, when players have the same pocket's value the most
     * nearest to 21 number, returns null.
     *
     * @return the winner player of the current round;
     */
    private Player detectWinner() {
        int max = 0;
        int min = MAX_VALUE + 1;
        int counterWinners = 0;
        int counterLosers = 0;
        int counterChallengers = 0;

        Player winner = null;
        Player[] losers = new Player[TOTAL_PLAYERS];
        Player[] challengers = new Player[TOTAL_PLAYERS];

        for (Player plr : players) {
            int pocketValue = plr.getValuePocketCards();

            if (pocketValue == WIN_21) {
                if (winner == null) {
                    winner = plr;
                } else {
                    return null; // it means draw for current round since we have several winners
                }
            }

            // Next filtering players by principe who's getting more or less than 21.
            if (pocketValue > WIN_21) {
                losers[counterLosers++] = plr;
            }

            if (pocketValue < WIN_21) {
                challengers[counterChallengers++] = plr;
            }
        }

        if (counterChallengers == 1) {
            return challengers[0];
        }

        if (counterChallengers > 1) {

            for (Player challenger : challengers) {
                if (challenger == null) {
                    break;
                }

                int pocketValue = challenger.getValuePocketCards();

                if (pocketValue > max) {
                    max = pocketValue;
                    winner = challenger;
                    counterWinners = 1;
                    continue;
                }

                if (pocketValue == max) {
                    counterWinners++;
                }

            }

        } else if (counterLosers > 0) {

            for (Player plr : losers) {
                if (plr == null) {
                    break;
                }

                int pocketValue = plr.getValuePocketCards();

                if (pocketValue < MAX_VALUE) {
                    min = pocketValue;
                    winner = plr;
                    counterWinners = 1;
                    continue;
                }

                if (pocketValue == min) {
                    counterWinners++;
                }

            }
        }

        return counterWinners == 1 ? winner : null;
    }

}
