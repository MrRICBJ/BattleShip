package org.battleShip.view;

import org.battleShip.Map;

public class ConsoleRendererImpl implements Renderer {
    @Override
    public void render(Map map, int i) {
        String[][] gameMap =  i == 0 ? map.getGameMap() : map.getGameMapCopy();
        for (String[] strings : gameMap) {
            for (String string : strings) {
                System.out.print(string + ' ');
            }
            System.out.print("\n");
        }
    }
}
