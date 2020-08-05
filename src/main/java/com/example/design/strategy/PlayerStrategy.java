package com.example.design.strategy;

public class PlayerStrategy {
    private String name;
    private HandInterfaceStrategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    public PlayerStrategy(String name, HandInterfaceStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public HandStrategy nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even() {
        gameCount++;
    }

    @Override
    public String toString() {
        return "[" + name + ":" + gameCount + " Games, " + winCount + " win, " + loseCount + " lose]";
    }
}
