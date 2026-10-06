package battlecode.common;

/**
 * A RobotController allows contestants to make their robot sense and interact
 * with the game world. When a contestant's <code>RobotPlayer</code> is
 * constructed, it is passed an instance of <code>RobotController</code> that
 * controls the newly created robot.
 */
@SuppressWarnings("unused")
public interface RobotController {

    // *********************************
    // ****** GLOBAL QUERY METHODS *****
    // *********************************

    /**
     * Returns the current round number, where round 1 is the first round of the
     * match.
     *
     * @return the current round number, where round 1 is the first round of the
     *         match
     *
     * @battlecode.doc.costlymethod
     */
    int getRoundNum();

    /**
     * Returns the width of the game map. Valid x coordinates range from
     * 0 (inclusive) to the width (exclusive).
     *
     * @return the map width
     *
     * @battlecode.doc.costlymethod
     */
    int getMapWidth();

    /**
     * Returns the height of the game map. Valid y coordinates range from
     * 0 (inclusive) to the height (exclusive).
     *
     * @return the map height
     *
     * @battlecode.doc.costlymethod
     */
    int getMapHeight();

    /**
     * Returns the game state- true if in cooperation mode, false if in backstabbing mode. 
     *
     * @return boolean representing the game state
     *
     * @battlecode.doc.costlymethod
     */
    boolean isCooperation();

    /**
     * Returns the backstabbing team, or null if still in cooperation mode. 
     *
     * @return the team that performed the backstab, or null if still in cooperation mode.
     *
     * @battlecode.doc.costlymethod
     */
    Team getBackstabbingTeam();

    /**
     * Returns the number of active bug traps for the team.
     *
     * @return the number of active bug traps this team has.
     *
     * @battlecode.doc.costlymethod
     */
    int getNumberBugTraps();

    /**
     * Returns the number of active programmer traps for the team.
     *
     * @return the number of active programmer traps this team has.
     *
     * @battlecode.doc.costlymethod
     */
    int getNumberProgrammerTraps();

    // *********************************
    // ****** UNIT QUERY METHODS *******
    // *********************************

    /**
     * Returns the ID of this robot.
     *
     * @return the ID of this robot
     *
     * @battlecode.doc.costlymethod
     */
    int getID();

    /**
     * Returns this robot's Team.
     *
     * @return this robot's Team
     *
     * @battlecode.doc.costlymethod
     */
    Team getTeam();

    /**
     * Returns this robot's designated center location.
     * A bug's designated center is the bottom left corner tile of its 2x2 occupation.
     * A programmer king's designated center is the middle tile of the its 3x3 occupation.
     *
     * @return this robot's designated center location
     *
     * @battlecode.doc.costlymethod
     */
    MapLocation getLocation();

    /**
     * Returns all the locations that a robot occupies 
     * E.g. for a 3x3 programmer king, this returns 9 locations
     *
     * @return array of all locations occupied by a robot
     *
     * @battlecode.doc.costlymethod
     */
    MapLocation[] getAllPartLocations();

    /**
     * Returns this robot's current direction.
     *
     * @return this robot's current direction
     *
     * @battlecode.doc.costlymethod
     */
    Direction getDirection();

    /**
     * Returns this robot's current health.
     *
     * @return this robot's current health
     *
     * @battlecode.doc.costlymethod
     */
    int getHealth();

    /**
     * Returns the amount of coffee the robot is currently holding.
     *
     * @return the amount of coffee the robot is currently holding.
     *
     * @battlecode.doc.costlymethod
     */
    int getRawCheese();

    /**
     * Returns the amount of global coffee available.
     *
     * @return the amount of global coffee available.
     *
     * @battlecode.doc.costlymethod
     */
    int getGlobalCheese();

    /**
     * Returns the amount of coffee the robot has access to.
     *
     * @return the amount of coffee the robot has access to.
     *
     * @battlecode.doc.costlymethod
     */
    int getAllCheese();

