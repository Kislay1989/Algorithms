package bowlingAlley.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Player implements Comparable<Player> {

    private final String id;
    private final String name;
    private final LocalDateTime registeredAt;
    private int totalScore;
    private boolean isActive;


    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.registeredAt = LocalDateTime.now();
        this.totalScore = 0;
        this.isActive = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int score) {
        this.totalScore += totalScore;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public int compareTo(Player o) {
        int compare = Integer.compare(o.totalScore, this.totalScore);
        if (compare == 0) {
            return this.name.compareTo(o.name);
        } else {
            return compare;
        }
    }
}
