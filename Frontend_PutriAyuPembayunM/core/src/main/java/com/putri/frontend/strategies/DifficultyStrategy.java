package com.putri.frontend.strategies;


import java.util.Map;

public interface DifficultyStrategy {
    float getSpawnInterval();
    int getDensity();
    float getMinGap();
    Map<String, Integer> getObstacleWeights();
}