    /**
     * Returns the amount of dirt that this robot's team has.
     * 
     * @return the amount of dirt this robot's team has
     * 
     * @battlecode.doc.costlymethod
     */
    int getDirt();

    /**
     * Returns what UnitType this robot is.
     * 
     * @return the UnitType of this robot
     * 
     * @battlecode.doc.costlymethod
     */
    UnitType getType();

    /**
     * Returns robot that this robot is carrying or null if this robot is not carrying another robot.
     * 
     * @return RobotInfo for the carried robot or null.
     * 
     * @battlecode.doc.costlymethod
     */
    RobotInfo getCarrying();

    /**
     * Returns whether robot is being thrown.
     * 
     * @return true if robot is being thrown, false if not
     * 
     * @battlecode.doc.costlymethod
     */
    boolean isBeingThrown();

    /**
     * Returns whether robot is being carried.
     * 
     * @return true if robot is being carried, false if not
     * 
     * @battlecode.doc.costlymethod
     */
    boolean isBeingCarried();


    // ***********************************
    // ****** GENERAL VISION METHODS *****
    // ***********************************

    /**
     * Checks whether a MapLocation is on the map.
     *
     * @param loc the location to check
     * @return true if the location is on the map; false otherwise
     *
     * @battlecode.doc.costlymethod
     */
    boolean onTheMap(MapLocation loc);

    /**
     * Checks whether the given location is within the robot's vision range, and if
     * it is on the map.
     *
     * @param loc the location to check
     * @return true if the given location is within the robot's vision range and is
     *         on the map; false otherwise
     *
     * @battlecode.doc.costlymethod
     */
    boolean canSenseLocation(MapLocation loc);

    /**
     * Checks whether a robot is at a given location. Assumes the location is valid.
     *
     * @param loc the location to check
     * @return true if a robot is at the location
     * @throws GameActionException if the location is not within vision range or on
     *                             the map
     *
     * @battlecode.doc.costlymethod
     */
    boolean isLocationOccupied(MapLocation loc) throws GameActionException;

    /**
     * Checks whether a robot is at a given location. Assume the location is valid.
     *
     * @param loc the location to check
     * @return true if a robot is at the location, false if there is no robot or the
     *         location can not be sensed
     *
     * @battlecode.doc.costlymethod
     */
    boolean canSenseRobotAtLocation(MapLocation loc);

    /**
     * Senses the robot at the given location, or null if there is no robot
     * there.
     *
     * @param loc the location to check
     * @return the robot at the given location
     * @throws GameActionException if the location is not within vision range
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo senseRobotAtLocation(MapLocation loc) throws GameActionException;

    /**
     * Tests whether the given robot exists and if it is within this robot's
     * vision range.
     *
     * @param id the ID of the robot to query
     * @return true if the given robot is within this robot's vision range and
     *         exists;
     *         false otherwise
     *
     * @battlecode.doc.costlymethod
     */
    boolean canSenseRobot(int id);

