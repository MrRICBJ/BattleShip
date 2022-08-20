package org.battleShip;

import java.util.Scanner;

public class battleShip {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the name of the first player");
        Player player1 = new Player(sc.nextLine());
        System.out.println("Enter the name of the second player");
        Player player2 = new Player(sc.nextLine());
        fillMap(player1);
//        battle();

    }

    //-----------battle----------------
//    private static int battle(Player player){
//        String[][] map = player.getMap().getGameMap();
//        String[][] mapCopy = player.getMap().getGameMapCopy();
//        String input;
//        while (true){
//            input = sc.nextLine().trim();
//            if (v)
//        }
//    }
    //-----------Fill map---------------
    private static void fillMap(Player player) {
        String input;
        for (enumShip s: enumShip.values()) {
            render(player.getMap(), 0);
            System.out.printf("%s, enter the coordinates of the %s (%d cells)\n", player.getName(), s.getName(), s.getCount());
            input = sc.nextLine();
            details(input, player.hashShip.get(s), player.getMap().getGameMap());
        }
        render(player.getMap(), 0);
        System.out.printf("Press Enter and pass the turn to %s", player.getName());
        sc.nextLine();
//        clear();
    }

//    public static void clear(){
//        //Clears Screen in java
//        try {
//            if (System.getProperty("os.name").contains("Windows"))
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//            else
//                Runtime.getRuntime().exec("clear");
//        } catch (IOException | InterruptedException ex) {
//            System.out.println("error");
//        }
//    }

//    private static void render(Map map, int i) {
//        String[][] gameMap =  i == 0 ? map.getGameMap() : map.getGameMapCopy();
//        for (String[] strings : gameMap) {
//            for (String string : strings) {
//                System.out.print(string + ' ');
//            }
//            System.out.print("\n");
//        }
//    }


    protected static void details(String input, Ship ship, String[][] gameMap) {
        boolean сondition = true;
        String[] split;
        int x1, x2;
        while (сondition) {
            if (verifyInput(input, ship)) {
                if ((ship.getStartL() == ship.getEndL() || ship.getStartD() == ship.getEndD()) && verifyCell(ship, gameMap) &&
                        (ship.getEndL() - ship.getStartL() + 1 == ship.getCountCell() || ship.getEndD() - ship.getStartD() + 1 == ship.getCountCell())){
                    fillShip(ship, gameMap);
                    ship.coordination();
                    сondition = false;
                } else {
                    errors(ship);
                    input = sc.nextLine();
                }
            } else {
                System.out.println("Error! Try again:");
                input = sc.nextLine();
            }
        }
        return;
    }

    private static void errors(Ship ship) {
        if (ship.getStartL() != ship.getEndL() && ship.getStartD() != ship.getEndD())
            System.out.println("Error! Wrong ship location! Try again:");
        else if ((ship.getEndL() - ship.getStartL() + 1 != ship.getCountCell()) && (ship.getEndD() - ship.getStartD() + 1 != ship.getCountCell()))
            System.out.printf("Error! Wrong length of the %s! Try again:\n", ship.getName());
        else
            System.out.println("Error! You placed it too close to another one. Try again:");
    }
    private static void fillShip(Ship ship, String[][] map){
        if (ship.whichShip())
            fillX(ship.getStartD(), ship.getEndD(), map[ship.getStartL() - 64]);
        else
            fillY(map, ship.getStartL() - 64, ship.getEndL() - 64, ship.getStartD());
    }

    private static void fillX(int x1, int x2, String[] s){
        for (int i = x1; i <= x2; i++) {
            s[i] = "O";
        }
    }

    private static void fillY(String[][] s, int y1, int y2, int count){
        for (int i = y1; i <= y2 ; i++) {
            s[i][count] = "O";
        }
    }
    private static boolean verifyCell(Ship ship, String[][] gameMap){
        return seeCell(arrayOutageMinus(ship.getStartD()), arrayOutagePlus(ship.getEndD()), gameMap[ship.getStartL() - 64]) &&
        seeCell(arrayOutageMinus(ship.getStartD()), arrayOutagePlus(ship.getEndD()), gameMap[arrayOutageMinus(ship.getStartL() - 64)]) &&
        seeCell(arrayOutageMinus(ship.getStartD()), arrayOutagePlus(ship.getEndD()), gameMap[arrayOutagePlus(ship.getStartL() - 64)]);
    }
    private static int arrayOutagePlus(int count){
        if (count < 10)
            count++;
        return count;
    }

    private static int arrayOutageMinus(int count){
        if (count > 1)
            count--;
        return count;
    }
    private static boolean seeCell(int x1, int x2, String[] s){
        for (int i = x1; i <= x2; i++) {
            if (s[i].equals("O"))
                return false;
        }
        return true;
    }

    private static boolean verifyInput(String input, Ship ship) {
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

    protected static void argument(String[] s, Ship ship, int x1, int x2) {
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
}




