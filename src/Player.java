/**
 * Creates GUI and TicTacToeLogic class object
 * @author Nick Natali
 * @author Renden Yoder
 */
public class Player implements Comparable{
    private String name;
    private int wins = 0;
    private int losses = 0;


    /**
     * Constructor to create a player object
     * @param name sets the name of the player
     */
    public Player(String name) {
        this.name = name;
    }


    /**
     * Adds to the player's wins
     */
    public void addWin() {
        wins += 1;
    }


    /**
     * Adds to the player's losses
     */
    public void addLoss() { losses += 1; }


    /**
     * Gets the players name
     * @return the name of the player
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the player
     * @param name sets the name of the player to this variables value
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the current wins of the player
     * @return the player's wins
     */
    public int getWins() {
        return wins;
    }


    /**
     * Gets the current losses of the player
     * @return the player's losses
     */
    public int getLosses() {
        return losses;
    }


    /**
     * Resets this players wins, losses, and name
     */
    public void reset() {
        wins = 0;
        losses = 0;
        name = "";
    }


    /**
     * Checks if an object is equal to this player object
     * @param obj object to be compared to this player object
     * @return true/false if they are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if(this.getClass() == obj.getClass()){
            Player other = (Player)obj;
            return this.name.equals(other.name) && this.wins == other.wins && this.losses == other.losses;
        }
        return false;
    }


    /**
     * Creates a clone of this player object
     * @return a Player object that is a clone of this Player object
     */
    @Override
    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }


    /**
     * Creates a hashcode of this Player object
     * @return an integer value of the hashcode
     */
    @Override
    public int hashCode() {
        int hashcode = 31;
        hashcode *= name.hashCode();
        hashcode *= wins;
        hashcode *= losses;
        return hashcode;
    }


    /**
     * Compares an object to this Player object
     * @param obj a given object to compare this Player object too
     * @return an integer value of as too whether if this player is greater, less than, or equal
     */
    @Override
    public int compareTo(Object obj) {
        if(this.getClass() == obj.getClass()){
            Player other = (Player)obj;
            if(other.wins != wins)
                return (other.wins - wins);
            else
                return other.name.length() - name.length();
        }
        return -1;
    }
}
