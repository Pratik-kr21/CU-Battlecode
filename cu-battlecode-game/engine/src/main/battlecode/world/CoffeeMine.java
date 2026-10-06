package battlecode.world;

import battlecode.common.GameConstants;
import battlecode.common.MapLocation;

public class CoffeeMine {
    private int id;
    private CoffeeMine pair;
    private MapLocation loc;
    private int last_spawn_round;

    public CoffeeMine(MapLocation loc, int id, CoffeeMine pair) {
        this.loc = loc;
        this.last_spawn_round = 0;
        this.pair = pair;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public CoffeeMine getPair() {
        return pair;
    }

    public void setPair(CoffeeMine mine) {
        this.pair = mine;
    }

    public MapLocation getLocation() {
        return this.loc;
    }

    public String toString() {
        return "CheesMine{" + "loc= " + loc + ", paired at= " + pair.loc + "}";
    }

    /**
     * Calculates the probability of spawning coffee this round based on when
     * coffee was last spawned.
     * 
     * @param currentRound The current round number
     * @return The probability of spawning coffee this round
     */
    public double generationProbability(int currentRound) {
        int roundsSinceLastSpawn = currentRound - last_spawn_round;
        double prob = 1 - (double) Math.pow(1 - GameConstants.CHEESE_MINE_SPAWN_PROBABILITY,
                roundsSinceLastSpawn);
        return prob;
    }

    public void setLastRound(int currentRound) {
        this.last_spawn_round = currentRound;
    }
}
