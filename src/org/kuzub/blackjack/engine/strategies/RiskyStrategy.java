package org.kuzub.blackjack.engine.strategies;

import org.kuzub.blackjack.engine.Strategy;

public class RiskyStrategy implements Strategy {
    @Override
    public boolean hasEnoughValue(int value) {
        return  value < 19? false: true;
    }
}
