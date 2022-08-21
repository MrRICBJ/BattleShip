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
    }
}



