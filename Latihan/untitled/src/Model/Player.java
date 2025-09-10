package Model;
import java.time.LocalDateTime;
import java.util.UUID;.java

public class Player implements ShowDetail{
    private UUID playerId;
    private String username;
    private int highscore;
    private int totalCoins;
    private int totalDistance;
    private LocalDateTime createdAt;

    public Player (String username){
        this.username = username;
        this.playerId = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.highscore = 0;
        this.totalCoins = 0;
        this.totalDistance = 0;
    }
    public UUID getPlayerId() {
        return playerId;
    }
    public int updateHighScore (int newScore){
        if (newScore > this.highscore){
            this.highscore = newScore;
        }
    }
    public void addCoins(int coins){
        this.totalCoins += coins;
    }
    public void addDistance (int distance){
        this.totalDistance += distance;
    }

    @Override
    public void showDetail() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Username: " + username);
        System.out.println("High Score: " + highscore);
        System.out.println("Total Coins: " + totalCoins);
        System.out.println("Total Distance: " + totalDistance);
        System.out.println("Created At: " + createdAt);
    }
}
