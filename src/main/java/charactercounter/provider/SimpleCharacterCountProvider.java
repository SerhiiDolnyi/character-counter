package charactercounter.provider;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.summingInt;

public class SimpleCharacterCountProvider implements CharacterCountProvider {

    @Override
    public Map<Character, Integer> countCharacters(String text) {
        Map<Character, Integer> symbolToCount;
        return  symbolToCount = text.chars().mapToObj(c -> (char) c)
                                            .collect(Collectors.groupingBy(
                                             Function.identity(), 
                                             LinkedHashMap::new,
                                             summingInt(value -> 1)));                                                            
    }    
}
