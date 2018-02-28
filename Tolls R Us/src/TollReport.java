/**
 * A class that will hold the main class and run
 * the program
 *
 * @author Gino Placella
 */
public class TollReport extends{

    public static void main(String[] args) throws FileNotFoundExcpetion{
        TollRoadDatabase trd = new TollRoadDatabase(args[0]);
        trd.summaryReport();
        System.out.println();
        trd.onRoadReport();
        System.out.println();
        trd.speederReport();
        System.out.println();
        trd.printBills();
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strList = str.split(" ");
        while(!(strList[0].equals("q"))){
            System.out.println("'b <string>' to see bill for license tag");
            System.out.println("'e <number>' to see activity at exit");
            System.out.println("'q' to quit");
            if(strList[0].equals("b")){
                trd.printCustSummary(strList[1]);
            }
            else if(strList[0].equals("e")){
                trd.printExitActivity(Integer.parseInt(strList[1]));
            }
        }



    }
}