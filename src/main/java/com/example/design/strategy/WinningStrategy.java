package com.example.design.strategy;

import java.util.Random;

public class WinningStrategy implements HandInterfaceStrategy {

    private Random random;
    private boolean won = false;
    private HandStrategy prevHand;
    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public HandStrategy nextHand() {
        if (!won) {
            prevHand = HandStrategy.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
