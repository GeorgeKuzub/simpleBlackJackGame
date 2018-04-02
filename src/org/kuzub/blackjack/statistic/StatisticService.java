package org.kuzub.blackjack.statistic;

public class StatisticService {
    private static StatisticService instance;
    private BattleStatistic battleStatistic;
    private int counter;

    public static StatisticService getInstance() {
        if (instance != null) {
            return instance;
        }

        instance = new StatisticService();
        return instance;
    }

    private StatisticService() {
    }

    public void set(BattleStatistic battleStatistic) {
        this.battleStatistic = battleStatistic;
    }


    public ResultBattle processResult() {
        return
                new ResultBattle(
                        battleStatistic.getTable(),
                        battleStatistic.getWinners(),
                        battleStatistic.getPoints());
    }

}
