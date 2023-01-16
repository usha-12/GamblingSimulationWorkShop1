package com.brideglabz.gamblingsimulationproblem;

import java.util.Scanner;

public class GamblingSimulation {
    public int funds = 0;
    public int bet = 0;
    public int wins = 0;
    public int cumulativeFunds = 0;
    public int daysWon = 0;
    public int daysLost = 0;
    public boolean wonOrNot = false;
    public boolean[] daysArray = new boolean [20];
    public static void main(String[] args) {
        System.out.println("---------------Welcome Gambling Simulation Problem-------------------");
        GamblingSimulation gambler = new GamblingSimulation();
        gambler.playGame();
    }
    public void gameInitialise() {
        System.out.println("\nInitialising game...");
        funds = 100;
        bet = 1;
        wins = 0;
        cumulativeFunds = 0;
        daysWon = 0;
        daysLost = 0;
        wonOrNot = false;
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
        else
            funds -= bet;
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
        while(funds < maximumFund && funds > minimumFund)
            makeBet();
        if(funds == 150) {
            cumulativeFunds += 150;
            daysWon++;
            daysArray[daysWon+daysLost-1] = true;
        }
        else if (funds == 50) {
            cumulativeFunds += 50;
            daysLost++;
            daysArray[daysWon+daysLost-1] = false;
        }
        System.out.println("\nPlayer resigns for the day.");
    }

    public void dailyGamble() {
        for(int day = 1; day <= 20; day++) {
            funds = 100;
            gamble();
        }
    }

    public void displayTwentyDaysResult() {
        System.out.println("\n\nFunds Stats after 20 days of Gambling...");
        System.out.println("Number of days won funds :	"+daysWon);
        System.out.println("Number of days lost funds :	"+daysLost);
        if (cumulativeFunds > (100*20)) {
            System.out.println("Total Funds Won :	$"+(cumulativeFunds-(100*20)));
            wonOrNot = true;
        }
        else
            System.out.println("Total Funds Lost :	$"+((100*20)-cumulativeFunds));
        System.out.println("Total Funds Remaining :	$"+cumulativeFunds);
    }

    public void displayLuckyDays() {
        System.out.println("\n\nLucky days : ");
        for (int i = 0; i < daysArray.length; i++)
            if (daysArray[i])
                System.out.print("   Day "+(i+1));
        System.out.println("\n\nUnlucky days : ");
        for (int i = 0; i < daysArray.length; i++)
            if (!daysArray[i])
                System.out.print("   Day "+(i+1));
    }

    public void playGame() {
        gameInitialise();
        dailyGamble();
        displayTwentyDaysResult();
        displayLuckyDays();
        continueGameOrStop();
    }

    public void continueGameOrStop() {
        Scanner sc = new Scanner(System.in);
        if (wonOrNot) {
            System.out.println("\n\nYOU HAVE WON!");
            System.out.println("Congratulations!!!");
            System.out.println("\nEnter 'Yes' to play for another month.");
            System.out.println("\nEnter 'Stop' to quit the game.");
            char gamingOption = sc.next().charAt(0);
            if (gamingOption == 'y' || gamingOption == 'Y')
                playGame();
            else if(gamingOption == 's' || gamingOption == 'S')
                System.out.println("\nThank you for playing!");
        }
        else {
            System.out.println("\n\nYOU HAVE LOST!");
            System.out.println("You cannot play again.\nBetter luck next time.");
        }
        sc.close();
    }
}
/*If won would like to
continue playing next
month or stop
Gambling*/
