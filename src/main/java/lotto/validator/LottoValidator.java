package lotto.validator;

import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConfig;
import lotto.enums.RegexPattern;

public class LottoValidator {

    private LottoValidator(){
    }

    public static void validate(String input){
        inputFormatIsIncorrect(input);
    }

    public static void validate(List<Integer> numbers){
        lottoNumberOutOfRange(numbers);
        lottoNumbersCountInValid(numbers);
        lottoNumbersDuplicate(numbers);
    }

    private static void inputFormatIsIncorrect(String input){
        if(!RegexPattern.LOTTO_NUMBERS_FORMAT.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INPUT_FORMAT_IS_INCORRECT.getMessage());
        }
    }

    private static void lottoNumberOutOfRange(List<Integer> numbers){
        for (int number : numbers){
            if (number > LottoConfig.LOTTO_MAX_NUMBER.getValue()
                ||
                number < LottoConfig.LOTTO_MIN_NUMBER.getValue()
            ){
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private static void lottoNumbersCountInValid(List<Integer> numbers){
        if(numbers.size() != LottoConfig.LOTTO_NUMBER_COUNT.getValue()){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_COUNT_INVALID.getMessage());
        }
    }

    private static void lottoNumbersDuplicate(List<Integer> numbers){
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LottoConfig.LOTTO_NUMBER_COUNT.getValue()){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }
}
