package lotto.validator;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoConfig;
import lotto.enums.RegexPattern;

public class NullValidator {

    private NullValidator(){
    }

    public static void validate(String input){
        validateNull(input);
    }

    private static void validateNull(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getMessage());
        }
    }

}