    /**
     * Senses information about a particular robot given its ID.
     *
     * @param id the ID of the robot to query
     * @return a RobotInfo object for the sensed robot
     * @throws GameActionException if the robot cannot be sensed (for example,
     *                             if it doesn't exist or is out of vision range)
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo senseRobot(int id) throws GameActionException;

    /**
     * Returns all robots within vision radius. The objects are returned in no
     * particular order.
     *
     * @return array of RobotInfo objects, which contain information about all
     *         the robots you saw
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo[] senseNearbyRobots();

    /**
     * Returns all robots that can be sensed within a certain distance of this
     * robot. The objects are returned in no particular order.
     *
     * @param radiusSquared return robots this distance away from the center of
     *                      this robot; if -1 is passed, all robots within vision
     *                      radius are returned;
     *                      if radiusSquared is larger than the robot's vision
     *                      radius, the vision
     *                      radius is used
     * @return array of RobotInfo objects of all the robots you saw
     * @throws GameActionException if the radius is negative (and not -1)
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo[] senseNearbyRobots(int radiusSquared) throws GameActionException;

    /**
     * Returns all robots of a given team that can be sensed within a certain
     * distance of this robot. The objects are returned in no particular order.
     *
     * @param radiusSquared return robots this distance away from the center of
     *                      this robot; if -1 is passed, all robots within vision
     *                      radius are returned;
     *                      if radiusSquared is larger than the robot's vision
     *                      radius, the vision
     *                      radius is used
     * @param team          filter game objects by the given team; if null is
     *                      passed,
     *                      robots from any team are returned
     * @return array of RobotInfo objects of all the robots you saw
     * @throws GameActionException if the radius is negative (and not -1)
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo[] senseNearbyRobots(int radiusSquared, Team team) throws GameActionException;

    /**
     * Returns all robots of a given team that can be sensed within a certain
     * radius of a specified location. The objects are returned in no particular
     * order.
     *
     * @param center        center of the given search radius
     * @param radiusSquared return robots this distance away from the center of
     *                      this robot; if -1 is passed, all robots within vision
     *                      radius are returned;
     *                      if radiusSquared is larger than the robot's vision
     *                      radius, the vision
     *                      radius is used
     * @param team          filter game objects by the given team; if null is
     *                      passed,
     *                      objects from all teams are returned
     * @return array of RobotInfo objects of the robots you saw
     * @throws GameActionException if the radius is negative (and not -1) or the
     *                             center given is null
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo[] senseNearbyRobots(MapLocation center, int radiusSquared, Team team) throws GameActionException;

    /**
     * Given a senseable location, returns whether that location is passable (i.e. no wall or dirt)
     * 
     * @param loc the given location
     * @return whether that location is passable
     * @throws GameActionException if the robot cannot sense the given location
     *
     * @battlecode.doc.costlymethod
     */
    boolean sensePassability(MapLocation loc) throws GameActionException;

    /**
     * Senses the map info at a location.
     * MapInfo includes passability, flying robots, walls, dirt, traps, coffee mines, and coffee.
     * 
     * @param loc to sense map at
     * @return MapInfo describing map at location
     * @throws GameActionException if location can not be sensed
     *
     * @battlecode.doc.costlymethod
     */
    MapInfo senseMapInfo(MapLocation loc) throws GameActionException;

    /**
     * Return map info for all senseable locations.
     * MapInfo includes passability, flying robots, walls, dirt, traps, coffee mines, and coffee.
     *
     * @return MapInfo about all locations within vision radius
     *
     * @battlecode.doc.costlymethod
     */
    MapInfo[] senseNearbyMapInfos();

    /**
     * Return map info for all senseable locations within a radius squared.
     * If radiusSquared is larger than the robot's vision radius, uses the robot's
     * vision radius instead. If -1 is passed, all locations within vision radius
     * are returned.
     * MapInfo includes passability, flying robots, walls, dirt, traps, coffee mines, and coffee.
     *
     * @param radiusSquared the squared radius of all locations to be returned
     * @return MapInfo about all locations within vision radius
     * @throws GameActionException if the radius is negative (and not -1)
     *
     * @battlecode.doc.costlymethod
     */
    MapInfo[] senseNearbyMapInfos(int radiusSquared) throws GameActionException;

    /**
     * Return map info for all senseable locations within vision radius of a center
     * location.
     * MapInfo includes passability, flying robots, walls, dirt, traps, coffee mines, and coffee.
     *
     * @param center the center of the search area
     * @return MapInfo about all locations within vision radius
     * @throws GameActionException if center is null
     *
     * @battlecode.doc.costlymethod
     */
    MapInfo[] senseNearbyMapInfos(MapLocation center) throws GameActionException;

