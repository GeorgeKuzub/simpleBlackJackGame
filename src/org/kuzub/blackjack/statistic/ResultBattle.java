package org.kuzub.blackjack.statistic;

import org.kuzub.blackjack.engine.Player;
import org.kuzub.blackjack.engine.Table;

import java.util.Arrays;


public class ResultBattle {
    private Player[] winners;
    private int[] points;
    private Table table;
    public ResultBattle(Table table, Player[] winners, int[] points) {
        this.table = table;
        this.winners = winners;
        this.points = points;
    }

    public void showWinners() {
        System.out.println(table.getTableName() + " : ");

        Arrays.sort(winners);
        for (int i = 0; i < winners.length; i++) {
            System.out.print(winners[i] + " -  ");
            System.out.print(points[i]);
            System.out.println();
        }
    }
}
