import javax.swing.ImageIcon;

/**
 * A Movable GameObject
 * 
 * @author Elizabeth
 *
 */
public abstract class GameEntity extends GameObject implements Movable {
    //the initial location of the GameEntity
    private Location origin;
    //the direction the entity is facing
    private int facingDirection;

    /**
     * Creates a GameEntity at the given location with the given image
     * 
     * @param location the initial location of the entity
     * @param image  the image of the entity to be drawn
     */
    public GameEntity(Location location, ImageIcon image) {
	 	super(location,image);
	 	origin = location.clone();
    }

    //move the Game entity by 1 unit in the direction it
    //is facing - remember, only move it if it results in
    //a valid location (ie, not a wall)
    @Override
    public void move(Level level) {
    	Location next;
    	switch (facingDirection) {
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
	 	if (level.isValidLocation(next)) {
	 		location.moveByDirection(facingDirection);
		}
	 	else{
	 		turnRight();
	 	}
    }

    @Override
    public boolean collide(GameObject object) {
	 	if (location.equals(object.getLocation())) {
			return true;
		} else {
			return false;
		}
    }

    @Override
    public int getFacingDirection() {
	 	return facingDirection;
    }

    @Override
    public void setFacingDirection(int direction) {
	 	facingDirection = direction;
    }

    /**
     * Moves the GameEntity back to where it initially started
     */
    public void moveToOrigin() {
	 	location = origin.clone();
    }

    /**
     * Turns the GameEntity. A turn can be right or left, and
     * results in a change of the Entity's facing direction. For example,
     * if the GameEntity was facing North, and it executed a right turn, it should
     * now be facing East.
     * 
     * @param right
     */
    public void turn(boolean right) {
    	
    	if(right) {
    		turnRight();
    	}
    	else{
    		turnRight();
    		turnRight();
    		turnRight();
    	}
    	
    }

    /*
     * A helper methods for turning right - think about how you can use
     * this method to execute both right and left turns 
     */
    private void turnRight() {
    	switch (facingDirection) {
	    	case(Movable.NORTH): 
		 		facingDirection = Movable.EAST;
		 		break;
	    	case(Movable.EAST): 
		 		facingDirection = Movable.SOUTH;
		 		break;
		 	case(Movable.SOUTH): 
		 		facingDirection = Movable.WEST;
		 		break;
		 	case(Movable.WEST): 
		 		facingDirection = Movable.NORTH;
		 		break;
    	}
    	
    }
}
