/**
 * A pellet in the game of pacman
 * 
 * @author Elizabeth
 *
 */
public class Pellet extends GameItem {
    private final static int VALUE = 1;
    
    /**
     * Creates a new pellet at the given location
     * 
     * @param location the location at which the pellet is created
     */
    public Pellet(Location location){
	 	super(location,PacmanGamePanel.PELLET_IMAGE,VALUE);
    }
    
    
}
