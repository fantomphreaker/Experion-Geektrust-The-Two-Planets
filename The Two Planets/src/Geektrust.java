import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Geektrust { //Main class
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\LENOVO\\IdeaProjects\\The Two Planets\\input.txt"); //Takes text file from path.
        Scanner scan = new Scanner(file); //Scans the text from the file object.

        while (scan.hasNextLine()) {    //Loops through each line at a time until the last line of input is reached.
            String input = scan.nextLine(); //Stores the contents of scanned input into String input object.
            Pattern p = Pattern.compile("[0-9]+"); //Pattern objects to look for numbers only.
            Matcher m = p.matcher(input); //Checks for matching patterns of decimal numbers in the input.
            ArrayList<Integer> fTroops = new ArrayList<>(); //ArrayList to store input values.
            while (m.find()) { //Loops through each pattern found per iteration.
                int n = Integer.parseInt(m.group()); //Stores the integer input value to an temporary integer variable.
                fTroops.add(n); //Stores the integer value into the ArrayList.
            }
            //Number of Falicornia battalions have been extracted and are stored in order in fTroops for calculations.
            Battalion falicornia = new Battalion(fTroops.get(0), fTroops.get(1), fTroops.get(2), fTroops.get(3));
            Battalion lengaburu = new Battalion(); //
            War war = new War(); //Creates a War object.
            war.battle(falicornia, lengaburu); // Invokes method battle() which takes two Battalion objects as parameters.
        }
    }
}

