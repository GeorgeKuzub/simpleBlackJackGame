package org.kuzub.blackjack.engine.strategies;

import org.kuzub.blackjack.engine.Strategy;

public class DumbStrategy implements Strategy {
    @Override
    public boolean hasEnoughValue(int value) {
        return  value < 21? false: true;
    }
}