    /**
     * Return map info for all senseable locations within a radius squared of a
     * center location.
     * If radiusSquared is larger than the robot's vision radius, uses the robot's
     * vision radius instead. If -1 is passed, all locations within vision radius
     * are returned.
     * MapInfo includes passability, flying robots, walls, dirt, traps, coffee mines, and coffee.
     *
     * @param center        the center of the search area
     * @param radiusSquared the squared radius of all locations to be returned
     * @return MapInfo about all locations within vision radius
     * @throws GameActionException if the radius is negative (and not -1)
     *
     * @battlecode.doc.costlymethod
     */
    MapInfo[] senseNearbyMapInfos(MapLocation center, int radiusSquared) throws GameActionException;

    /**
     * Returns the location adjacent to current location in the given direction.
     *
     * @param dir the given direction
     * @return the location adjacent to current location in the given direction
     *
     * @battlecode.doc.costlymethod
     */
    MapLocation adjacentLocation(Direction dir);

    /**
     * Returns a list of all locations within a distance of a custom center location. 
     * This will only return locations that are sense-able in the calling robot's vision cone.
     * If radiusSquared is larger than the robot's vision radius, uses the robot's
     * vision radius instead. 
     *
     * Checks that radiusSquared is non-negative. 
     *
     * @param center  the given location
     * @param radiusSquared square root of the distance distance away from center location
     * @return list of locations on the map and within radiusSquared squared distance of center
     * @throws GameActionException if the radius is negative (and not -1)
     *
     * @battlecode.doc.costlymethod
     */
    MapLocation[] getAllLocationsWithinRadiusSquared(MapLocation center, int radiusSquared) throws GameActionException;

    // ***********************************
    // ****** READINESS METHODS **********
    // ***********************************

    /**
     * Tests whether the robot can act.
     * 
     * @return true if the robot can act
     *
     * @battlecode.doc.costlymethod
     */
    boolean isActionReady();

    /**
     * Returns the number of action cooldown turns remaining before this unit can
     * act again.
     * When this number is strictly less than {@link GameConstants#COOLDOWN_LIMIT},
     * isActionReady()
     * is true and the robot can act again. This number decreases by
     * {@link GameConstants#COOLDOWNS_PER_TURN} every turn.
     *
     * @return the number of action turns remaining before this unit can act again
     *
     * @battlecode.doc.costlymethod
     */
    int getActionCooldownTurns();

    /**
     * Tests whether the robot can move.
     * 
     * @return true if the robot can move
     *
     * @battlecode.doc.costlymethod
     */
    boolean isMovementReady();

    /**
     * Tests whether the robot can turn.
     * 
     * @return true if the robot can turn
     *
     * @battlecode.doc.costlymethod
     */
    boolean isTurningReady();

    /**
     * Returns the number of movement cooldown turns remaining before this unit can
     * move again.
     * When this number is strictly less than {@link GameConstants#COOLDOWN_LIMIT},
     * isMovementReady()
     * is true and the robot can move again. This number decreases by
     * {@link GameConstants#COOLDOWNS_PER_TURN} every turn.
     *
     * @return the number of cooldown turns remaining before this unit can move
     *         again
     *
     * @battlecode.doc.costlymethod
     */
    int getMovementCooldownTurns();

    /**
     * Returns the number of turning cooldown turns remaining before this unit can
     * turn again.
     * When this number is strictly less than {@link GameConstants#COOLDOWN_LIMIT},
     * isTurningReady()
     * is true and the robot can turn again. This number decreases by
     * {@link GameConstants#COOLDOWNS_PER_TURN} every turn.
     *
     * @return the number of cooldown turns remaining before this unit can move
     *         again
     *
     * @battlecode.doc.costlymethod
     */
    int getTurningCooldownTurns();

    // ***********************************
    // ****** MOVEMENT METHODS ***********
    // ***********************************

