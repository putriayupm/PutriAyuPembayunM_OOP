package com.putri.frontend.commands;

import com.putri.frontend.GameManager;
import com.putri.frontend.Player;

/**
 * Concrete command for restarting the game
 */
public class RestartCommand implements Command {
    private Player player;
    private GameManager gameManager;

    public RestartCommand(Player player, GameManager gameManager) {
        this.player = player;
        this.gameManager = gameManager;
    }

    @Override
    public void execute() {
        player.reset();
        gameManager.setScore(0);
    }
}
