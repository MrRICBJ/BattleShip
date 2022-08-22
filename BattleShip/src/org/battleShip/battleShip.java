package org.battleShip;

import org.battleShip.service.GameService;
import org.battleShip.service.Service;
import org.battleShip.view.ConsoleRendererImpl;

import java.util.Scanner;

public class battleShip {
    static Scanner sc = new Scanner(System.in);
    static Service service = new GameService(new ConsoleRendererImpl());

    public static void main(String[] args) {
        System.out.println("Enter the name of the first player");
        Player player1 = new Player(sc.nextLine());
        System.out.println("Enter the name of the second player");
        Player player2 = new Player(sc.nextLine());
        service.addShip(player1);
        service.addShip(player2);
//        System.out.println(player1);
//        System.out.println(player2);
//        System.out.println(player1.getTwo());
//        System.out.println(player2.getTwo());
//        player1.
        while (player1.getCount() != 1 || player2.getCount() != 1) {
            service.shot(player1, player2);
            service.shot(player2, player1);
        }
    }
}



