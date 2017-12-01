package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private final String DEFAULTWHENEQUALSCORES = "Deuce";
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;
    private Map<Integer, String> scoreMeaningMap;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.initEqualScoreMap();
    }

    private void initEqualScoreMap() {
        this.scoreMeaningMap = new HashMap<>();
        this.scoreMeaningMap.put(0, "Love");
        this.scoreMeaningMap.put(1, "Fifteen");
        this.scoreMeaningMap.put(2, "Thirty");
        this.scoreMeaningMap.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    private String scoreWhenPlayersScoresEquals() {
        if (this.scoreMeaningMap.keySet().contains(m_score1)) {
            return this.scoreMeaningMap.get(m_score1) + "-All";
        }
        return this.DEFAULTWHENEQUALSCORES;
    }

    private String differenceBetweenScoresOnlyOne() {
        if (m_score1 > m_score2) {
            return "Advantage player1";
        }
        return "Advantage player2";
    }

    private String oneOfThePlayersHasScoreAboveThree() {
        if (Math.abs(m_score1 - m_score2) == 1) {
            return differenceBetweenScoresOnlyOne();
        }
        if (m_score1 > m_score2) {
            return "Win for player1";
        }
        return "Win for player2";
    }
    
    private String playersScoresNotEqualNorAboveThree() {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = m_score1;
                } else {
                    score += "-";
                    tempScore = m_score2;
                }
                if (this.scoreMeaningMap.keySet().contains(tempScore)) {
                    score += this.scoreMeaningMap.get(tempScore);
                }
            }
        return score;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return this.scoreWhenPlayersScoresEquals();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return this.oneOfThePlayersHasScoreAboveThree();
        }
        return this.playersScoresNotEqualNorAboveThree();
    }
    
}
