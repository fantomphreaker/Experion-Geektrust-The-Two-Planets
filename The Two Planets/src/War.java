//Class that have methods and state that deals with deployment of battalions for war w.r.t the rules of war.
public class War {

    final int POWERMULTIPLIER = 2; //Constant multiplier used to double the strength of troops (Lengaburu's battalion).


    public void battle(Battalion f, Battalion l) {
        //To store remaining number of troops left in each battalion of Lengaburu and Falicornia
        int[] remHorses;
        int[] remElephants;
        int[] remAT;
        int[] remSG;
        //Deploying troops from each battalion of Lengaburu and Falicornia as per rule #2 - The Like-to-Like Rule.
        remHorses = versusBattle(l.getHorses(), f.getHorses(), POWERMULTIPLIER);
        remElephants = versusBattle(l.getElephants(), f.getElephants(), POWERMULTIPLIER);
        remAT = versusBattle(l.getArmouredTanks(), f.getArmouredTanks(), POWERMULTIPLIER);
        remSG = versusBattle(l.getSlingGuns(), f.getSlingGuns(), POWERMULTIPLIER);
        //Troops left in each battalion are separated into two arrays of troops in Lengaburu and Falicornia.
        int[] lengArray = {remHorses[0], remElephants[0], remAT[0], remSG[0]}; //Array of troops left in Lengaburu.
        int[] faliArray = {remHorses[1], remElephants[1], remAT[1], remSG[1]}; //Array of troops left in Falicornia.

/*  Test code that prints the remaining troops after deployment as per rule #2 - The Like-to-Like Rule.
        System.out.print("Remaining troops of Lengaburu: ");
        for(int i = 0; i < 4; i ++){
           System.out.print(lengArray[i]+" ");

        }
        System.out.println();
        System.out.print("Remaining troops of Falicornia: ");
        for(int i = 0; i < 4; i ++){
           System.out.print(faliArray[i]+" ");

        }
    Test code ends here.
*/
        /*Loop to loop through each element of faliArray to find the non-zero elements. If a non-zero element is found,
         that means corresponding element of lengArray is zero(i.e troops in that battalion is exhausted) thus, that element
         undergoes troops substitution as per rules of war #3 and #4. The substitution as per rules #3 and #4 is implemented
         by the methods rightSubstitution() and leftSubstitution().
         */
        for (int i = 0; i < faliArray.length; i++) {
            if (faliArray[i] != 0) {
                if (i == 0) {
                    lengArray[i + 1] = rightSubstitution(faliArray[i], lengArray[i + 1]);
                } else if (i == 3) {
                    lengArray[i - 1] = leftSubstitution(faliArray[i], lengArray[i - 1]);
                } else {
                    lengArray[i - 1] = leftSubstitution(faliArray[i], lengArray[i - 1]);
                    lengArray[i + 1] = rightSubstitution(faliArray[i], lengArray[i + 1]);
                }
            }
        }
/*      Test code that prints the remaining troops of each battalion after substitution w.r.t rules #3 and #4.
        System.out.println();
        for(int i = 0; i<4; i++){
            System.out.print(lengArray[i]+" ");
        }
        System.out.println();
        for(int i = 0; i<4; i++){
            System.out.print(faliArray[i]+" ");
        }
        Test code ends.
*/

        System.out.println("\n" + winOrLose(lengArray, faliArray)
                + (l.getHorses() - lengArray[0]) + "H "
                + (l.getElephants() - lengArray[1]) + "E "
                + (l.getArmouredTanks() - lengArray[2]) + "AT "
                + (l.getSlingGuns() - lengArray[3]) + "SG "
        );
    }
    //Method versusBattle() implements rules #1 and #2.
    public int[] versusBattle(int lTroops, int fTroops, int p) {
        float remainingTroops = fTroops - p * lTroops; //rules #2 and #1.
        if (remainingTroops > 0) {
            fTroops = (int) remainingTroops;
            remainingTroops = 0;
        } else {
            fTroops = 0;
            remainingTroops = (int) Math.floor(Math.abs(remainingTroops / p));
        }

        return new int[]{(int) remainingTroops, fTroops}; //returns array of troops left in Lengaburu and Falicornia
    }
    //Method rightSubstitution() substitutes with troops from the adjacent right side.
    public int rightSubstitution(int f, int l) {
        //Applying power rule and converting the substituting troops into same units as substituted troops.
        double remaining = f - l * 4;
        if (remaining > 0) {
            l = 0;
            f = (int) remaining;
        } else {
            f = 0;
            l = (int) Math.floor(Math.abs(remaining / 4)); //Converting Lengaburu troops back to original unit.
        }
        return l;
    }
    //Method leftSubstitution() substitutes with troops from the adjacent left side. It has more priority due to rule #4.
    public int leftSubstitution(int f, int l) {
        //Applying power rule and converting the substituting troops into same units as substituted troops.
        double remaining = f - l / 2;
        if (remaining > 0) {
            l = 0;
            f = (int) remaining;
        } else {
            f = 0;
            l = (int) Math.floor(Math.abs(remaining * 2)); //Converting Lengaburu troops back to original unit.
        }
        return l;
    }
    /*
    Method winOrLose() takes the troops left in each army of both parties after all the substitutions, and compares
    their total battle strength left. The troops with greater total battle strength left wins the war
    */
    public String winOrLose(int[] l, int[] f) {
        int totalPowerL = 0;
        int totalPowerF = 0;

        for (int i = 0, j = 1; i < l.length; i++) {
            totalPowerF = f[i] * j + totalPowerF;
            j = 2 * j;//Moving from left to right in order, each battalion's strength is double that of the previous battalion.
        }


        for (int i = 0, j = 1; i < l.length; i++) {
            totalPowerL = l[i] * j + totalPowerL;
            j = 2 * j;
        }

        totalPowerL = totalPowerL * POWERMULTIPLIER;//Lengaburu's army is twice as powerful as Falicornia.

        if (totalPowerL > totalPowerF) {
            return "WINS ";
        } else {
            return "LOSES ";
        }
    }

}

