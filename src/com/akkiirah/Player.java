package com.akkiirah;

import java.util.Scanner;

public class Player {
    int number;
    char letter;
    boolean winner;

    // Assigns a number to a player on creation to differentiate them later
    public Player(int _number){
        this.number = _number;

        switch (number) {
            case 1 -> letter = 'O';
            case 2 -> letter = 'X';
            default -> System.out.println("Error: Wrong number was provided. Cannot assign Player a letter");
        }
    }

    public int Input(){
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();

        // Checks if input is valid with the map size
        if(input >= 0 && input < 9){
            return input;
        } else {
            System.out.println(input + " doesn't correspond to a field on the map. \nTry Again");
            Input();
            return -1;
        }
    }
}
