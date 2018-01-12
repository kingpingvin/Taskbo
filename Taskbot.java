package com.kengpenguin.bots.Taskbo;

import com.kengpenguin.bots.Taskbo.TravelToBank;

import com.runemate.game.api.script.framework.task.TaskBot;
public class Taskbot extends TaskBot {

    @Override
    public void onStart(String... strings) {
        super.onStart(strings);
        add(new TravelToBank(), new TravelToIronOre(), new MineIron());
    }
}
