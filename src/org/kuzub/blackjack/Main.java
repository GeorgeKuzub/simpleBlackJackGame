package org.kuzub.blackjack;

import org.kuzub.blackjack.engine.Game;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Game.startBattle();
        }
    }
}
