package com.brideglabz.gamblingsimulationproblem;

public class GamblingSimulation {
    public int funds = 0;
    public int bet = 0;
    public int wins = 0;
    public int cumulativeFunds = 0;
    public int daysWon = 0;
    public int daysLost = 0;
    public static void main(String[] args) {
        System.out.println("---------------Welcome Gambling Simulation Problem-------------------");
        GamblingSimulation gambler = new GamblingSimulation();
        gambler.gameInitialise();
        gambler.makeBet();
        gambler.gamble();
        gambler.dailyGamble();
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
    public void dailyGamble() {
        for(int day = 1; day <= 20; day++) {
            funds = 100;
            gamble();
        }
        this.displayTwentyDaysResult();
    }

    public void displayTwentyDaysResult() {
        System.out.println("\n\nFunds Stats after 20 days of Gambling...");
        System.out.println("Number of days won funds :	"+daysWon);
        System.out.println("Number of days lost funds :	"+daysLost);
        if (cumulativeFunds > (100*20))
            System.out.println("Total Funds Won : $"+(cumulativeFunds-(100*20)));
        else
            System.out.println("Total Funds Lost : $"+((100*20)-cumulativeFunds));
        System.out.println("Total Funds : $"+cumulativeFunds);
    }
}
/*Each month would like
to know the days won
and lost and by how
much.*/
