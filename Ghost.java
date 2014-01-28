import java.util.Random;

/**
 * A Ghost in the game of Pacman.
 * 
 * @author Elizabeth
 *
 */
public class Ghost extends GameEntity {
    private Random rand;
    
    /**
     * Creates a Ghost at the specified location
     * 
     * @param location the location at which the Ghost is created
     */
    public Ghost(Location location){
	 	super(location,PacmanGamePanel.GHOST_IMAGE);
	 	rand = new Random();
    }
    
    /*
     * handle what happens when a ghost runs into pacman
     *
     * if pacman is invincible, the ghost should be moved back to it's
     * origin point.
     * 
     */
    @Override
    public boolean collide(GameObject object) {
    	boolean collision = super.collide(object);
	 	if(object instanceof Pacman && ((Pacman)object).isInvincible() && collision) {
	 		this.moveToOrigin(); 
		}
	 	else if(object instanceof Pacman && collision) {
	 		((Pacman)object).moveToOrigin();
			((Pacman)object).loseLife();
		}
		return collision;
    }

    /*
     * Ghosts move in a special way, so we need to override the move defined in
     * GameEntity.
     * 
     * When move is called, a Ghost should have an 80% chance of actually moving.
     * 
     * If it can continue going in the direction it is facing, it should move that way.
     * 
     * If not, it should pick a way to turn (right or left), and turn until it can move in 
     * the direction it is facing.		
     */
    @Override
    public void move(Level level) {
    	Location next;
    	int ans = rand.nextInt(5);
    	switch (getFacingDirection()) {
			case (Movable.NORTH):
				next = new Location(location.getRow()-1, location.getCol());
				break;
			case (Movable.EAST):
				next = new Location(location.getRow(), location.getCol()+1);
				break;
			case (Movable.SOUTH):
				next = new Location(location.getRow()+1, location.getCol());
				break;
			case (Movable.WEST):
				next = new Location(location.getRow(), location.getCol()-1);
				break;
			default: next = location.clone();
    	}
		if (level.isValidLocation(next) && ans<4) {
    		location.moveByDirection(getFacingDirection());
    	}
    	else {
    		turn(rand.nextBoolean());
    		move(level);
    	}
    	
    }

}
