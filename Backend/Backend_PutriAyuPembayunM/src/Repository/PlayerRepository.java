package Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import Model.Player;
import java.util.*;


public class PlayerRepository extends BaseRepository <Player, UUID>{
    public Optional<Player> findByUsername(String username)
    {
        return map.stream()
                .filter(player -> player.getUsername().equals(username))
                .findFirst();
    }
    public List<Player> findTopPlayersByHighScore (int limit){
        return 
    }
}
