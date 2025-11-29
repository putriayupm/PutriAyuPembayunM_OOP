package com.putri.frontend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.putri.frontend.factories.CoinFactory;
import com.putri.frontend.observers.Observer;
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
        coinsCollected = 0;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void registerPlayer(String username) {
        backendService.createPlayer(username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                try {
                    JsonValue json = new JsonReader().parse(response);
                    currentPlayerId = json.getString("playerId");
                    Gdx.app.log("GameManager", "Player Registered ID: " + currentPlayerId);
                } catch (Exception e) {
                    Gdx.app.error("GameManager", "Parsing error", e);
                }
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "Registration Failed: " + error);
            }
        });
    }

    public void startGame() {
        coinsCollected = 0;
        scoreManager.setScore(0);
        gameActive = true;
        Gdx.app.log("GameManager", "Game Started!");
    }

    public void endGame() {
        gameActive = false;
        if (currentPlayerId == null) {
            Gdx.app.error("GameManager", "Cannot submit score, Player ID is null");
            return;
        }

        int distance = scoreManager.getScore();
        int finalScore = distance + (coinsCollected * 10);

        backendService.submitScore(currentPlayerId, finalScore, coinsCollected, distance, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                Gdx.app.log("GameManager", "Score Submitted Successfully");
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "Score Submission Failed: " + error);
            }
        });
    }

    public void addCoin() {
        coinsCollected++;
        Gdx.app.log("GameManager", "COIN COLLECTED! Total: " + coinsCollected);
    }

    public void setScore(int newScore) {
        if (gameActive) {
            scoreManager.setScore(newScore);
        }
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public int getCoins() {
        return coinsCollected;
    }

    public void addObserver(Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        scoreManager.removeObserver(observer);
    }
}
