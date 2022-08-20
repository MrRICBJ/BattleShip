package org.battleShip.service;

import org.battleShip.Map;
import org.battleShip.Player;
import org.battleShip.Ship;

public interface Service {
    void addShip(Player player);
    void fillMap(Player player);
}
