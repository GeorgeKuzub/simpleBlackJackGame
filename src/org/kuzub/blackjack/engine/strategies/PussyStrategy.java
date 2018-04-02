package org.kuzub.blackjack.engine.strategies;

import org.kuzub.blackjack.engine.Strategy;

public class PussyStrategy implements Strategy {

    @Override
    public boolean hasEnoughValue(int value) {
        return  value < 15? false: true;
    }
}
