import java.util.*;

public class Competition1 {
    public static String ciphertext = "ETEVHTWGSAHGWYVPNKQOEGWYVPNKPDEPHWAOVWPFWNHANEVWXAVOAEAJEUXTAOWBTEVHTWGSAHGWYVPNQAOQVGTYHAVAXETOANFQEOIQPLANTEVHFYNSQVEBEOWSKNCKLOPEVTYJAUFWYNCOTWZESQEPERQSQOPEVYCEVHEGDEHEVHEYOPNQEEHWYFTKTEVHTWGSAHGWYVPNKQOWVAPDEPWVTKFWNHANOTEVHTWGSAHGWYVPNQAOPDANAENAWVTKPIWHWYFTKTEVHTWGSAHGWYVPNQAOQVPDAIWNTHWVAWBPDAUQOYLFASQOPEVIDEPQOPDAWPDANWVA";
    public static String phrase = "NEPALSERBIASWITZERLANDBURKINAFASOKYRGYZSTANLUXEMBOURGSLOVAKIATAJIKISTANUGANDACHADANDAUSTRIA";

    public static void main(String[] args) {
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Hint phrase: " + phrase);
        System.out.println("Hint phrase length: " + phrase.length());
        Vector<Integer> eLocations = new Vector<Integer>();
        for (int j = 0; j < phrase.length(); j++) {
            char currentChar = phrase.charAt(j);
            if (currentChar == "E".charAt(0)) {
                eLocations.add(j);
            }
        }
        System.out.println("eLocations in phrase: " + eLocations);
        for (int i = 0; i <= ciphertext.length() - phrase.length(); i++) {
            String cipherPortion = ciphertext.substring(i, i + phrase.length());
            if (cipherPortion.charAt(1) == cipherPortion.charAt(6)
                    && cipherPortion.charAt(1) == cipherPortion.charAt(16)
                    && cipherPortion.charAt(1) == cipherPortion.charAt(46)) {
                System.out.println(i);
                System.out.println(phrase);
                System.out.println(cipherPortion);
                Map<Character, Character> decoder = new HashMap<Character, Character>();
                for (int k = 0; k < cipherPortion.length(); k++) {
                    if (!decoder.containsKey(cipherPortion.charAt(k))) {
                        decoder.put(cipherPortion.charAt(k), phrase.charAt(k));
                    }
                }
                System.out.println("Here is the hashmap to crack it:");
                System.out.println(decoder);
                StringBuilder decoded = new StringBuilder(ciphertext.length());
                for (int k = 0; k < ciphertext.length(); k++) {
                    decoded.append(decoder.get(ciphertext.charAt(k)));
                }
                System.out.println(decoded.toString());
                break;
            }
        }
    }
}