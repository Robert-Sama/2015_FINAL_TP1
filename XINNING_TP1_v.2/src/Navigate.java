import java.io.IOException;
import java.util.*;

/*
 * We make this class to make a recursive function that will keep on looking at neighbours in the letter matrix
 * until there are no more words.
 */

public class Navigate {

    String word;
    List<List<String>> matrice;
    int colIndex;
    int rowIndex;
    int xCoord;
    int yCoord;
    List<String> foundWords;

    //We translate what's in the Main class in here
    //We take a word we're looking for, the matrix and the dimensions of the matrix
    public Navigate(String word, List<List<String>> matrice, int colIndex, int rowIndex) {
        this.word = word;
        this.matrice = matrice;
        this.colIndex = colIndex;
        this.rowIndex = rowIndex;
        foundWords = new ArrayList<>();
    }

    public void findWords() {
        for (int r = 0; r < rowIndex; r++) {
            for (int c = 0; c < colIndex; c++) {
                searchLoop(0, c, r, new ArrayList<>());
            }
        }
    }

    public void searchLoop(int lettrePos, int c, int r, List<String> alphonse) {
    	//We want to loop while the indexes of the matrix and of the letters are in bound
        //Alphonse is a list of strings, it stores the coordinates of found letters of the searched word.
        if (c >= 0 && c < colIndex && r >= 0 && r < rowIndex && lettrePos < word.length()) {
        	//We get the letter at the position lettrePos
            String lettre = Character.toString(word.charAt(lettrePos));
            //If our letter is the same as the one in the matrix.
            if (lettre.equals(matrice.get(c).get(r))) {
                //Alphonse adds the coordinates of that letter.
                alphonse.add("(" + c + ", " + r + ")");
                if (lettrePos == word.length() - 1) {
                    foundWords.add(String.join("->", alphonse));
                } else { //IF we didn't find a letter, we still want to continue the search as long as the indexes are valid
                    for (int yOffset = -1; yOffset <= 1; yOffset++) {
                        for (int xOffset = -1; xOffset <= 1; xOffset++) {
                            if (yOffset != 0 || xOffset != 0) {
                                int newC = c + xOffset;
                                int newR = r + yOffset;
                                //We call alphonse again, because we didn't find anything
                                searchLoop(lettrePos + 1, newC, newR, new ArrayList<>(alphonse));
                            }
                        }
                    }
                }
            }
        }
    }
    //We print all the positions that Alphonse gave us
    public void printFoundWords() {
        for (String foundWord : foundWords) {
            System.out.println(word + foundWord );
        }
    }

    //Verifies if the letter is the same one as in the matrix
    //I made it to make the kenbunshokuHaki method less complicated
    //It looks at the neighbour specified when we call it and returns true if there's a match
    public boolean verification(int c1, int r1, int lettrePos) {
        String lettre = Character.toString(word.charAt(lettrePos));
        if (lettre.equals(matrice.get(c1).get(r1))) {
            return true;

        } else {
            return false;
        }
    }

}
