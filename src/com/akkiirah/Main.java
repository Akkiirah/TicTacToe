package com.akkiirah;

public class Main {
    public static void main(String[] args) {
        // Creates Map and Players
        Playfield map = new Playfield();
        Player player1 = new Player(1);
        Player player2 = new Player(2);

        int turn = -1;
        int totalTurns = 1;

        // Creates Player Array to cycle through turns
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        // Initializes Map and Renders map once before the game starts
        map.InitializeMap();
        map.UpdateMap(' ', 0);

        // Cycles through until a winners has been decided
        while (!players[0].winner && !players[1].winner) {
            turn = (turn + 1) % 2;

            System.out.print("Player " + players[turn].number + " it is your turn: ");

            // Gets the input of the current turning player
            int input;

            // Validates the input and updates the map when a correct input is given
            while (!map.ValidateMove(input = players[turn].Input())){
                System.out.print("Your move isn't valid Try again: ");
            }

            System.out.println("Your move was valid!");
            map.UpdateMap(players[turn].letter, input);

            // Checks if a winner has been found, else next player will have a turn
            if (map.CheckWinner(map.map) == player1.letter) {
                player1.winner = true;
            } else if (map.CheckWinner(map.map) == player2.letter) {
                player2.winner = true;
            } else if (totalTurns >= 9){
                EndGame(players);
            } else{
                totalTurns++;
            }

        }
        EndGame(players);
    }

    public static void EndGame(Player[] _players){
        if(_players[0].winner)
            System.out.println("Player " +_players[0].number + " won the game!");

        else if(_players[1].winner)
            System.out.println("Player " +_players[1].number + " won the game!");


        else
            System.out.println("No Winners! It's a draw!");

        System.out.println("Thank you for playing!");
    }
}
