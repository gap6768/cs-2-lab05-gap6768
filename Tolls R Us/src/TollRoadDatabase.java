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

    private TreeMap<String, ArrayList<TollRecord>> tree;

    private ArrayList<TollRecord> completed;

    /**
     * reads the event file and builds all data structures needed
     * @param eventFileName
     * will raise FileNotFoundExcpetion if file param cannot be found
     */
    public TollRoadDatabase(String eventFileName) throws FileNotFoundException{
        this.tree = new TreeMap<>();
        this.completed = new ArrayList<>();
        Scanner scanner = new Scanner(new File(eventFileName));
        String s;
        while (scanner.hasNextLine()){
            s = scanner.nextLine();
            String[] spl = s.split(",");
            enterEvent(spl[1],Integer.parseInt(spl[2]),Integer.parseInt(spl[0]));
        }
        scanner.close()
    }

    /**
     *Creates toll event
     * @param tag the vehicle tag
     * @param exit the exit used
     * @param time the time when exit used
     */
    private void enterEvent(String tag, int exit, int time){
        int chng = 0;
        for(String j:this.tree.keySet()) {
            if (j.equals(tag)) {
                for (TollRecord k : tree.get(j)) {
                    if (tree.getOffExit() == -1) {
                        t.setOffExit(exit, time);
                        chng++;
                        break
                    }
                }
            }
        }
        if(chng == 0) {
            TollRecord t = new TollRecord(tag, exit, time);
            if(tree.get(tag) == null){
                ArrayList<TollRecord> tagArray = new ArrayList<>;
                tagArray.add(t);
                tree.put(tag, tagArray);
            }
            else {
                tree.get(tag).add(t);
            }
        }
    }

    /**
     * prints out the number of completed trips
     */
    public void summaryReport(){
        int tot = 0;
        for(String j:tree.keySet()){
            for(TollRecord k:tree.get(j)){
                if(k.getOffExit != -1){
                    tot++;
                    this.completed.add(k);
                }
            }
        }
        System.out.println(tot + "completed trips.")
    }

    /**
     * print out a report listing the vehicles that are still on the toll road
     */
    public void onRoadReport(){
        for(String j:tree.keySet()){
            for(TollRecord k:tree.get(j)){
                if(k.getOffExit == -1){
                    System.out.println(k.report());
                }
            }
        }
    }

    /**
     * prints out a billing report for the vehicles that completed trips on the
     * toll roads
     */
    public void printBills(){
        for(TollRecord j:completed){
            System.out.println(j.report() +": $" +j.getFare());
        }
    }

    private double bill(String tag){
        double tot = 0;
        for (TollRecord j : completed){
            if(j.getTag().equals(tag)){
                tot += j.getFare();
            }
        }
        return tot;
    }

    /**
     * List cars going above the speed limit
     */
    public void speederReport(){
        double exit1 = 0;
        double exit2 = 0;
        for (TollRecord j : completed){
            exit1 = TollSchedule.getLocation(j.getOnExit());
            exit2 = TollSchedule.getLocation(j.getOffExit());
            if((exit2 - exit1) / ((j.getOnTime() - j.getOffTime)/MINUTES_PER_HOUR) > SPEED_LIMIT){
                System.out.println(j.getTag());
            }
        }
    }

    /**
     * print the summary information for a single customer
     * @param tag the tag of the vehicle of the customer
     */
    public void printCustSummary(String tag){
        for(TollRecord j : completed){
            if(j.getTag().equals(tag)){
                System.out.println(t.getFare());
            }
        }
        System.out.println(bill(tag));
    }

    /**
     * print all toll records
     * @param exit the customers on and off point
     */
    public void printExitActivity(int exit){
        for(String j : this.tree.keySet()){
            for(TollRecord k : tree.get(j)){
                if(k.getOnExit() == exit || k.getOffExit() == exit){
                    Syste.out.println(k.report());
                }
            }
        }
    }
}
