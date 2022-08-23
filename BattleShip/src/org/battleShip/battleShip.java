package org.battleShip;

import org.battleShip.service.GameService;
import org.battleShip.service.Service;
import org.battleShip.view.ConsoleRendererImpl;

import java.util.Scanner;

public class battleShip {
    static Service service = new GameService(new ConsoleRendererImpl());

    public static void main(String[] args) {
        System.out.println("Enter the name of the first player");
        Player player1 = new Player(service.correctName());
        System.out.println("Enter the name of the second player");
        Player player2 = new Player(service.correctName());
        service.addShip(player1);
        service.addShip(player2);
        while (player1.getCount() != 1 || player2.getCount() != 1) { //тут поменять на 5-------------------------------------------------------------
            service.shot(player1, player2);
            if (player2.getCount() == 1) //тут поменять на 5-------------------------------------------------------------
                break;
            service.shot(player2, player1);
        }
        System.out.println("\nYou sank the last ship. You won. Congratulations!");
    }
}



