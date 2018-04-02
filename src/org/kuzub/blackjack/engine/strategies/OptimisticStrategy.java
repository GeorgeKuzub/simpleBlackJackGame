package org.kuzub.blackjack.engine.strategies;

import org.kuzub.blackjack.engine.Strategy;

public class OptimisticStrategy implements Strategy {
    @Override
    public boolean hasEnoughValue(int value) {
        return  value < 18? false: true;
    }
}
