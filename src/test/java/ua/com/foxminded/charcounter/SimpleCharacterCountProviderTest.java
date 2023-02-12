package ua.com.foxminded.charcounter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import charactercounter.provider.SimpleCharacterCountProvider;

public class SimpleCharacterCountProviderTest {
    
    @Test
    void  SimpleCharacterCountProviderTestShouldReturnMapWithCharactersAndIntegers () {
        SimpleCharacterCountProvider countedCharacters = new SimpleCharacterCountProvider();
        String text = "Java the best";
        Map<Character, Integer> actual = countedCharacters.countCharacters(text);
        Map<Character, Integer> expected = new HashMap<>();
            expected.put(" ".charAt(0), 2);
            expected.put("a".charAt(0), 2);
            expected.put("b".charAt(0), 1);
            expected.put("s".charAt(0), 1);
            expected.put("t".charAt(0), 2);
            expected.put("e".charAt(0), 2);
            expected.put("v".charAt(0), 1);
            expected.put("h".charAt(0), 1);
            expected.put("J".charAt(0), 1);
        assertThat(actual, equalTo(expected));        
    }
}
