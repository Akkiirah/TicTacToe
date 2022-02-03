package com.akkiirah;

import java.util.Arrays;
import java.util.Objects;

public class Playfield {
    // Creates map
    char[] map = new char[9];

    // Fills map with empty characters
    public void InitializeMap(){
        Arrays.fill(map, ' ');
    }

    // Validates if the place, the player chose wasn't already been chosen before
    public boolean ValidateMove(int _pos){
        if (_pos >= 0 && _pos < 9){
            return (Objects.equals(map[_pos], ' '));
        }
        else{
            return false;
        }
    }

    // Updates the map if all validation was good
    public void UpdateMap(char _letter, int _pos){
        map[_pos] = _letter;

        System.out.println("=============");
        System.out.println("| " + map[0] + " | " + map[1] + " | " + map[2] + " |");
        System.out.println("| " + map[3] + " | " + map[4] + " | " + map[5] + " |");
        System.out.println("| " + map[6] + " | " + map[7] + " | " + map[8] + " |");
        System.out.println("=============");
    }

    // Checks all possibilities to win the game
    public char CheckWinner(char[] map) {
        // First line - linear
        if (map[0] == map[1] && map[0] == map[2] && map[0] != ' ')
            return map[0];

        // Second line - linear
        else if (map[3] == map[4] && map[3] == map[5] && map[3] != ' ')
            return map[3];

        // Third line - linear
        else if (map[6] == map[7] && map[6] == map[8] && map[6] != ' ')
            return map[6];

        // Top left to bottom right
        else if (map[0] == map[4] && map[0] == map[8] && map[0] != ' ')
            return map[0];

        // Top right to bottom left
        else if (map[2] == map[4] && map[0] == map[6] && map[2] != ' ')
            return map[2];

        // First row - vertical
        else if (map[0] == map[3] && map[0] == map[6] && map[0] != ' ')
            return map[0];

        // Second row - vertical
        else if (map[1] == map[4] && map[1] == map[7] && map[1] != ' ')
            return map[1];

        // Third row - vertical
        else if (map[2] == map[5] && map[2] == map[8] && map[2] != ' ')
            return map[2];

        return ' ';
    }
}
