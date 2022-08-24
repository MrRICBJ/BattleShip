package org.battleShip;

public class Map {
    private final String[][] gameMap = gameField();
    private final String[][] gameMapCopy = gameField();

    private static String[][] gameField() {
        String[][] gameField = new String[11][11];
        gameField[0] = new String[]{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        char f = 64;
        for (int i = 1; i < gameField.length; i++) {
            fill(gameField[i], ++f + "~~~~~~~~~~");
        }
        return gameField;
    }

    public String[][] getGameMap() {
        return gameMap;
    }

    public String[][] getGameMapCopy() {
        return gameMapCopy;
    }

    private static void fill(String[] s, String ch) {
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(ch.charAt(i));
        }
    }

}
