package com.putri.frontend.factories;

import com.badlogic.gdx.math.Vector2;
import com.putri.frontend.obstacles.BaseObtacle;
import com.putri.frontend.obstacles.VerticalLaser;
import com.putri.frontend.pools.VerticalLaserPool;

import java.util.List;
import java.util.Random;

public class VerticalLaserCreator implements ObstacleFactory.ObstacleCreator {
    private final VerticalLaserPool pool = new VerticalLaserPool();
    private static final float MIN_HEIGHT = 100f;
    private static final float MAX_HEIGHT = 300f;

    @Override
    public BaseObtacle create (float groundTopY, float spawnX, float playerHeight, Random rng){
        float height = rng.nextFloat() * (MAX_HEIGHT - MIN_HEIGHT) + MIN_HEIGHT;
        return pool.obtain(new Vector2(spawnX, groundTopY), (int)height);
    }

    @Override
    public void release(BaseObtacle obstacle) {
        if (obstacle instanceof VerticalLaser) {
            pool.release((VerticalLaser) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<VerticalLaser> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObtacle obstacle) {
        return obstacle instanceof VerticalLaser;
    }

    @Override
    public String getName() {
        return "VerticalLaser";
    }
}
