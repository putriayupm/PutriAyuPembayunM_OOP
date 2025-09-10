package Model;
import java.time.LocalDateTime;
import java.util.UUID;

public class Score implements ShowDetail {
    private UUID scoreId;
    private UUID playerId;
    private Player player;
    private int value;
    private int coinsCollected;
    private int distance;
    private LocalDateTime createdAt;

    public Score (UUID playerId, int value, int coinsCollected, int distance){
        this.playerId = playerId;
        this.value = value;
        this.coinsCollected = coinsCollected;
        this.distance = distance;
    }
    public int getValue (){
        return value;
    }
    public int getCoinsCollected() {
        return coinsCollected;
    }
    public int getDistance() {
        return distance;
    }

}
