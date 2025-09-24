package Service;

import Model.Score;
import Repository.PlayerRepository;
import Repository.ScoreRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ScoreService {
    private ScoreRepository scoreRepository;
    private PlayerRepository playerRepository;
    private PlayerService playerService;

    public ScoreService (ScoreRepository scoreRepository, PlayerRepository playerRepository, PlayerService playerService){
        this.playerRepository = playerRepository;
        this.playerService = playerService;
        this.scoreRepository = scoreRepository;
    }
    public Score createScore (Score score){

    }
    public Optional<Score> getScoreById(UUID scoreId){

    }
    public List<Score> getAllScores(){

    }
    public List<Score> getScoresByPlayerId(UUID playerId){

    }
    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId){

    }
    public List<Score> getLeaderboard(int limit){

    }
    public Optional<Score> getHighestScoreByPlayerId(UUID playerId){

    }
    public List<Score> getScoresAboveValue(int minValue){

    }
    public List<Score> getRecentScores(){

    }
    public int getTotalCoinsByPlayerId(UUID playerId){

    }
    public int getTotalDistanceByPlayerId(UUID playerId){

    }
    public ScoreupdateScore(UUID scoreId, Score updatedScore){

    }
    public void deleteScore(UUID scoreId){

    }
    public void deleteScoresByPlayerId(UUID playerId){

    }
}