    /**
     * Checks whether this robot can move one step in the direction it is facing.
     * Returns false if the robot is not in a mode that can move, if the target
     * location is not on the map, if the target location is occupied, if the target
     * location is impassible, or if there are cooldown turns remaining.
     *
     * @return true if it is possible to call <code>moveForward</code> without an exception
     *
     * @battlecode.doc.costlymethod
     */
    boolean canMoveForward();

    /**
     * Checks whether this robot can move one step in the target direction.
     * Returns false if the robot is not in a mode that can move, if the target
     * location is not on the map, if the target location is occupied, if the target
     * location is impassible, or if there are cooldown turns remaining.
     *
     * @return true if it is possible to call <code>move</code> without an exception
     *
     * @battlecode.doc.costlymethod
     */
    boolean canMove(Direction d);

    /**
     * Moves one step in the direction the robot is facing.
     *
     * @throws GameActionException if the robot cannot move one step in this
     *                             direction, such as cooldown being too high, the
     *                             target location being
     *                             off the map, or the target destination being
     *                             occupied by another robot,
     *                             or the target destination being impassible.
     *
     * @battlecode.doc.costlymethod
     */
    void moveForward() throws GameActionException;

    /**
     * Moves one step in the specified direction. If not facing that direction, a longer cooldown is applied.
     *
     * @throws GameActionException if the robot cannot move one step in this
     *                             direction, such as cooldown being too high, the
     *                             target location being
     *                             off the map, or the target destination being
     *                             occupied by another robot,
     *                             or the target destination being impassible.
     *
     * @battlecode.doc.costlymethod
     */
    void move(Direction d) throws GameActionException;

    /**
     * Checks whether this robot can turn.
     * 
     * @return
     */
    boolean canTurn();

    /**
     * Checks whether this robot can turn to the specified direction.
     * Effectively just canTurn() with an extra check that d is not null
     * and not {@link Direction#CENTER}.
     * 
     * @param d the direction to turn to
     */
    boolean canTurn(Direction d);

    /**
     * Turns to the specified direction 
     * 
     * @param d direction to turn to (cannot be Direction.CENTER)
     * @throws GameActionException
     */
    void turn(Direction d) throws GameActionException;

    // ***********************************
    // *********** BUILDING **************
    // ***********************************

    /**
     * Returns the current coffee cost for an allied programmer king to spawn a programmer.
     * 
     * @return the amount of coffee that would be needed to spawn another programmer
     * 
     * @battlecode.doc.costlymethod
     */
    int getCurrentRatCost();

    /**
     * Checks if a programmer king can spawn a baby programmer at the given location.
     * Rats can spawn within a circle of radius of sqrt(4) of the programmer king.
     * 
     * @param loc the location to spawn the programmer at
     * @return true if programmer can be built at loc
     * 
     * @battlecode.doc.costlymethod
     */
    boolean canBuildRat(MapLocation loc);

    /**
     * Spawns a baby programmer at the given location.
     * Rats can spawn within a circle of radius of sqrt(4) of the programmer king.
     * 
     * @param loc the location to spawn the programmer at
     * 
     * @battlecode.doc.costlymethod
     */
    void buildRat(MapLocation loc) throws GameActionException;

    /**
     * Checks if a programmer can become a programmer king, when 7 allied rats are in the 3x3
     * square
     * centered at this programmer's location and the ally team has 50 coffee.
     * All tiles in the 3x3 square must be passible.
     * 
     * @return true if this programmer can become a programmer king
     * 
     * @battlecode.doc.costlymethod
     */
    boolean canBecomeLeadProgrammer();

    /**
     * Upgrades this programmer into a programmer king if possible, when 7 allied rats are in the
     * 3x3 square
     * centered at this programmer's location and the ally team has 50 coffee.
     * 
     * Other rats in the 3x3 square will be killed.
     * 
     * @battlecode.doc.costlymethod
     */
    void becomeLeadProgrammer() throws GameActionException;

