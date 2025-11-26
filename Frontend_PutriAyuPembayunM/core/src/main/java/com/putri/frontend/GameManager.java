package com.putri.frontend;
import com.putri.frontend.observers.ScoreManager;
import com.putri.frontend.services.BackendService;

public class GameManager {
    private static GameManager instance;

    private ScoreManager scoreManager;
    private boolean gameActive;

    private BackendService backendService;
    private String currentPlayerId;
    private int coinsCollected;

    private GameManager() {
        scoreManager = new ScoreManager();
        gameActive = false;
        backendService = new BackendService();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        scoreManager.setScore(0);
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int newScore) {
        if (gameActive) {
            scoreManager.setScore(newScore);
        }
    }

    // Getters
    public int getScore() { return scoreManager.getScore(); }

    // Delegate observer methods to ScoreManager
    public void addObserver(com.putri.frontend.observers.Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(com.putri.frontend.observers.Observer observer) {
        scoreManager.removeObserver(observer);
    }

    public void registerPlayer(String username){
        backendService.createPlayer(String username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response;
            response) {

            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public void endGame(){

    }

    public void addCoin(){

    }

    public void setScore(){
    }

    public void getCoins(){

    }
}
