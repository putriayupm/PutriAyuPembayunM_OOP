package com.putri.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.putri.frontend.obstacles.HomingMissile;


public class HomingMissilePool extends ObjectPool<HomingMissile>{
    @Override
    protected HomingMissile createObject(){
        return new HomingMissile(new Vector2(0,0));
    }

    @Override
    protected void resetObject(HomingMissile laser){
        laser.setPosition(0, 0);
        laser.setTarget(null);
        laser.setActive(false);
    }

    public HomingMissile obtain(Vector2 position) {
        HomingMissile missile = super.obtain();
        missile.initialize(position, 0);
        missile.setActive(true);
        return missile;
    }
}
