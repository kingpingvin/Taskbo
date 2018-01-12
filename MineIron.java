package com.kengpenguin.bots.Taskbo;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.task.Task;

import java.awt.*;

public class MineIron extends Task {


    private Color iron = new Color(32, 17, 14);
    private final Area.Circular IronArea = new Area.Circular(new Coordinate(2627, 3147, 0), 15);
    private GameObject IronOre;

    @Override
    public boolean validate() {
        final Player me = Players.getLocal();
        IronOre = GameObjects.newQuery().names("Rocks").actions("Mine").within(IronArea).defaultColors(iron).results().nearest();
        return me != null && IronOre != null;
    }


    @Override
    public void execute() {
        if (IronOre.isVisible()) {
            if (IronOre.interact("Mine")) {
                Execution.delayWhile(() -> IronOre.isValid(), 3000, 4000);

            }
        } else {
            Environment.getBot().getLogger().info("Turning camera");
            Camera.turnTo(IronOre);
        }
    }
}
