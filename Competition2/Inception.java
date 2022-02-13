import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Inception {
    public static void printAll(DreamCharacter[] characters) {
        for (DreamCharacter dc : characters) {
            System.out.println(dc);
        }
    }

    public static void main(String[] args) {
        DreamCharacter ariadne = new DreamCharacter("Ariadne");
        DreamCharacter dom = new DreamCharacter("Dom");
        DreamCharacter eames = new DreamCharacter("Eames");
        DreamCharacter robert = new DreamCharacter("Robert");
        DreamCharacter saito = new DreamCharacter("Saito");
        DreamCharacter mal = new DreamCharacter("Mal");
        DreamCharacter[] dreamCharacters = { ariadne, dom, eames, robert, saito, mal };
        HashMap<String, DreamCharacter> characterHM = new HashMap<String, DreamCharacter>();
        characterHM.put("Ariadne", ariadne);
        characterHM.put("Dom", dom);
        characterHM.put("Eames", eames);
        characterHM.put("Robert", robert);
        characterHM.put("Saito", saito);
        characterHM.put("Mal", mal);
        try {
            Scanner scanner = new Scanner(new File("challenge.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String action = line.split(" ")[0];
                String characterName = line.split(" ")[1];
                DreamCharacter currentCharacter = characterHM.get(characterName);
                // Create an array of all characters besides the current character
                ArrayList<DreamCharacter> otherCharacters = new ArrayList<DreamCharacter>(5);
                for (DreamCharacter dc : dreamCharacters) {
                    if (!dc.getName().equals(characterName)) {
                        otherCharacters.add(dc);
                    }
                }
                DreamCharacter[] others = otherCharacters.toArray(new DreamCharacter[otherCharacters.size()]);
                if (action.equals("DREAM")) {
                    currentCharacter.dream(others);
                } else if (action.equals("WAKE")) {
                    currentCharacter.wake(others);
                }
                System.out.println("----- " + line + " -----");
                printAll(dreamCharacters);
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
