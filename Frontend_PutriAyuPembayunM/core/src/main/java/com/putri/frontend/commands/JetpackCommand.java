package com.putri.frontend.commands;

import com.putri.frontend.Player;

public class JetpackCommand implements Command{
    private Player player;
    public JetpackCommand (Player player){
        this.player = player;
    }

    @Override
    public void execute() {
        if (!player.isDead()) {
            player.fly();
        }
    }

}
