package com.putri.frontend.strategies;

import com.putri.frontend.Coin;
import com.putri.frontend.factories.CoinFactory;

import java.util.List;

public interface CoinPattern {
    List<Coin> spawn(CoinFactory factory, float groundTopY, float spawnX, float screenHeight);
    String getName();
}
