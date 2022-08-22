package org.battleShip;

public enum enumShip {
//    FIVE("Aircraft Carrier", 5),
//    FOUR("Battleship", 4);
//    THREE1("Submarine", 3),
//    THREE2("Cruiser", 3),
    TWO("Destroyer", 2);

    private String name;
    private int count;

    enumShip(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
