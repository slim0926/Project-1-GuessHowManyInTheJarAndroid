import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Player {
  private String mCurrentPlayer;
  private List<String> mWinner;
  private Integer mHighestScore;
  private Map<String, Integer> playerToScore;
  
  public Player() {
    playerToScore = new HashMap<>();
  }

  public void setPlayerName(String name) {
    mCurrentPlayer = name;
    playerToScore.put(name, 0);
  }
  
  public void setScore(int guessCount) {
    Integer score = convertGuessCountToScore(guessCount);
    
      if (playerToScore.containsKey(mCurrentPlayer)) {
        playerToScore.put(mCurrentPlayer, score);
      }
    
  }
                          
  public Integer convertGuessCountToScore(int guessCount) {
    int iScore = 0;
    switch(guessCount) {
      case 1:
        iScore = 1000;
        break;
      case 2:
        iScore = 900;
        break;
      case 3:
        iScore = 800;
        break;
      case 4:
        iScore = 700;
        break;
      case 5:
        iScore = 600;
        break;
      case 6:
        iScore = 500;
        break;
      default:
        iScore = 0;
    }
    Integer score = new Integer(iScore);
    return score;
  }
  
  public void setWinnerAndScore() {
    Collection<Integer> scores = playerToScore.values();
    List<Integer> listOfScores = new ArrayList<>(scores);    
    Collections.sort(listOfScores);
    Integer highScore = listOfScores.get(listOfScores.size() - 1);
    mWinner = new ArrayList<String>();
    for (String key : playerToScore.keySet()) {
      
      if (playerToScore.get(key).equals(highScore)) {
        mWinner.add(key);
        mHighestScore = highScore;
   
      }
    }
  }
  
  public String getCurrentPlayer() {
    return mCurrentPlayer;
  }
  
  public List<String> getWinner() {
    return mWinner;
  }
  
  public Integer getHighestScore() {
    return mHighestScore;
  }
  
  public Integer getScore() {
    Integer score = playerToScore.get(mCurrentPlayer);
    return score;
  }
}