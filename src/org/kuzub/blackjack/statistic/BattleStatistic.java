package org.kuzub.blackjack.statistic;

import org.kuzub.blackjack.engine.Player;
import org.kuzub.blackjack.engine.Table;

public class BattleStatistic {
    private Table table;
    private Player[] winners;
    private int[] points;
    private int counterWinner;

    public BattleStatistic(Table table) {
        this.table = table;
        winners = new Player[table.TOTAL_PLAYERS];
        points = new int[table.TOTAL_PLAYERS];
    }

    public Table getTable() {
        return table;
    }

    public void addWinner(Player plr) {
        for (int i = 0; i < winners.length; i++) {
            if (plr.equals(winners[i])) {
                points[i]++;
                return;
            }
        }
        winners[counterWinner] = plr;
        points[counterWinner] = 1;
        counterWinner++;
    }

    public Player[] getWinners() {
        return winners;
    }

    public int[] getPoints() {
        return points;
    }
}
