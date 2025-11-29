package com.putri.frontend.strategies;

import com.putri.frontend.Coin;
import com.putri.frontend.factories.CoinFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinePattern implements CoinPattern{
    private static float SPACING = 40f;
    private Random random = new Random();

    public List<Coin> spawn(CoinFactory factory, float groundTopY,
                            float spawnX, float screenHeight) {
        List<Coin> coins = new ArrayList<>();
        Random random = new Random();

        int numCoins = 3 + random.nextInt(3);

        float posY = groundTopY + 50 + random.nextFloat() * (screenHeight - 100 - groundTopY - 50);

        float startY = posY;
        float minY = groundTopY + 50;
        float maxY = screenHeight - 100;
        startY = minY + random.nextFloat() * (maxY - minY);

        for (int i = 0; i < numCoins; i++) {
            float coinX = spawnX + i * SPACING;
            Coin coin = factory.coinPool.obtain(coinX, startY);
            factory.getActiveCoins().add(coin);

            coins.add(coin);
        }

        return coins;
    }

    @Override
    public String getName() {
        return "Line";
    }
}
