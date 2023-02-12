package charactercounter.provider;

import java.util.Map;

public interface CharacterViewProvider {

    String provideView(String text, Map<Character, Integer> charterToCount);
}
