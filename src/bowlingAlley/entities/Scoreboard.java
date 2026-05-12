package bowlingAlley.entities;

import java.util.Set;
import java.util.TreeSet;

public class Scoreboard {

    private final Set<Player> players;

    public Scoreboard(Set<Player> players) {
        this.players = new TreeSet<>();
    }

    public Set<Player> getPlayers() {
        return players;
    }
}
