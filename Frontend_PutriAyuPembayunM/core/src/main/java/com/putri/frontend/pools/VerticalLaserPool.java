package com.putri.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.putri.frontend.obstacles.VerticalLaser;

public class VerticalLaserPool extends ObjectPool<VerticalLaser>{
    @Override
    protected VerticalLaser createObject(){
        return new VerticalLaser(new Vector2(0,0), 100);
    }

    protected void resetObject(VerticalLaser laser){
        laser.setPosition(0, 0);
        laser.setActive(false);
    }

    public VerticalLaser obtain(Vector2 position, int length) {
        VerticalLaser laser = super.obtain();
        laser.initialize(position, length);
        laser.setActive(true);
        return laser;
    }
}
