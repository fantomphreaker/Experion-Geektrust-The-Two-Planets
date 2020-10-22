public class Battalion { //Battalion class methods and states that describe the battalion of either kingdoms.

    private int horses; //no. of horses(H).
    private int elephants; // no. of elephants(E).
    private int armouredTanks; //no. of armoured tanks(AT).
    private int slingGuns; //no. of sling guns(SG).

    Battalion() { //default constructor with maximum number of troops available in Lengaburu battalion as default values.
        this.horses = 100;
        this.elephants = 50;
        this.armouredTanks = 10;
        this.slingGuns = 5;
    }

    Battalion(int numHorses, int numElephants, int numAT, int numSG) { //constructor for each Falicornia battalion object.
        this.horses = numHorses;
        this.elephants = numElephants;
        this.armouredTanks = numAT;
        this.slingGuns = numSG;
    }

    public int getHorses() {
        return horses;
    }

    public int getElephants() {
        return elephants;
    }

    public int getArmouredTanks() {
        return armouredTanks;
    }

    public int getSlingGuns() {
        return slingGuns;
    }


}