    /**
     * Tests whether this robot can place dirt at the given location.
     * 
     * @param loc the location to place dirt
     * @battlecode.doc.costlymethod
     */
    public boolean canPlaceDirt(MapLocation loc);

    /**
     * Places dirt at the given location.
     * 
     * @param loc the location to place the dirt
     * 
     * @battlecode.doc.costlymethod
     */
    void placeDirt(MapLocation loc) throws GameActionException;

    /**
     * Tests whether this robot can remove dirt from the given location.
     * 
     * @param loc the location to remove dirt from
     * 
     * @battlecode.doc.costlymethod
     */
    public boolean canRemoveDirt(MapLocation loc);

    /**
     * Removes dirt from the given location.
     * 
     * @param loc the location to remove dirt from
     * @throws GameActionException
     * @battlecode.doc.costlymethod
     */
    void removeDirt(MapLocation loc) throws GameActionException;

    /**
     * Tests whether this robot can place a programmer trap at the given location.
     * 
     * @param loc
     * @return whether the robot can place a programmer trap at the specified location
     * 
     * @battlecode.doc.costlymethod
     */
    public boolean canPlaceProgrammerTrap(MapLocation loc);

    /**
     * Places a programmer trap at the given location.
     * 
     * @param loc the location to place programmer trap
     * @throws GameActionException
     * @battlecode.doc.costlymethod
     */
    public void placeProgrammerTrap(MapLocation loc) throws GameActionException;

    /**
     * Tests whether this robot can remove a programmer trap at the given location.
     * 
     * @param loc the location to remove programmer trap
     * @return whether the robot can remove a programmer trap at the given location
     * 
     * @battlecode.doc.costlymethod
     */
    public boolean canRemoveProgrammerTrap(MapLocation loc);

    /**
     * Removes the programmer trap at the given location.
     * 
     * @param loc the location to remove programmer trap
     * @throws GameActionException
     * 
     * @battlecode.doc.costlymethod
     */
    public void removeProgrammerTrap(MapLocation loc) throws GameActionException;

    /**
     * Tests whether this robot can place a bug trap at the given location.
     * 
     * @param loc the location to place bug trap
     * @return whether the robot can place a bug trap at the given location
     * 
     * @battlecode.doc.costlymethod
     */
    public boolean canPlaceBugTrap(MapLocation loc);

    /**
     * Places a bug trap at the given location.
     * 
     * @param loc the location to place bug trap
     * @throws GameActionException
     * @battlecode.doc.costlymethod
     */
    public void placeBugTrap(MapLocation loc) throws GameActionException;

    /**
     * Tests whether this robot can remove a bug trap at the given location.
     * 
     * @param loc the location to remove bug trap
     * @return whether the robot can remove a bug trap at the given location
     * @battlecode.doc.costlymethod
     */
    public boolean canRemoveBugTrap(MapLocation loc);

    /**
     * Removes the bug trap at the given location.
     * 
     * @param loc the location to remove bug trap
     * @throws GameActionException
     * @battlecode.doc.costlymethod
     */
    public void removeBugTrap(MapLocation loc) throws GameActionException;

    /**
     * Tests whether this robot can pick up coffee at the given location.
     * 
     * @param loc the location to pick up coffee from
     * @return whether the robot can pick up coffee at the given location
     * 
     * @battlecode.doc.costlymethod
     */
    public boolean canPickUpCoffee(MapLocation loc);

    /**
     * picks up coffee from the given location.
     * 
     * @param loc the location to pick up coffee from
     * @throws GameActionException
     * 
     * @battlecode.doc.costlymethod
     */
    void pickUpCoffee(MapLocation loc) throws GameActionException;

    /**
     * Picks up the (non-negative) specified amount of coffee
     * from the given location.
     * 
     * @param loc the location to pick up coffee from
     * @param pickUpAmount the amount of coffee to pick up
     * @throws GameActionException
     * 
     * @battlecode.doc.costlymethod
     */
    void pickUpCoffee(MapLocation loc, int pickUpAmount) throws GameActionException;

