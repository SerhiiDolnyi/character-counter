package charactercounter.validator;

public class ValidatorImpl implements Validator {

    @Override
    public void validate(String text) {
        if(text == null) {
            throw new NullPointerException("Text is null");      
        }         
        if(text.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");  
        }
    }
}
