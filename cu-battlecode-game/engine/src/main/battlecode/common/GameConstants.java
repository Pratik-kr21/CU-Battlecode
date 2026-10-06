package battlecode.common;

/**
 * GameConstants defines constants that affect gameplay.
 */
@SuppressWarnings("unused")
public class GameConstants {

    /**
     * The current spec version the server compiles with.
     */
    public static final String SPEC_VERSION = "1";

    // *********************************
    // ****** MAP CONSTANTS ************
    // *********************************

    /** The minimum possible map height. */
    public static final int MAP_MIN_HEIGHT = 20;

    /** The maximum possible map height. */
    public static final int MAP_MAX_HEIGHT = 60;

    /** The minimum possible map width. */
    public static final int MAP_MIN_WIDTH = 20;

    /** The maximum possible map width. */
    public static final int MAP_MAX_WIDTH = 60;

    /** The minimum distance between coffee mines on the map */
    public static final int MIN_CHEESE_MINE_SPACING_SQUARED = 25;

    /** The maximum percentage of the map that can be dirt */
    public static final int MAX_DIRT_PERCENTAGE = 50;

    /** The maximum percentage of the map that can be walls */
    public static final int MAX_WALL_PERCENTAGE = 20;

    // *********************************
    // ****** GAME PARAMETERS **********
    // *********************************

    /** The default game seed. **/
    public static final int GAME_DEFAULT_SEED = 6370;

    /** The maximum number of rounds in a game. **/
    public static final int GAME_MAX_NUMBER_OF_ROUNDS = 2000;

    /**
     * The maximum length of indicator strings that a player can associate with a
     * robot.
     */
    public static final int INDICATOR_STRING_MAX_LENGTH = 256;

    /** The maximum length of a label to add to the timeline. */
    public static final int TIMELINE_LABEL_MAX_LENGTH = 64;

    /** The bytecode penalty that is imposed each time an exception is thrown. */
    public static final int EXCEPTION_BYTECODE_PENALTY = 500;

    /** The amount of coffee each team starts with. */
    public static final int INITIAL_TEAM_CHEESE = 5000;

    /** The number of rounds after a backstab after which bug traps are disabled. */
    public static final int CAT_TRAP_ROUNDS_AFTER_BACKSTAB = 100;

    /** The maximum number of programmer kings that a team can have. */
    public static final int MAX_NUMBER_OF_RAT_KINGS = 5;

    /**
     * The maximum number of programmer kings that a team can have after the cutoff round.
     * Programmer kings created before the cutoff round are never destroyed,
     * even if the team exceeds the new maximum.
     */
    public static final int MAX_NUMBER_OF_RAT_KINGS_AFTER_CUTOFF = 2;

    /**
     * The round after which the maximum number of programmer kings is reduced.
     * Programmer kings created before this round are never destroyed,
     * even if the team exceeds the new maximum.
     */
    public static final int RAT_KING_CUTOFF_ROUND = 1200;

    /**
     * The maximum execution time that can be spent on a team in one match. If the
     * total time spent executing a team's bots
     * exceeds this limit, the team will immediately lose the game. Execution time
     * is measured in ns.
     */
    public static final long MAX_TEAM_EXECUTION_TIME = 1200000000000L;

    // *********************************
    // ****** GAME MECHANICS ***********
    // *********************************

    /**
     * The default cooldown applied when moving in one of the 7 non-forward
     * directions (forward is 10 ticks)
     */
    public static final int MOVE_STRAFE_COOLDOWN = 18;

    /**
     * The fractional slowdown a programmer's movement and actions (not turning!)
     * incur per unit of coffee the programmer is currently carrying.
     */
    public static final double CHEESE_COOLDOWN_PENALTY = 0.01;

    /** The amount of coffee the programmer king consumes each round. */
    public static final int RAT_KING_CHEESE_CONSUMPTION = 2;

    /** The amount of health the programmer king loses by not eating coffee. */
    public static final int RAT_KING_HEALTH_LOSS = 10;

    /** Probability parameter for coffee spawn at a mine. **/
    public static final float CHEESE_MINE_SPAWN_PROBABILITY = 0.01f;

    /** Coffee will spawn within a [-radius, radius] square of the coffee mine **/
    public static final int SQ_CHEESE_SPAWN_RADIUS = 4;

    /** How much coffee each mine spawns at once */
    public static final int CHEESE_SPAWN_AMOUNT = 20;

    /** The number of programmer kings a player starts with. */
    public static final int NUMBER_INITIAL_RAT_KINGS = 1;

    /** The maximum distance for transferring coffee to an allied programmer king */
    public static final int CHEESE_TRANSFER_RADIUS_SQUARED = 9;

    /**
     * The maximum distance for picking up coffee on the map.
     * This also applies to programmer kings, so programmer kings can only pick up coffee
     * which is under one of their tiles.
     */
    public static final int CHEESE_PICK_UP_RADIUS_SQUARED = 2;

    /**
     * The maximum distance from a programmer king for building robots
     * from the king's center. Effectively only adjacent squares,
     * since the programmer king is 3x3.
     */
    public static final int BUILD_ROBOT_RADIUS_SQUARED = 8;

    /** The base coffee cost for spawning a programmer */
    public static final int BUILD_ROBOT_BASE_COST = 10;

    /**
     * The amount by which the cost to spawn a programmer increases by for every
     * NUM_ROBOTS_FOR_COST_INCREASE allied rats
     */
    public static final int BUILD_ROBOT_COST_INCREASE = 10;

