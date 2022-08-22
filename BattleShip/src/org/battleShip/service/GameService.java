package org.battleShip.service;

import org.battleShip.Player;
import org.battleShip.Ship;
import org.battleShip.enumShip;
import org.battleShip.view.Renderer;
import java.util.Scanner;


public class GameService implements Service {
    Renderer renderer;
    static Scanner sc = new Scanner(System.in);

    public GameService(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void addShip(Player player) {
        String input;
        System.out.printf("Player %s, place your ships to the game field\n", player.getName());
        for (enumShip s : enumShip.values()) {
            renderer.render(player.getMap(), 0);
            System.out.printf("%s, enter the coordinates of the %s (%d cells)\n", player.getName(), s.getName(), s.getCount());
            input = sc.nextLine();
            details(input, player.getHashShip().get(s), player);
        }
        renderer.render(player.getMap(), 0);
        System.out.printf("Press Enter and pass the turn to %s\n", player.getName());
        sc.nextLine();
//        clear();
    }

    @Override
    public void details(String input, Ship ship, Player player) {
        boolean condition = true;
        String[][] gameMap = player.getMap().getGameMap();
        while (condition) {
            if (verifyInput(input, ship)) {
                if ((ship.getStartL() == ship.getEndL() || ship.getStartD() == ship.getEndD()) && verifyCell(ship, gameMap) &&
                        (ship.getEndL() - ship.getStartL() + 1 == ship.getCountCell() || ship.getEndD() - ship.getStartD() + 1 == ship.getCountCell())) {
                    fillShip(ship, gameMap);
                    hashCoordination(ship, player);
                    condition = false;
                } else {
                    errors(ship);
                    input = sc.nextLine();
                }
            } else {
                System.out.println("Error! Try again:");
                input = sc.nextLine();
            }
        }
    }


    @Override
    public void hashCoordination(Ship ship, Player player) {
        String[] s = new String[ship.getCountCell()];
        int j = ship.getStartD();
        if (whichShip(ship.getStartD(), ship.getEndD())) {
            for (int i = 0; i < ship.getCountCell(); i++) {
                s[i] = (char) ship.getStartL() + String.valueOf(j);
                player.getAllShip().put(s[i], ship);
                j++;
            }
        } else {
            j = ship.getStartL();
            for (int i = 0; i < ship.getCountCell(); i++) {
                s[i] = (char) j + String.valueOf(ship.getStartD());
                player.getAllShip().put(s[i], ship);
                j++;
            }
        }
    }

    @Override
    public boolean whichShip(int a, int b) {
        return a != b;
    }

    @Override
    public void errors(Ship ship) {
        if (ship.getStartL() != ship.getEndL() && ship.getStartD() != ship.getEndD())
            System.out.println("Error! Wrong ship location! Try again:");
        else if ((ship.getEndL() - ship.getStartL() + 1 != ship.getCountCell()) && (ship.getEndD() - ship.getStartD() + 1 != ship.getCountCell()))
            System.out.printf("Error! Wrong length of the %s! Try again:\n", ship.getName());
        else
            System.out.println("Error! You placed it too close to another one. Try again:");
    }

    @Override
    public void fillShip(Ship ship, String[][] map) {
        if (whichShip(ship.getStartD(), ship.getEndD()))
            fillX(ship.getStartD(), ship.getEndD(), map[ship.getStartL() - 64]);
        else
            fillY(map, ship.getStartL() - 64, ship.getEndL() - 64, ship.getStartD());
    }

    @Override
    public void fillX(int x1, int x2, String[] s) {
        for (int i = x1; i <= x2; i++) {
            s[i] = "O";
        }
    }

    @Override
    public void fillY(String[][] s, int y1, int y2, int count) {
        for (int i = y1; i <= y2; i++) {
            s[i][count] = "O";
        }
    }

    @Override
    public int arrayOutagePlus(int count) {
        if (count < 10)
            count++;
        return count;
    }

    @Override
    public int arrayOutageMinus(int count) {
        if (count > 1)
            count--;
        return count;
    }

    @Override
    public boolean verifyCell(Ship ship, String[][] gameMap) {
        boolean res;
        if (whichShip(ship.getStartD(), ship.getEndD()))
            res = seeCellX(arrayOutageMinus(ship.getStartD()), arrayOutagePlus(ship.getEndD()), gameMap[ship.getStartL() - 64]) &&
                    seeCellX(arrayOutageMinus(ship.getStartD()), arrayOutagePlus(ship.getEndD()), gameMap[arrayOutageMinus(ship.getStartL() - 64)]) &&
                    seeCellX(arrayOutageMinus(ship.getStartD()), arrayOutagePlus(ship.getEndD()), gameMap[arrayOutagePlus(ship.getStartL() - 64)]);
        else
            res = seeCellY(gameMap, arrayOutageMinus(ship.getStartL() - 64), arrayOutagePlus(ship.getEndL() - 64), arrayOutagePlus(ship.getStartD())) &&
                    seeCellY(gameMap, arrayOutageMinus(ship.getStartL() - 64), arrayOutagePlus(ship.getEndL() - 64), arrayOutageMinus(ship.getStartD())) &&
                    seeCellY(gameMap, arrayOutageMinus(ship.getStartL() - 64), arrayOutagePlus(ship.getEndL() - 64), ship.getStartD());
        return res;
    }

    @Override
    public boolean seeCellY(String[][] s, int y1, int y2, int count) {
        for (int i = y1; i <= y2; i++) {
            if (s[i][count].equals("O"))
                return false;
        }
        return true;
    }

    @Override
    public boolean seeCellX(int x1, int x2, String[] s) {
        for (int i = x1; i <= x2; i++) {
            if (s[i].equals("O"))
                return false;
        }
        return true;
    }

    @Override
    public boolean verifyInput(String input, Ship ship) {
        String[] tmp = input.trim().split(" ");
        if (tmp.length == 2) {
            char a1 = tmp[0].charAt(0);
            char a2 = tmp[1].charAt(0);
            if (Character.isLetter(a1) && Character.isLetter(a2) &&
                    a1 >= 'A' && a1 <= 'J' && a2 >= 'A' && a2 <= 'J') {
                int x2, x1;
                try {
                    x1 = Integer.parseInt((tmp[0].substring(1)));
                    x2 = Integer.parseInt((tmp[1].substring(1)));
                } catch (Exception e) {
                    return false;
                }
                if (x1 >= 1 && x1 <= 10 && x2 >= 1 && x2 <= 10) {
                    argument(tmp, ship, x1, x2);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void argument(String[] s, Ship ship, int x1, int x2) {
        if ((x1 > x2) || ((int) s[0].charAt(0) > (int) s[1].charAt(0))) {
            String tmp = s[0];
            s[0] = s[1];
            s[1] = tmp;
        }
        ship.setStartL(s[0].charAt(0));
        ship.setStartD(Integer.parseInt((s[0].replaceAll("\\D+", ""))));
        ship.setEndL(s[1].charAt(0));
        ship.setEndD(Integer.parseInt((s[1].replaceAll("\\D+", ""))));
    }

    @Override
    public boolean watch(Player player1, String shotLocation, Player player2) {
        String[][] map = player1.getMap().getGameMap(), mapCopy = player1.getMap().getGameMapCopy();
        int i = (int) shotLocation.charAt(0) - 64, j = Integer.parseInt(shotLocation.replaceAll("\\D+", ""));
        String ch;
        boolean bool;

        if (!mapCopy[i][j].equals("~")) {
            System.out.println("You have shot here before! Try again:");
            return false;
        } else {
            if (player1.getAllShip().containsKey(shotLocation)) {
                ch = "X";
                bool = true;
                Ship ship = player1.getAllShip().get(shotLocation);
                player1.getAllShip().get(shotLocation).setCountCell();
            } else {
                ch = "M";
                System.out.println("You missed!");
                bool = false;
            }
            map[i][j] = ch;
            mapCopy[i][j] = ch;
            if (ch.equals("M")) {
                renderer.render(player1.getMap(), 1);
                System.out.println("----------------------");
                renderer.render(player2.getMap(), 0);
            }
        }
        return bool;
    }

    @Override
    public boolean verifyShot(String s) {
        boolean res = false;
        if ((s.length() == 2 || s.length() == 3) && Character.isLetter(s.charAt(0))) {
            res = true;
            try {
                Integer.parseInt(s.substring(1));
            } catch (Exception e) {
                res = false;
            }
        }
        if (!res)
            System.out.println("Error: Try again:");
        return res;
    }

    @Override
    public void shot(Player player1, Player player2) {
        String shotLocation;
        int coordinate;
        Ship ship;
        renderer.render(player2.getMap(), 1);
        System.out.println("----------------------");
        renderer.render(player1.getMap(), 0);
        System.out.printf("%s, it's your turn:\n", player1.getName());
        while (true) {
            shotLocation = sc.nextLine().trim();
            if (verifyShot(shotLocation)) {
                coordinate = Integer.parseInt(shotLocation.replaceAll("\\D+", ""));
                if (shotLocation.charAt(0) < 'A' || shotLocation.charAt(0) > 'J' || coordinate < 1 || coordinate > 10)
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                else if (watch(player2, shotLocation, player1)) {
                    ship = player2.getAllShip().get(shotLocation);
                    if (player2.getAllShip().get(shotLocation).getCountCell() == 0) {
                        player2.setCount();
                        if (player2.getCount() != 1)
                            System.out.println("You sank a ship!");
                    } else if (player2.getAllShip().get(shotLocation).getCountCell() != 0 && player2.getCount() != 1)
                        System.out.println("You hit a ship!");
                    renderer.render(player2.getMap(), 1);//
                    System.out.println("----------------------");
                    renderer.render(player1.getMap(), 0);
                    break;
                }
            }
        }
        System.out.println("Press Enter and pass the move to another player");
        sc.nextLine();
    }
}
