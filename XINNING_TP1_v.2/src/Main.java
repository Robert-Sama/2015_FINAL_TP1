
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {

        //We read user input.
        Scanner readInput = new Scanner(System.in); //obj of scanner that takes inputs

        //With the scanner takes the input, we read it and store it in filepath.
        System.out.println("Enter file name : ");
        //we make a String filepath that takes the input.
        String filePath = readInput.next(); 
        readInput.close();

        //We make an obj of bufferedReader to begin reading the inputed file.
        BufferedReader objBr = new BufferedReader(new FileReader(filePath));
        
        //We initiate the query value before the loop.
        int queryValue = 1;
        
        boolean b = objBr.ready();
        //True while we can still read the file
        while ( b ) {
        	//We print the query in the loop.
            System.out.println("Query " + queryValue +":");
            //We increment the query value at each step.
            queryValue += 1;

            //We make a 2d list.
            //We want it to take each line of the txt file as a list
            //and then combine that into another list to correspond to the matrix.
            Structures objMatrice = new Structures();

            //Since it said in the forum that all the files are perfect, we know exactly what the first and last lines are.
            //We read one time and we store the matrix dimensions by calling Structures class that i'll use in other folder.
            String[] txtD = objBr.readLine().split(" ");
            //We call Structure to store the dimensions, we know that the first character is the nb of col
            Structures objDimensions = new Structures(txtD[0], txtD[1]);  
            
            //We want to store the matrix which are the next objDimensions.colD lines
            //What we want is in between the first and last line
            //We know we want the next colD lines -> because it's the first character of the file which is the number of col
            for (int i = 0; i < objDimensions.colD; i ++) {
                objMatrice.addMethod(Arrays.asList( objBr.readLine().split(" ") ));
            }

            //We are now at the last line and we know that it's the words we're looking for
            //They are stored in Structures as an array
            Structures objMotsRecherche = new Structures( objBr.readLine().split(" ") );
            
            //we initiate the step that we're at with the elem.
            int etapeElem = 0;
            
            //We loop through all the words.
            for ( String elem : objMotsRecherche.motsL ) {
                //For every words, we want to begin the search for the letters starting with the first one
                //                 and we want to start from the index 0,0 -> c = columns, r = rows
            	
                etapeElem = 0; //We want to start from the first letter
                int c = 0;
                int r = 0;

                //this will call the Navigate class and within it there'll be 2 functions where we'll find the words in the matrix
                Navigate recherche = new Navigate(elem, objMatrice.matrice, objDimensions.colD, objDimensions.rowD);
                
                recherche.findWords();
                recherche.printFoundWords();

            }

            b = objBr.ready(); //-> becomes false when there's nothing else to read
            //So in each iteration, we read a line which is the dimensions
            //                      then we read the matrix
            //                      then we read the words to search for

        } objBr.close();

    }

}
