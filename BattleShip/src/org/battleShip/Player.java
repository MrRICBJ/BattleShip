package org.battleShip;

import java.util.HashMap;

import static org.battleShip.enumShip.*;

public class Player {
    private final String name;

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }

    private int count = 0;
    private final Map map = new Map();
    private final Ship two = new Ship(TWO.getName(), TWO.getCount());
    private final Ship five = new Ship(enumShip.FIVE.getName(), enumShip.FIVE.getCount());
    private final Ship four = new Ship(enumShip.FOUR.getName(), enumShip.FOUR.getCount());
    private final Ship tree1 = new Ship(enumShip.THREE1.getName(), enumShip.THREE1.getCount());
    private final Ship tree2 = new Ship(enumShip.THREE2.getName(), enumShip.THREE2.getCount());
    private final HashMap <enumShip, Ship> hashShip = new HashMap<>();
    private final HashMap <String, Ship>  allShip= new HashMap<>();


    public HashMap<enumShip, Ship> getHashShip() {
        return hashShip;
    }

    public HashMap<String, Ship> getAllShip() {
        return allShip;
    }

    private void ship(HashMap <enumShip, Ship> hashShip){
        hashShip.put(TWO, this.two);
        hashShip.put(THREE1, tree1);
        hashShip.put(THREE2, tree2);
        hashShip.put(FOUR, four);
        hashShip.put(FIVE, five);
    }

    public Player(String name) {
        ship(hashShip);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map getMap() {
        return map;
    }
}
