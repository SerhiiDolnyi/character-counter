package charactercounter.provider;

import java.util.Map;

import charactercounter.caсhe.CaсheProvider;
import charactercounter.validator.Validator;

public class CharacterStaticsProvider {

    private final Validator validator;
    private final CharacterCountProvider characterCountProvider;
    private final CaсheProvider<String, Map<Character, Integer>> cacheProvider;
    private final CharacterViewProvider characterViewProvider;

    public CharacterStaticsProvider(Validator validator, CharacterCountProvider characterCountProvider,
            CaсheProvider<String, Map<Character, Integer>> cacheProvider, CharacterViewProvider characterViewProvider) {
        this.validator = validator;
        this.characterCountProvider = characterCountProvider;
        this.cacheProvider = cacheProvider;
        this.characterViewProvider = characterViewProvider;
    }

    public String provideStatics(String text) {
        validator.validate(text);

        final Map<Character, Integer> characterToCount;
        if (cacheProvider.isPresent(text)) {
            characterToCount = cacheProvider.getValue(text);
        } else {
            characterToCount = characterCountProvider.countCharacters(text);
            cacheProvider.putValue(text, characterToCount);
        }
        
        return characterViewProvider.provideView(text, characterToCount);

    }
}
