import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Patterns {

    public static char encode(int num) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int ind = (num + alphabet.length()) % alphabet.length();
        return alphabet.charAt(ind);
    }

    public static int getNextChunk(int chunkSize, int currentChunk, String str) {
        return Integer.parseInt(str.substring(currentChunk, currentChunk + chunkSize));
    }

    public static void main(String[] args) throws IOException {
        try {
            Scanner scnr = new Scanner(new File("digits.txt"));
            int chunkSize = 2;
            String piDigits = scnr.nextLine();
            File enc = new File("encoded.txt");
            FileWriter fw = new FileWriter(enc);
            for (int i = 0; i < piDigits.length() / chunkSize; i += chunkSize) {
                fw.write(encode(getNextChunk(chunkSize, i, piDigits)));
            }
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}