package org.kuzub.blackjack.engine.strategies;

import org.kuzub.blackjack.engine.Strategy;

public class PessimistStrategy implements Strategy {

    @Override
    public boolean hasEnoughValue(int value) {
        return  value < 16? false: true;
    }
}
