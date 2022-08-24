package org.battleShip.service;

import org.battleShip.Player;
import org.battleShip.Ship;

public interface Service {
    void addShip(Player player);
    void details(String input, Ship ship, Player player);
    void errors(Ship ship);
    void fillShip(Ship ship, String[][] map);
    void fillY(String[][] s, int y1, int y2, int count, String str);
    void fillX(int x1, int x2, String[] s, String str);
    int Plus(int count);
    int Minus(int count);
    boolean verifyCell(Ship ship, String[][] gameMap);
    boolean seeCellX(int x1, int x2, String[] s);
    boolean verifyInput(String input, Ship ship);
    void argument(String[] s, Ship ship, int x1, int x2);
    boolean seeCellY(String[][] s, int y1, int y2, int count);
    void hashCoordination(Ship ship, Player player);
    boolean whichShip(int a, int b);
    void shot(Player player1, Player player2);
    int watch(Player player1, String shotLocation, Player player2);
    boolean verifyShot(String s);
    void fillEmptyCell(Ship ship, String[][] map);
    String correctName();

    void getSc();
}
