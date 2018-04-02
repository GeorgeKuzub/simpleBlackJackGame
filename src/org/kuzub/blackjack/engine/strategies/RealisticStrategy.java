package org.kuzub.blackjack.engine.strategies;

import org.kuzub.blackjack.engine.Strategy;

public class RealisticStrategy implements Strategy {

    @Override
    public boolean hasEnoughValue(int value) {
        return  value < 17? false: true;
    }
}
