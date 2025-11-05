package com.putri.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.putri.frontend.obstacles.HorizontalLaser;

public class HorizontalLaserPool extends ObjectPool<HorizontalLaser>{

    @Override
    protected HorizontalLaser createObject(){
        return new HorizontalLaser(new Vector2(0,0), 100);
    }

    protected void resetObject(HorizontalLaser laser){
        laser.setPosition(0, 0);
        laser.setActive(false);
    }

    public HorizontalLaser obtain(Vector2 position, int length) {
        HorizontalLaser laser = super.obtain();
        laser.initialize(position, length);
        laser.setActive(true);
        return laser;
    }
}
