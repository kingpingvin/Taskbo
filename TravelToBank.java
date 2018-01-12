package com.kengpenguin.bots.Taskbo;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.script.framework.task.Task;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.region.Banks;



public class TravelToBank extends Task {

    private final Area.Circular PortKhazard = new Area.Circular(new Coordinate(2661, 3160, 0), 15 );


    @Override
    public boolean validate() {
        return Inventory.isFull() && Banks.newQuery().within(PortKhazard).results().isEmpty();
    }
    @Override
    public void execute() {
        RegionPath toBank = RegionPath.buildTo(PortKhazard.getRandomCoordinate());
        if(toBank  != null) {
            toBank.step();
        } else {
            Environment.getBot().getLogger().info("PathtoBank was null");
        }

    }



}

