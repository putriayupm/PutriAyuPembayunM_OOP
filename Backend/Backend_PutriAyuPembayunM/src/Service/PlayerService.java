package Service;
import Model.Player;
import Repository.PlayerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlayerService {
    private PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }
    public boolean existsByUsername (String username){
        return this.playerRepository.findByUsername(username).isPresent();

    }
    public Player createPlayer (Player player){

    }
    public Optional<Player> getPlayerById (UUID playerId){
        return this.playerRepository.findById(playerId);
    }
    public Optional<Player> getPlayerByUsername (String username){
        return this.playerRepository.findByUsername(username);
    }
    public List<Player> getAllPlayers(){
        return this.playerRepository.findAll();
    }
    public Player updatePlayer (UUID playerId, Player updatedPlayer){

    }
    public void deletePlayer (UUID playerId){

    }
    public void deletePlayerByUsername (String username){

    }
    public Player updatePlayerStats (UUID playerId, int scoreValue, int coinsCollected, int distanceTravelled){

    }
    public List<Player> getLeaderboardByHighScore(int limit){

    }
    public List<Player> getLeaderboardByTotalCoins(){

    }
    public List<Player> getLeaderboardByTotalDistance(){

    }
}
