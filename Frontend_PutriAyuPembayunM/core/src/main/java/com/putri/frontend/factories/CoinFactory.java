package com.putri.frontend.factories;

import com.badlogic.gdx.utils.Array;
import com.putri.frontend.Coin;
import com.putri.frontend.pools.CoinPool;

public class CoinFactory {
    public final CoinPool coinPool;
    private Array<Coin> activeCoins;

    public CoinFactory() {
        coinPool = new CoinPool();
        activeCoins = new Array<>();
    }

    public Coin spawnCoin(float x, float y) {
        Coin coin = coinPool.obtain(x, y);
        activeCoins.add(coin);
        return coin;
    }

    public Array<Coin> getActiveCoins() {
        return activeCoins;
    }

    public void releaseCoin(Coin coin) {
        activeCoins.removeValue(coin, true);
        coinPool.free(coin);
    }

    public void releaseAll() {
        for (Coin coin : activeCoins) {
            coinPool.free(coin);
        }
        activeCoins.clear();
    }
}