    // ****************************
    // ***** ATTACK / HEAL ********
    // ****************************

    /**
     * Tests whether this robot can attack (aka bite) the given location.
     *
     * @param loc target location to attack (bite)
     * @return whether it is possible to attack the given location
     *
     * @battlecode.doc.costlymethod
     */
    boolean canAttack(MapLocation loc);

    /**
     * Tests whether this robot can attack (bite) the given location with the given amount of coffee.
     *
     * @param loc target location to attack (bite)
     * @param cheeseAmount amount of coffee to spend on the attack
     * @return whether it is possible to attack the given location with this coffee amount
     *
     * @battlecode.doc.costlymethod
     */
    boolean canAttack(MapLocation loc, int cheeseAmount);

    /**
     * Performs a programmer attack (aka bite) action, defaulting to a bite with no coffee for rats
     *
     * @param loc the target location to attack
     * @throws GameActionException if conditions for attacking are not satisfied
     *
     * @battlecode.doc.costlymethod
     */
    void attack(MapLocation loc) throws GameActionException;

    /**
     * Performs the specific attack for this robot type, consuming the specified amount of coffee 
     * for increasing bite strength
     *
     * @param loc the target location to attack
     * @param cheeseAmount amount of coffee to spend on the attack
     * @throws GameActionException if conditions for attacking are not satisfied
     *
     * @battlecode.doc.costlymethod
     */
    void attack(MapLocation loc, int cheeseAmount) throws GameActionException;

    // ***********************************
    // ****** COMMUNICATION METHODS ******
    // ***********************************

    /**
     * Sends a message (contained in an int, so 4 bytes) to all locations within
     * squeaking range.
     * 
     * @param messageContent an int representing the content of the
     *                       message (up to 4 bytes)
     * @return true if ping was sent, false if not (i.e. if reached max. number of messages fo this turn)
     * @battlecode.doc.costlymethod
     */
    boolean ping(int messageContent);

    /**
     * Reads all squeaks sent to this unit within the past 5 rounds if roundNum =
     * -1, or only
     * squeaks sent from the specified round otherwise
     * 
     * @param roundNum the round number to read messages from, or -1 to read all
     *                 messages in the queue
     * @return All messages of the specified round, or all messages from the past 5
     *         round.
     * 
     * @battlecode.doc.costlymethod
     */
    Message[] readSqueaks(int roundNum);

    /**
     * Writes a value to the shared array at the given index.
     * This is only allowed for programmer kings.
     * 
     * @param index the index to write to, between 0 and 63
     * @param value the value to write in the index (must be between 0 and 1023)
     * @throws GameActionException if the action is invalid
     * 
     * @battlecode.doc.costlymethod
     */
    void writeSharedArray(int index, int value) throws GameActionException;

    /**
     * Reads a value from the shared array at the given index.
     * All rats and programmer kings can read from the shared array.
     * 
     * @param index the index to read from, between 0 and 63
     * @return the value stored at the given index (between 0 and 1023)
     * @throws GameActionException if the action is invalid
     * 
     * @battlecode.doc.costlymethod
     */
    int readSharedArray(int index) throws GameActionException;

    // ***********************************
    // ****** OTHER ACTION METHODS *******
    // ***********************************

    /**
     * Tests whether you can transfer coffee to a given programmer king.
     * 
     * You can give coffee to an allied programmer king if you are a programmer, can act
     * at the given location, and have enough raw coffee in your local stash.
     * 
     * @param loc    the location of the programmer king to transfer coffee to
     * @param amount the amount of coffee to transfer. Positive to give coffee.
     * @return true if the robot can transfer coffee to a programmer king at the given
     *         location
     */
    boolean canTransferCoffee(MapLocation loc, int amount);

