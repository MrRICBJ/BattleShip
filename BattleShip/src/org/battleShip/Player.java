package org.battleShip;

import java.util.HashMap;

import static org.battleShip.enumShip.*;

public class Player {
    private String name;
    private Map map = new Map();
    private static Ship two = new Ship(TWO.getName(), TWO.getCount());
    private static Ship five = new Ship(enumShip.FIVE.getName(), enumShip.FIVE.getCount());
    private static Ship four = new Ship(enumShip.FOUR.getName(), enumShip.FOUR.getCount());
    private static Ship tree1 = new Ship(enumShip.THREE1.getName(), enumShip.THREE1.getCount());
    private static Ship tree2 = new Ship(enumShip.THREE2.getName(), enumShip.THREE2.getCount());
    HashMap <enumShip, Ship> hashShip = new HashMap<>();
    HashMap <String, Ship> HashShip = new HashMap<>();


    private void hashShips(HashMap <String, Ship> HashShip) {

    }

    private static void ship(HashMap <enumShip, Ship> hashShip){
        hashShip.put(TWO, two);
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
