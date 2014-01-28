/**
 * A Cherry in the game of pacman - a cherry makes
 * pacman invincible for a short period of time when
 * it is picked up.
 * 
 * @author Elizabeth
 *
 */
public class Cherry extends GameItem {
    //the value of all cherries
    private static final int VALUE = 5;
    
    /**
     * Creates a new cherry at the given location
     * @param location
     */
    public Cherry(Location location){
	 	super(location,PacmanGamePanel.CHERRY_IMAGE,VALUE);
    }
}       
