package day04;

import java.util.Map;
import java.util.TreeMap;

public class Vowels {

    private static final String vowels = "AEIOU";

    public Map<Character, Integer> getNumberOfVowels(String text) {
        Map<Character, Integer> result = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char actual = Character.toUpperCase(text.charAt(i));
            if (vowels.contains(Character.toString(actual).toUpperCase())) {
                if (result.keySet().contains(actual)) {
                    result.put(actual, result.get(actual) + 1);
                } else {
                    result.put(actual, 1);
                }
            }
        }
        return result;
    }
}
