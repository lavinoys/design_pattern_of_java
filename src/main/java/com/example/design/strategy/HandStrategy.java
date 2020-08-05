package com.example.design.strategy;

public class HandStrategy {

    public static final int HANDVALUE_GUU = 0;
    public static final int HANDVALUE_CHO = 1;
    public static final int HANDVALUE_PAA = 2;
    public static final HandStrategy[] hand = {
            new HandStrategy(HANDVALUE_GUU),
            new HandStrategy(HANDVALUE_CHO),
            new HandStrategy(HANDVALUE_PAA)
    };

    private static final String[] name = {"주먹", "가위", "보"};
    private int handValue;
    private HandStrategy(int handValue) {
        this.handValue = handValue;
    }
    public static HandStrategy getHand(int handValue) {
        return hand[handValue];
    }

    public boolean isStrongerThan(HandStrategy h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(HandStrategy h) {
        return fight(h) == -1;
    }

    private int fight(HandStrategy h) {
        if (this == h) {
            return 0;
        } else if ((this.handValue + 1) %3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return name[handValue];
    }
}
