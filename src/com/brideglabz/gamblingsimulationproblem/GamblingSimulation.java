package com.brideglabz.gamblingsimulationproblem;

public class GamblingSimulation {
    public int funds = 0;
    public int bet = 0;
    public int wins = 0;
    public static void main(String[] args) {
        System.out.println("---------------Welcome Gambling Simulation Problem-------------------");
        GamblingSimulation gambler = new GamblingSimulation();
        gambler.gameInitialise();
        gambler.makeBet();
        gambler.gamble();
    }
    public void gameInitialise() {
        System.out.println("\nInitialising game...");
        funds = 100;
        bet = 1;
        System.out.println("Funds : $"+funds);
    }
    public void makeBet() {
        double result = Math.random();
        boolean betResult = false;
        if (result > 0.5) {
            funds += bet;
            wins++;
            betResult = true;
        }
        else {
            funds -= bet;
        }
        displayResults(betResult);
    }

    public void displayResults(boolean result) {
        System.out.println();
        if(result)
            System.out.println("Bet WON!");
        else
            System.out.println("Bet LOST!");
        System.out.println("Funds : $"+funds);
    }

    public void gamble() {
        int minimumFund = funds - (funds/2);
        int maximumFund = funds + (funds/2);
        while(funds < maximumFund && funds > minimumFund) {
            makeBet();
        }
        System.out.println("\nPlayer resigns for the day.");
    }
}
/*As a Calculative
Gambler if won or lost
50% of the stake,
would resign for the
day*/
