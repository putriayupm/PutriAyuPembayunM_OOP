package com.putri.frontend.factories;

import com.badlogic.gdx.utils.Array;
import com.putri.frontend.Coin;
import com.putri.frontend.pools.CoinPool;


import java.util.Random;

public class CoinFactory {
    private CoinPool coinPool;
    private Random random;
    private Array<Coin> activeCoins;

    public CoinFactory() {
        coinPool = new CoinPool();
        activeCoins = new Array<>();
        random = new Random();
    }

    public void createCoinPattern(float spawnX, float groundTopY) {
        if (random.nextFloat() < 0.3f) {
            for (int i = 0; i < 3; i++) {
                Coin coin = coinPool.obtain(spawnX + (i * 40), groundTopY + 50);
                activeCoins.add(coin);
            }
        }
    }

    public Array<Coin> getActiveCoins() {
        return activeCoins;
    }

    public void releaseCoin(Coin coin) {
        activeCoins.removeValue(coin, true);
        coin.setActive(false);
    }

    public void releaseAll() {
        for (Coin coin : activeCoins) {
            coinPool.release(coin);
        }
        activeCoins.clear();
    }
}
