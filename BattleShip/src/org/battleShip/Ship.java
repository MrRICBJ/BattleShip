package org.battleShip;

public class Ship {
    private final String name;
    private int startL, endL, startD, endD;
    private int countCell;


    public Ship(String name, int cellShip) {
        this.name = name;
        this.countCell = cellShip;
    }

    public int getStartL() {
        return startL;
    }

    public int getEndL() {
        return endL;
    }

    public int getStartD() {
        return startD;
    }

    public int getEndD() {
        return endD;
    }

    public void setCountCell() {
        this.countCell--;
    }

    public String getName() {
        return name;
    }
    public int getCountCell() {
        return countCell;
    }
    public void setStartL(int startL) {
        this.startL = startL;
    }

    public void setEndL(int endL) {
        this.endL = endL;
    }

    public void setStartD(int startD) {
        this.startD = startD;
    }

    public void setEndD(int endD) {
        this.endD = endD;
    }
}
