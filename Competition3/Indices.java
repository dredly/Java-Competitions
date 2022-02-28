import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Indices {
    public static void main(String[] args) {
        try {
            Scanner scnr = new Scanner(new File("encoded.txt"));
            String piEncoded = scnr.nextLine();
            String[] interestingWords = new String[] { "ramen", "grave", "neck", "bonk" };
            for (String word : interestingWords) {
                System.out.println(word + " found at index " + 2 * piEncoded.indexOf(word));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
