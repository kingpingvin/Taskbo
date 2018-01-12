package com.kengpenguin.bots.Taskbo;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.region.Region;
import com.runemate.game.api.script.framework.task.Task;

public class TravelToIronOre extends Task {
    private final Area.Circular IronOreArea = new Area.Circular(new Coordinate(2632, 3141, 0), 15);

    @Override
    public boolean validate() {
        final Player me = Players.getLocal();
        return me != null && !Inventory.isFull() && !IronOreArea.contains(me);
    }

    @Override
    public void execute() {
        RegionPath toIron = RegionPath.buildTo(IronOreArea.getRandomCoordinate());
        if (toIron != null) {
            toIron.step();
        } else {
            Environment.getBot().getLogger().info("Path toIron was null");
        }
    }
}

