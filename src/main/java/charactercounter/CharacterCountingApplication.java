package charactercounter;

import java.util.Map;
import java.util.Scanner;

import charactercounter.caсhe.CaсheProvider;
import charactercounter.caсhe.LRUCacheProviderImpl;
import charactercounter.provider.CharacterCountProvider;
import charactercounter.provider.CharacterStaticsProvider;
import charactercounter.provider.CharacterViewProvider;
import charactercounter.provider.CharacterViewProviderImpl;
import charactercounter.provider.SimpleCharacterCountProvider;
import charactercounter.validator.Validator;
import charactercounter.validator.ValidatorImpl;

public class CharacterCountingApplication {
    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        CaсheProvider<String, Map<Character, Integer>> cacheProvider = new LRUCacheProviderImpl<>(2);
        CharacterCountProvider characterCountProvider = new SimpleCharacterCountProvider();
        CharacterViewProvider characterViewProvider = new CharacterViewProviderImpl();
        
        Scanner in = new Scanner(System.in);

        CharacterStaticsProvider characterStaticsProvider = new CharacterStaticsProvider
                (validator, characterCountProvider, cacheProvider, characterViewProvider);
        
        System.out.println("Input a string:");
        String text = in.nextLine();
        in.close();
        String result = characterStaticsProvider.provideStatics(text);

        System.out.println(result);
    }
}
