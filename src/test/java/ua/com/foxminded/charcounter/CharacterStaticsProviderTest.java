package ua.com.foxminded.charcounter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import charactercounter.caсhe.CaсheProvider;
import charactercounter.provider.CharacterCountProvider;
import charactercounter.provider.CharacterStaticsProvider;
import charactercounter.provider.CharacterViewProvider;
import charactercounter.validator.Validator;

@ExtendWith(MockitoExtension.class)
class CharacterStaticsProviderTest {
    
    @Mock
    Validator validator;
    
    @Mock
    CharacterCountProvider characterCountProvider;
    
    @Mock
    CaсheProvider<String, Map<Character, Integer>> cacheProvider;
    
    @Mock
    CharacterViewProvider characterViewProvider;
    
    @InjectMocks
    CharacterStaticsProvider characterStaticsProvider;
    
    @Test
    void characterStaticsProviderTestShouldCallValidateMethod() {
        doNothing().when(validator).validate("Text");
        String actual = characterStaticsProvider.provideStatics("Text");
        assertThat(actual, equalTo(null));
        verify(validator).validate("Text");
    }
    
    @Test
    void characterStaticsProviderTestShouldCallCountCharactersMethod() {
        when(characterCountProvider.countCharacters(null)).thenReturn(null);
        Map<Character, Integer> actual = characterCountProvider.countCharacters(null);
        assertThat(actual, equalTo(null));
        verify(characterCountProvider).countCharacters(null);
    }
    
    @Test
    void characterStaticsProviderTestShouldCallProvideViewMethod() {
        when(characterViewProvider.provideView(null, null)).thenReturn(null);
        String actual = characterViewProvider.provideView(null, null);
        assertThat(actual, equalTo(null));
        verify(characterViewProvider).provideView(null, null);
    }
    
    @Test
    void characterStaticsProviderTestShouldThrowExceptionIfStringIsEmpty() {
        doThrow(new IllegalArgumentException("String cannot be empty.")).when(validator).validate("");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> characterStaticsProvider.provideStatics(""));
        assertThat(exception.getMessage(), is("String cannot be empty."));
        verify(validator).validate("");
        verifyNoInteractions(characterCountProvider);
        verifyNoInteractions(cacheProvider);
        verifyNoInteractions(characterViewProvider);        
    }
    
    @Test
    void characterStaticsProviderTestShouldNotCallCountCharactersMethodWhenCallingCacheProviderIsPresent () {
        when(cacheProvider.isPresent(null)).thenReturn(true);
        Boolean actual = cacheProvider.isPresent(null);
        assertThat(actual, equalTo(true));
        verifyNoInteractions(characterCountProvider); 
    }
}
