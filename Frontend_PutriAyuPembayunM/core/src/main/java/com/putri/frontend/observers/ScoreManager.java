package com.putri.frontend.observers;

import java.util.ArrayList;
import java.util.List;

import static jdk.jfr.internal.consumer.EventLog.update;

public class ScoreManager {
    private List<Observer> observers;
    private int score;

    public ScoreManager( List<Observer> observers, int score){
        this.observers = new ArrayList<>();
        this.score = 0;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(int score){
        observers.notify();
        update(score);
    }

    public void setScore(int newScore){

    }


}
