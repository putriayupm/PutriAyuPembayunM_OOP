package com.putri.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.putri.frontend.Coin;

public class CoinPool extends Pool<Coin> {
    @Override
    protected Coin newObject() {
        return new Coin();
    }

    public Coin obtain(float x, float y) {
        Coin coin = super.obtain();
        coin.init(x, y);
        return coin;
    }
}
