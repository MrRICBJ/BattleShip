package org.battleShip;

import java.util.HashMap;

import static org.battleShip.enumShip.*;

public class Player {
    String name;
    Map map = new Map();
    static Ship two = new Ship(TWO.getName(), TWO.getCount());
    static Ship five = new Ship(enumShip.FIVE.getName(), enumShip.FIVE.getCount());
    static Ship four = new Ship(enumShip.FOUR.getName(), enumShip.FOUR.getCount());
    static Ship tree1 = new Ship(enumShip.THREE1.getName(), enumShip.THREE1.getCount());
    static Ship tree2 = new Ship(enumShip.THREE2.getName(), enumShip.THREE2.getCount());
    HashMap <enumShip, Ship> hashShip= new HashMap<>();

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

    public Ship getFive() {
        return five;
    }

    public Ship getFour() {
        return four;
    }

    public Ship getTree1() {
        return tree1;
    }

    public Ship getTree2() {
        return tree2;
    }

    public Ship getTwo() {
        return two;
    }
}
