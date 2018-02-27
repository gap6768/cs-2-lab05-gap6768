/* A few useful items are provided to you. You must write the rest. */

public class TollRecord {

    /**
     * For printing toll records in reports
     * using {@link String#format(String, Object...)}
     */
    private static final String TOLL_RECORD_FORMAT = "[%11s] on #%2d, time %5d";
    private static final String OFF_FORMAT = "; off #%2d, time %5d";
    private String vTag;
    private int numOnExit;
    private int numOnTime;
    private int numOffExit = incomplete;
    private int numOffTime = incomplete;


    /**
     * Value of uninitialized integer fields in this record
     */
    public static final int incomplete = -1;

    /**
     * Create a new TollRecord
     * @param tag vehicle tag
     * @param onExit incoming exit
     * @param onTime incoming time
     */
    public TollRecord(String tag, int onExit, int onTime){
        this.vTag = tag;
        this.numExit = onExit;
        this.numTime = onTime;
    }

    /**
     * record the exit and time at which the vehicle left the highay
     * @param offExit exit which the vehicle left
     * @param offTime the time at which teh vehicle left
     */
    public void setOffExit(int offExit, int offTime){
        this.numOffExit = offExit;
        this.numOffTime = offTime;
    }

    /**
     * gets the tag of the vehicle
     * @return the tag of vehicle
     */
    public String getTag(){
        return this.vTag;
    }

    /**
     * gets the exit on of the vehicle
     * @return the exit number
     */
    public int getOnExit(){
        return this.numExit;
    }

    /**
     * gets the time on of the vehicle
     * @return the time on
     */
    public int getOnTime(){
        return this.numTime;
    }

    /**
     * gets the exit left of the vehicle
     * @return the exit left (-1 if incomplete)
     */
    public int getOffExit(){
        return this.numOffExit;
    }

    /**
     * gets the time left of the vehicle
     * @return the time left (-1 if incomplete)
     */
    public int getOffTime(){
        return this.numOffTime;
    }

    /**
     * gets the fare for the vehicle
     * @return the total fare
     */
    public double getFare(){
        return 0.0;
    }

    /**
     * checks if two TollRecord objects are equal
     * @param o TollRecord Object
     * @return boolean if obects are equal
     */
    public boolean equals(Object o){
        if(o instanceof TollRecord){

        return false;
    }

    /**
     * creates a string of the object
     * @return string representation of the object
     */
    public String toString(){
        return "";
    }

    /**
     * creates a string of the trip report of vehicle
     * @return string represnetation of object
     */
    public String report(){
        return String.format(TOLL_RECORD_FORMAT, this.vTag, this.numOnExit, this.numOnTime) + ";" +
                String.format(OFF_FORMAT, this.numOffExit, this.numOffTime);
    }

    /**
     * checks if the hashcode of the two objects are equal
     * @return a hash code value for the obect that conforms to the
     * definition
     */
    public int hashCode(){
        return 0;
    }

    /**
     * the natural order comparison for TollRecords
     * @param o the TollRecord object
     * @return either negative, positive, or 0 depending on order
     */
    public int compareTo(TollRecord o){
        return 0;
    }

    public static void main(String[] args){

    }

}
