package com.putri.frontend.obstacles;

import com.badlogic.gdx.math.Vector2;
import com.putri.frontend.Player;

public class HomingMissile extends BaseObtacle{
    private Player target;
    private Vector2 velocity;
    private float speed = 200f;
    private float width = 40f;
    private float height = 20f;

    public HomingMissile (Vector2 starPosition){
        super(starPosition);
        velocity = new Vector2();
    }

    public void initialize(Vector2 startPosition, int length){
        super.initialize(startPosition, length);
        velocity.set(0, 0);
    }

    public void setTarget(Player target){

    }
}
