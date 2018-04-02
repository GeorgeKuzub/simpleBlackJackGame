package org.kuzub.blackjack.engine;

import org.kuzub.blackjack.engine.strategies.*;
import org.kuzub.blackjack.statistic.ResultBattle;
import org.kuzub.blackjack.statistic.StatisticService;

public class Game {
    StatisticService statisticService = StatisticService.getInstance();

    public static void startBattle() {
        Player[] players = {
                new Player("PussyPlayer", new PussyStrategy()),
                new Player("Pessimist", new PessimistStrategy()),
                new Player("Optimist", new OptimisticStrategy()),
                new Player("Realist", new RealisticStrategy()),
                new Player("RiskyPlayer", new RiskyStrategy()),
                new Player("DumbPlayer", new DumbStrategy()),
//                new Player("MisterIncognito",
//                        new Strategy() {
//                            @Override
//                            public boolean hasEnoughValue(int value) {
//                                return  value < 10? false: true;
//                            }
//                        })
        };

        Table table1 = new Table("MagicTable", players);

        table1.battle();
        ResultBattle resultBattle = StatisticService.getInstance().processResult();
        resultBattle.showWinners();

    }

}
