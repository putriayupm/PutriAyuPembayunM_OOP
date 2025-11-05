package com.putri.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.putri.frontend.obstacles.BaseObtacle;
import com.putri.frontend.obstacles.HomingMissile;
import com.putri.frontend.pools.HomingMissilePool;

import java.util.List;
import java.util.Random;

public class HomingMissileCreator implements ObstacleFactory.ObstacleCreator{
    private final HomingMissilePool pool = new HomingMissilePool();

    @Override
    public BaseObtacle create (float groundTopY, float spawnX, float playerHeight, Random rng){
        float minY = groundTopY + playerHeight;
        float maxY = Gdx.graphics.getHeight() - playerHeight;
        float spawnY = minY + (rng.nextFloat() * (maxY - minY));
        Vector2 position = new Vector2(spawnX, spawnY);
        return pool.obtain(position);
    }

    @Override
    public void release(BaseObtacle obstacle) {
        if (obstacle instanceof HomingMissile) {
            pool.release((HomingMissile) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<HomingMissile> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObtacle obstacle) {
        return obstacle instanceof HomingMissile;
    }

    @Override
    public String getName() {
        return "HomingMissile";
    }
}
