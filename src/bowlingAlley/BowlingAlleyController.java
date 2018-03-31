package bowlingAlley;

import bowlingAlley.exception.InsufficientPlayerException;
import bowlingAlley.service.BowlingAlleyConstants;
import bowlingAlley.service.BowlingAlleyService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by kislay on 6/3/17 at 10:22 AM .
 */
public final class BowlingAlleyController {

    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);

	try {
	    BowlingAlleyService service = BowlingAlleyService.getInstance();
	    int playersCount = scanner.nextInt();

	    service.checkForPlayers(playersCount);

	    Map<Integer, List<Integer>> scoreMap = new TreeMap<>();

	    for (int index = 0; index < BowlingAlleyConstants.SET_COUNT; index++) {
		for (int playerIndex = 1; playerIndex <= playersCount; playerIndex++) {
		    String score = scanner.next();

		    switch (score) {
		    case BowlingAlleyConstants.STRIKE:
			//service.setCurrentScoreList(score, scoreMap, playerIndex);
			//service.printCurrentScoreStatus(scoreMap);
			break;
		    default:
			String nextScore = scanner.next();
			int finalScore = 0;
			if (nextScore.equals(BowlingAlleyConstants.SPARE)) {
			    //finalScore = service.getSparePoints(Integer.parseInt(score));
			} else {
			    finalScore = Integer.parseInt(score)+Integer.parseInt(nextScore);
			}
			service.setCurrentScoreList(String.valueOf(finalScore), scoreMap,
					playerIndex);
			service.printCurrentScoreStatus(scoreMap);
			break;
		    }
		}
	    }

	    int winnerIndex = service.getWinnerIndex();
	    int winnerScore = service.getWinnerScore();
	    System.out.println(String.format(BowlingAlleyConstants.FINAL_MESSAGE, winnerIndex,
			    winnerScore));

	} catch (InsufficientPlayerException exc) {
	    System.out.println(exc.getMessage());
	    System.exit(BowlingAlleyConstants.SYSTEM_EXIT_CODE);
	}
    }
}
