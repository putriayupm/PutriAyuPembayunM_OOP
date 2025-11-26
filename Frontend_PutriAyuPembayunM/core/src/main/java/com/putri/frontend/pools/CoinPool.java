package com.putri.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.putri.frontend.Coin;

public class CoinPool extends ObjectPool<Coin>{
    @Override
    protected Coin createObject() {
        return new Coin(new Vector2(0,0));
    }

    @Override
    protected void resetObject(Coin object) {

    }

    public void  obtain(float x, float y){
        super.obtain();

    }


}
