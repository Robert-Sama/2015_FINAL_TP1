//I put everything we need to store in this class because idk when or how we're gonna use them yet

import java.util.ArrayList;
import java.util.List;
//I have unbelievable hatred for this class
//Basically jsut stores data, but i don,t think it's usefull
public class Structures {
    //We want to have the width and length of the matrix
    //So that in TxtReader, we can call Structure and make a 2D linked positional list
    int colD;
    int rowD;
    int dT;
    List<List<String>> matrice;
    String[] motsL;

    public Structures(String colD, String rowD) {
        //We convert here because it's easier
        //We'll use these to make the list of letters
        this.colD = Integer.parseInt(colD);
        this.rowD = Integer.parseInt(rowD);
        this.dT = this.rowD * this.colD; //total dimensions
    }

    //We want to have access to the words that we need to search everywhere
    public Structures (String[] motsR) {
        this.motsL = motsR;
    }

    public Structures () {
        this.matrice = new ArrayList<>();
    }

    public void addMethod(List<String> zgeg) {
        matrice.add(zgeg);

    }

}
