package bowlingAlley.service;

/**
 * Created by kislay on 6/3/17 at 10:27 AM .
 */
public final class BowlingAlleyConstants {

    static final String INCOMPLETE_PLAYER_EXCEPTION =
		    "Game cannot be started due to incomplete players";

    public static final String SPARE = "/";
    public static final String STRIKE = "X";
    static final String SCORE_SEPARATOR = "/";
    static final String MARK = "P";
    static final String MARK_2 = " : ";
    static final String END_HEADER = " -> ";
    public static final String FINAL_MESSAGE = "P%d is the winner with %d score.";

    public static final int COMPLETE_SCORE = 10;
    public static final int SPARE_BONUS = 5;
    static final int STRIKE_BONUS = 10;
    public static final int SYSTEM_EXIT_CODE = 0;
    public static final int SET_COUNT = 10;
}
