package ua.com.foxminded.charcounter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import charactercounter.validator.ValidatorImpl;

class ValidatorImplTest {
    ValidatorImpl validatorImpl = new ValidatorImpl();
    
    @Test
    void validatorImplTest_ShouldThrowException_IfStringIsEmpty() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validatorImpl.validate(""));    
        assertThat(exception.getMessage(), equalTo("Text is empty"));      
    }
    
    @Test
    void validatorImplTest_ShouldThrowException_IfStringIsNull() {
        String text = null;
        Throwable exception = assertThrows(NullPointerException.class, () -> validatorImpl.validate(text));    
        assertThat(exception.getMessage(), equalTo("Text is null"));      
    }
    
    @Test
    void validatorImplTest_ShouldTestDoesNotThrowException() {
        assertDoesNotThrow(() -> validatorImpl.validate("String"));
    }
}
