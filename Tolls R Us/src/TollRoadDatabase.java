/* A few useful items are provided to you. You must write the rest. */

public class TollRoadDatabase {
    /**
     * For printing floating point values in dollar/cents format. Example:
     * System.out.println( String.format( DOLLAR_FORMAT, 10.5 );  // $10.50
     */
    private static final String DOLLAR_FORMAT = "$%5.2f";
    private static final String SPEED_FORMAT = "%5.1f MpH";

    /**
     * Universal new line
     */
    private static final String NL = System.lineSeparator();

    /**
     * Conversion constant from minutes to hours
     */
    public static final double MINUTES_PER_HOUR = 60.0;

    /**
     * This toll road's speed limit, in miles per hour
     */
    public static final double SPEED_LIMIT = 65.0;

    /**
     * reads the event file and builds all data structures needed
     * @param eventFileName
     * will raise FileNotFoundExcpetion if file param cannot be found
     */
    public TollRoadDatabase(String eventFileName) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(eventFileName));

    }

    /**
     *
     * @param tag the vehicle tag
     * @param exit the exit used
     * @param time the time when exit used
     */
    private void enterEvent(String tag, int exit, int time){

    }

    /**
     * prints out the number of completed trips
     */
    public void summaryReport(){


    }

    /**
     * print out a report listing the vehicles that are still on the toll road
     */
    public void onRoadReport(){

    }

    /**
     * prints out a billing report for the vehicles that completed trips on the
     * toll roads
     */
    public void printBills(){

    }

    private double bill(String tag){

    }

    /**
     * List cars going above the speed limit
     */
    public void speederReport(){

    }

    /**
     * print the summary information for a single customer
     * @param tag the tag of the vehicle of the customer
     */
    public void printCustSummary(String tag){

    }

    /**
     * print all toll records
     * @param exit the customers on and off point
     */
    public void printExitActivity(int exit){

    }
}
