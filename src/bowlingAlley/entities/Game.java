package bowlingAlley.entities;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Game {

    private static final int MAX_PLAYERS = 10;

    private final String id;
    private final String name;
    private final LocalDateTime startedAt;
    Map<String, Player> players;
    private Scoreboard scoreboard;

    public Game(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        startedAt = LocalDateTime.now();
        players = new HashMap<>(MAX_PLAYERS);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }
}
