package lotto.validator;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoConfig;
import lotto.enums.RegexPattern;

public class AmountValidator {

    private AmountValidator(){
    }

    public static void validate(String input){
        validateNotInteger(input);
        validateBelowLottoPrice(input);
        validateNotDivisibleByLottoPrice(input);
    }

    private static void validateNotInteger(String input){
        if (RegexPattern.NOT_ONLY_NUMBER.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_ONLY_INTEGER.getMessage());
        }
    }

    private static void validateBelowLottoPrice(String input){
        int amount = Integer.parseInt(input);
        if(amount < LottoConfig.LOTTO_PRICE.getValue()){
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_BELOW_LOTTO_PRICE.getMessage());
        }
    }
    private static void validateNotDivisibleByLottoPrice(String input){
        int amount = Integer.parseInt(input);
        if(amount % LottoConfig.LOTTO_PRICE.getValue() > 0){
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
        }
    }
}
