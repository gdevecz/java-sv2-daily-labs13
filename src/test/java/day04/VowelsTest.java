package day04;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VowelsTest {

    Vowels vowels = new Vowels();

    @Test
    void getNumberOfVowelsTest() {
        Map<Character, Integer> result = vowels.getNumberOfVowels("appleTrEE");

        assertEquals(1, result.get('A'));
        assertEquals(3, result.get('E'));
    }
}