package charactercounter.provider;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CharacterViewProviderImpl implements CharacterViewProvider{

    @Override
    public String provideView(String text, Map<Character, Integer> charterToCount) {        
        StringBuilder orderedResult = new StringBuilder();
        Iterator<Entry<Character, Integer>> itrCharterToCount = charterToCount.entrySet().iterator();
        while(itrCharterToCount.hasNext()) {
            Entry<Character, Integer> entry = itrCharterToCount.next();            
            String frequencyOfCharacter = String.format("\"%s\" - %d%n",  
                    entry.getKey(), entry.getValue());
            orderedResult.append(frequencyOfCharacter);
        }
     
        return orderedResult.toString();
    }
}