    /**
     * Transfers coffee to a given programmer king.
     * 
     * You can give coffee to an allied programmer king if you are a programmer, can act
     * at the given location, and have enough raw coffee in your local stash.
     * 
     * @param loc    the location of the programmer king to transfer coffee to
     * @param amount the amount of coffee to transfer. Positive to give coffee.
     */
    void transferCoffee(MapLocation loc, int amount) throws GameActionException;

    /**
     * Throws robot in the robot's facing direction
     * 
     * @throws GameActionException if the robot is not able to throw the programmer
     * 
     * @battlecode.doc.costlymethod
     */
    void throwProgrammer() throws GameActionException;

    /**
     * Tests whether the robot can throw a carried robot
     * 
     * @return whether robot can throw a carried robot
     *
     */
    boolean canThrowProgrammer();

    /**
     * Safely drops robot in the specified direction
     * 
     * @param dir direction to drop programmer
     * @battlecode.doc.costlymethod
     */
    void dropProgrammer(Direction dir) throws GameActionException;

    /**
     * Tests whether this robot can safely drop a carried robot in the specified
     * direction.
     * 
     * @param dir direction to drop off carried robot
     * @return whether this robot can drop a carried robot in the specified direction
     * 
     * @battlecode.doc.costlymethod
     */
    boolean canDropProgrammer(Direction dir);

    /**
     * Tests whether the robot can grab (carry) a robot at the specified location.
     *
     * @param loc the location to grab from (must be adjacent)
     * @return true if this robot can pick up a robot at loc
     */
    boolean canCarryProgrammer(MapLocation loc);

    /**
     * Causes this robot to pick up (grab) a robot at the specified location.
     *
     * @param loc the location to pick up from (must be adjacent)
     * @throws GameActionException if this robot cannot pick up the target
     */
    void carryProgrammer(MapLocation loc) throws GameActionException;

    /**
     * Destroys the robot.
     *
     * @battlecode.doc.costlymethod
     **/
    void disintegrate();

    /**
     * Causes your team to lose the game. It's like typing "gg."
     *
     * @battlecode.doc.costlymethod
     */
    void resign();

    // ***********************************
    // ******** DEBUG METHODS ************
    // ***********************************

    /**
     * Sets the indicator string for this robot for debugging purposes. Only the
     * first
     * {@link GameConstants#INDICATOR_STRING_MAX_LENGTH} characters are used.
     *
     * @param string the indicator string this round
     *
     * @battlecode.doc.costlymethod
     */
    void setIndicatorString(String string);

    /**
     * Draw a dot on the game map for debugging purposes.
     *
     * @param loc   the location to draw the dot
     * @param red   the red component of the dot's color
     * @param green the green component of the dot's color
     * @param blue  the blue component of the dot's color
     * @throws GameActionException if the location is off the map
     *
     * @battlecode.doc.costlymethod
     */
    void setIndicatorDot(MapLocation loc, int red, int green, int blue) throws GameActionException;

    /**
     * Draw a line on the game map for debugging purposes.
     *
     * @param startLoc the location to draw the line from
     * @param endLoc   the location to draw the line to
     * @param red      the red component of the line's color
     * @param green    the green component of the line's color
     * @param blue     the blue component of the line's color
     * @throws GameActionException if any location is off the map
     *
     * @battlecode.doc.costlymethod
     */
    void setIndicatorLine(MapLocation startLoc, MapLocation endLoc, int red, int green, int blue)
            throws GameActionException;

    /**
     * Adds a marker to the timeline at the current
     * round for debugging purposes.
     * Only the first
     * {@link GameConstants#TIMELINE_LABEL_MAX_LENGTH} characters are used.
     * 
     * @param label the label for the timeline marker
     * @param red   the red component of the marker's color
     * @param green the green component of the marker's color
     * @param blue  the blue component of the marker's color
     * 
     * @battlecode.doc.costlymethod
     */
    void setTimelineMarker(String label, int red, int green, int blue);
}
