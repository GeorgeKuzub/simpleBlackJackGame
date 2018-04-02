package org.kuzub.blackjack.engine.strategies;

import org.kuzub.blackjack.engine.Strategy;

public class SillyStrategy implements Strategy {
    @Override
    public boolean hasEnoughValue(int value) {
        return  value < 20? false: true;
    }
}
