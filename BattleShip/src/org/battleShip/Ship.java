package org.battleShip;

public class Ship {
    private String name;
    private int startL, endL, startD, endD;
    String[] s;
    private int countCell;


    public Ship(String name, int cellShip) {
        this.name = name;
        this.countCell = cellShip;
        s = new String[this.countCell];
    }

    protected void coordination(){
        int j = this.startD;
        for (int i = 0; i < this.countCell; i++) {
            s[i] = (char)this.startL + String.valueOf(j);
        }
    }
    protected boolean whichShip(){
        return this.startD != this.endD;
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

    public String getName() {
        return name;
    }

    public int getCountCell() {
        return countCell;
    }
}
