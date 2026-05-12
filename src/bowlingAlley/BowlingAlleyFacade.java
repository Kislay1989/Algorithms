package bowlingAlley;

import bowlingAlley.entities.Player;
import bowlingAlley.service.GameService;
import bowlingAlley.service.PlayerService;

import java.util.TreeSet;

public class BowlingAlleyFacade {

    private final GameService gameService;
    private final PlayerService playerService;

    public BowlingAlleyFacade(GameService gameService, PlayerService playerService) {
        this.gameService = gameService;
        this.playerService = playerService;
    }

    public boolean registerPlayer(String playerName) {
        Player player = playerService.registerPlayer(playerName);
        if (player != null) {
            boolean status = gameService.addPlayerToGame(player);
            if (!status) {
                System.out.println("Unable to register player " + playerName + " to the game.");
                return false;
            }
        }

        return true;
    }

   /* public TreeSet<Player> getScoreboard() {
        return gameService.getScorreBoard();
    }

    public boolean updateScore(Player player, int score) {
        boolean playerExists = playerService.checkPlayerExists(player);
        if (playerExists) {
            boolean scoreUpdation = gameService.updatePlayerScore(player, score);
            if (!scoreUpdation) {
                System.out.println("Unable to update score for player " + player.getName());
                return false;
            }
        }
        return true;
    }*/

    public boolean endGame() {
        return true;
    }
}
