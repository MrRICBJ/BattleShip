package org.battleShip.service;

import org.battleShip.Player;
import org.battleShip.Ship;

public interface Service {
    void addShip(Player player);
    void details(String input, Ship ship, Player player);
    void errors(Ship ship);
    void fillShip(Ship ship, String[][] map);
    void fillY(String[][] s, int y1, int y2, int count);
    void fillX(int x1, int x2, String[] s);
    int arrayOutagePlus(int count);
    int arrayOutageMinus(int count);
    boolean verifyCell(Ship ship, String[][] gameMap);
    boolean seeCellX(int x1, int x2, String[] s);
    boolean verifyInput(String input, Ship ship);
    void argument(String[] s, Ship ship, int x1, int x2);
    boolean seeCellY(String[][] s, int y1, int y2, int count);
    public void hashCoordination(Ship ship, Player player);
    public boolean whichShip(int a, int b);
    void shot(Player player1, Player player2);
    boolean watch(Player player1, String shotLocation, Player player2);
    boolean verifyShot(String s);
    }