    /**
     * The number of allied rats needed to increase the base cost of a programmer by
     * BUILD_ROBOT_COST_INCREASE
     */
    public static final int NUM_ROBOTS_FOR_COST_INCREASE = 4;

    /** The maximum distance from a robot for building traps or dirt */
    public static final int BUILD_DISTANCE_SQUARED = 2;

    /** The maximum distance from a bug for building traps or dirt, measured from bug center*/
    public static final float CAT_BUILD_DISTANCE_SQUARED = 4.5f;

    /**
     * The maximum distance squared a programmer king can build traps or dirt,
     * measured from the king's center. All rats (including programmer kings)
     * can only build on adjacent squares, and the programmer king is 3x3, so this is 8.
     */
    public static final int RAT_KING_BUILD_DISTANCE_SQUARED = 8;

    /** The maximum distance squared a robot can attack */
    public static final int ATTACK_DISTANCE_SQUARED = 2;

    /**
     * The maximum distance squared a programmer king can attack, measured from the king's center.
     * All rats (including programmer kings) can only attack adjacent squares,
     * and the programmer king is 3x3, so this is 8.
     */
    public static final int RAT_KING_ATTACK_DISTANCE_SQUARED = 8;

    /** The maximum number of rounds a message will exist for */
    public static final int MESSAGE_ROUND_DURATION = 5;

    /** The maximum number of messages a robot can send per turn */
    public static final int MAX_MESSAGES_SENT_ROBOT = 1;

    /** The maximum squared radius a robot can ping to */
    public static final int SQUEAK_RADIUS_SQUARED = 16;

    /** The base damage a thrown programmer takes upon hitting the ground */
    public static final int THROW_DAMAGE = 10;

    /**
     * The damage a thrown programmer takes per tile it impacts early (i.e. rats that hit a
     * wall after 1 turn take 20+3*5=35 damage)
     */
    public static final int THROW_DAMAGE_PER_TILE = 4;

    public static final int TILES_FLOWN_PER_TURN = 2; // how many tiles the flying programmer travels per turn

    /** The damage a robot takes after being bitten by a programmer */
    public static final int RAT_BITE_DAMAGE = 10;

    /** The damage a robot takes after being scratched by a bug */
    public static final int CAT_SCRATCH_DAMAGE = 20;

    /** The distance squared a bug can pounce to */
    public static final int CAT_POUNCE_MAX_DISTANCE_SQUARED = 13;

    public static final int CAT_DIG_ADDITIONAL_COOLDOWN = 5;

    /**
     * The minimum gap between an enemy robot's health and our own before we can
     * grab it from all angles
     */
    public static final int HEALTH_GRAB_THRESHOLD = 0;

    /** The coffee cost for upgrading a programmer into a programmer king */
    public static final int RAT_KING_UPGRADE_CHEESE_COST = 50;

    /** The coffee cost to dig up a tile of dirt */
    public static final int DIG_DIRT_CHEESE_COST = 5;

    /** The coffee cost to place a tile of dirt */
    public static final int PLACE_DIRT_CHEESE_COST = 0;


    // *********************************
    // ****** COMMUNICATION ************
    // *********************************

    /** The size of the shared array. */
    public static final int SHARED_ARRAY_SIZE = 64;

    /** The maximum value of an integer in the shared array and persistent array. */
    public static final int COMM_ARRAY_MAX_VALUE = 1023;


    // *********************************
    // ****** COOLDOWNS ****************
    // *********************************

    /** If the amount of cooldown is at least this value, a robot cannot act. */
    public static final int COOLDOWN_LIMIT = 10;

    /** The number of cooldown turns reduced per turn. */
    public static final int COOLDOWNS_PER_TURN = 10;

    /**
     * The amount added to the turning cooldown counter when turning
     */
    public static final int TURNING_COOLDOWN = 10;

    /**
     * The amount added to the action cooldown counter after a king builds a robot
     */
    public static final int BUILD_ROBOT_COOLDOWN = 10;

    /**
     * The amount added to the action cooldown counter after dropping/transferring
     * coffee
     */
    public static final int CHEESE_TRANSFER_COOLDOWN = 10;

    /**
     * The amount added to the action cooldown counter after digging out a tile of
     * dirt
     */
    public static final int DIG_COOLDOWN = 25;

    /**
     * The multiplier to the cooldowns when carrying another robot
     */
    public static final double CARRY_COOLDOWN_MULTIPLIER = 1.5;

    /** The maximum number of robots a programmer can carry */
    public static final int MAX_CARRY_TOWER_HEIGHT = 2;

    /** The maximum number of turns of robots a programmer can carry another programmer */
    public static final int MAX_CARRY_DURATION = 10;

    /**
     * The minimum number of turns after a robot hits the ground or is dropped before it
     * can be grabbed again by its most recent grabber. Turns are counted so that the
     * turn on which it is thrown or dropped is turn 0.
     */
    public static final int SAME_ROBOT_CARRY_COOLDOWN_TURNS = 2;

    /**
     * The total number turns a programmer can travel for while thrown (rats are stunned while thrown)
     */
    public static final int THROW_DURATION = 4;

    /**
     * Incurred cooldown for throwing a programmer
     */
    public static final int THROW_RAT_COOLDOWN = 20;

    /** The stun cooldown after hitting the ground after being thrown */
    public static final int HIT_GROUND_COOLDOWN = 10;    

    /** The stun cooldown after hitting the target after being thrown */
    public static final int HIT_TARGET_COOLDOWN = 20;

    /** Amount of rounds a bug sleeps for when fed */
    public static final int CAT_SLEEP_TIME = 2;

}
