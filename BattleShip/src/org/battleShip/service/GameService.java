package org.battleShip.service;

import org.battleShip.Map;
import org.battleShip.Player;
import org.battleShip.Ship;
import org.battleShip.enumShip;
import org.battleShip.view.ConsoleRendererImpl;
import org.battleShip.view.Renderer;

public class GameService implements Service {
    Renderer renderer;

    public GameService(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void addShip(Player player) {
        String input;
        for (enumShip s: enumShip.values()) {
            renderer.render(player.getMap(), 0);
            System.out.printf("%s, enter the coordinates of the %s (%d cells)\n", player.getName(), s.getName(), s.getCount());
            input = sc.nextLine();
            details(input, player.hashShip.get(s), player.getMap().getGameMap());
        }
        renderer.render(player.getMap(), 0);
        System.out.printf("Press Enter and pass the turn to %s", player.getName());
        sc.nextLine();
//        clear();
    }
}
