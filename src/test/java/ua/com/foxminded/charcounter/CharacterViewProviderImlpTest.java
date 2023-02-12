package ua.com.foxminded.charcounter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import charactercounter.provider.CharacterViewProviderImpl;

class CharacterViewProviderImlpTest {

    @Test
    void characterViewProviderImplTestShouldReturnStringWhenSymbolIsDifferent() {
        CharacterViewProviderImpl characterViewProvider = new CharacterViewProviderImpl();
            String inputText = "abc dg";
            Map<Character, Integer> charterToCount = new LinkedHashMap<Character, Integer>();
            charterToCount.put("a".charAt(0), 1);
            charterToCount.put("b".charAt(0), 1);
            charterToCount.put("c".charAt(0), 1);
            charterToCount.put(" ".charAt(0), 1);
            charterToCount.put("d".charAt(0), 1);
            charterToCount.put("g".charAt(0), 1);
            
            String actual = characterViewProvider.provideView(inputText, charterToCount);
            String expected = "\"a\" - 1\r\n"
                            + "\"b\" - 1\r\n"
                            + "\"c\" - 1\r\n"
                            + "\" \" - 1\r\n"
                            + "\"d\" - 1\r\n"
                            + "\"g\" - 1\r\n";
            assertThat(actual, equalTo(expected));                                   
    }
    
    @Test
    void characterViewProviderImplShouldReturnStringWhenSymbolIsSame() {
        CharacterViewProviderImpl characterViewProvider = new CharacterViewProviderImpl();
            String inputText = "abc aaacccc";
            Map<Character, Integer> charterToCount = new LinkedHashMap<Character, Integer>();
            charterToCount.put("a".charAt(0), 4);
            charterToCount.put("b".charAt(0), 1);
            charterToCount.put("c".charAt(0), 5);
            charterToCount.put(" ".charAt(0), 1);
            
            String actual = characterViewProvider.provideView(inputText, charterToCount);
            String expected = "\"a\" - 4\r\n"
                            + "\"b\" - 1\r\n"
                            + "\"c\" - 5\r\n"
                            + "\" \" - 1\r\n";
            assertThat(actual, equalTo(expected));                                   
    }
}
