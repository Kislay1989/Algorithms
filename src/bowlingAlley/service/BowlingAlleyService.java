package bowlingAlley.service;

import bowlingAlley.exception.InsufficientPlayerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kislay on 6/3/17 at 10:24 AM .
 */
public final class BowlingAlleyService {

    private static BowlingAlleyService service;
    private static int WINNER_INDEX = 0;
    private static int WINNER_SCORE = 0;

    private BowlingAlleyService()
    {
	//System.out.println("The constructor is private");
    }

    public static BowlingAlleyService getInstance()
    {
	if (service == null) {
	    synchronized (BowlingAlleyService.class) {
		if (service == null)
		    service = new BowlingAlleyService();
	    }
	}
	return service;
    }

    public int getWinnerIndex()
    {
	return WINNER_INDEX;
    }

    public int getWinnerScore()
    {
	return WINNER_SCORE;
    }

    public void checkForPlayers(int playersCount) throws InsufficientPlayerException
    {
	if (playersCount == 0 || playersCount == 1) {
	    String message = BowlingAlleyConstants.INCOMPLETE_PLAYER_EXCEPTION;
	    throw new InsufficientPlayerException(message);
	}
    }

    public void setCurrentScoreList(String score, Map<Integer, List<Integer>> map, int index)
    {
	List<Integer> list = map.computeIfAbsent(index, k -> new ArrayList<>());

	switch (score) {
	case BowlingAlleyConstants.SPARE:
	    list.add(BowlingAlleyConstants.COMPLETE_SCORE + BowlingAlleyConstants.SPARE_BONUS);
	    break;
	case BowlingAlleyConstants.STRIKE:
	    list.add(BowlingAlleyConstants.COMPLETE_SCORE + BowlingAlleyConstants.STRIKE_BONUS);
	    break;
	default:
	    list.add(Integer.parseInt(score));
	    break;
	}
    }

    public int getSparePoints(int firstScore)
    {
	/*BowlingAlleyConstants.COMPLETE_SCORE +
			BowlingAlleyConstants.SPARE_BONUS;*/
	return 0;
    }

    public void printCurrentScoreStatus(Map<Integer, List<Integer>> map)
    {
	for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
	    int totalScore = 0;
	    int index = entry.getKey();
	    List<Integer> scoreList = entry.getValue();
	    String scoreHeader = BowlingAlleyConstants.MARK + index + BowlingAlleyConstants.MARK_2;

	    StringBuilder scoreMessage = new StringBuilder(scoreHeader);
	    for (Integer score : scoreList) {
		totalScore += score;
		scoreMessage.append(score);
		scoreMessage.append(BowlingAlleyConstants.SCORE_SEPARATOR);
	    }

	    if (totalScore > WINNER_SCORE) {
		WINNER_SCORE = totalScore;
		WINNER_INDEX = index;
	    }

	    String finalMessage = scoreMessage.toString();
	    finalMessage = finalMessage.substring(0,
			    finalMessage.lastIndexOf(BowlingAlleyConstants.SCORE_SEPARATOR)) +
			    BowlingAlleyConstants.END_HEADER + totalScore;
	    System.out.println(finalMessage);
	}
    }
}
