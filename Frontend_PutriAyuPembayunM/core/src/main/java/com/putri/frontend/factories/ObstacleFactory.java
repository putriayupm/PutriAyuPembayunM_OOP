package com.putri.frontend.factories;

import java.util.*;
import com.putri.frontend.obstacles.BaseObtacle;

public class ObstacleFactory {
    public interface ObstacleCreator {
        BaseObtacle create(float groundTopY, float spawnX, float playerHeight, Random rng);

        void release(BaseObtacle obstacle);

        void releaseAll();

        List<? extends BaseObtacle> getInUse();

        boolean supports(BaseObtacle obstacle);

        String getName();
    }


    private final Map<String, ObstacleCreator> creators = new HashMap<>();
    private final List<ObstacleCreator> weightedSelection = new ArrayList<>();
    private final Random random = new Random();


    public ObstacleFactory() {
        // Register all possible creators permanently
        register(new VerticalLaserCreator());
        register(new HorizontalLaserCreator());
        register(new HomingMissileCreator());
    }


    private void register(ObstacleCreator creator) {
        creators.put(creator.getName(), creator);
    }


    public void setWeights(Map<String, Integer> weights) {
        weightedSelection.clear();
        for (Map.Entry<String, Integer> entry : weights.entrySet()) {
            String name = entry.getKey();
            int weight = entry.getValue();
            if (creators.containsKey(name)) {
                for (int i = 0; i < weight; i++) {
                    weightedSelection.add(creators.get(name));
                }
            }
        }


    }

    public BaseObtacle createRandomObstacle(float groundTopY, float spawnX, float playerHeight) {
        if (weightedSelection.isEmpty()) {
            // Fallback or throw exception if no weights are set
            return null;
        }

        ObstacleCreator creator = selectWeightedCreator();
        return creator.create(groundTopY, spawnX, playerHeight, random);
    }


    private ObstacleCreator selectWeightedCreator() {
        int randomIndex = random.nextInt(weightedSelection.size());
        return weightedSelection.get(randomIndex);
    }


    public void releaseObstacle(BaseObtacle obstacle) {
        for (ObstacleCreator creator : creators.values()) {
            if (creator.supports(obstacle)) {
                creator.release(obstacle);
                return;
            }
        }
    }


    public void releaseAllObstacles() {
        for (ObstacleCreator creator : creators.values()) {
            creator.releaseAll();
        }
    }

    public List<BaseObtacle> getAllInUseObstacles() {
        List<BaseObtacle> list = new ArrayList<>();
        for (ObstacleCreator creator : creators.values()) {
            list.addAll(creator.getInUse());
        }
        return list;
    }


    public List<String> getRegisteredCreatorNames() {
        return new ArrayList<>(creators.keySet());
    }


}


