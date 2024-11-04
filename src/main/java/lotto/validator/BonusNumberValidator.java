package lotto.validator;

import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConfig;
import lotto.enums.RegexPattern;

public class BonusNumberValidator {

    private BonusNumberValidator(){
    }


    public static void validate(String input, Lotto winningLotto){
        inputFormatIsIncorrect(input);
        int number = Integer.parseInt(input);
        lottoNumberOutOfRange(number);
        lottoNumbersDuplicate(number, winningLotto);
    }

    private static void inputFormatIsIncorrect(String input){
        if(!RegexPattern.NOT_ONLY_NUMBER.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_ONLY_INTEGER.getMessage());
        }
    }

    private static void lottoNumberOutOfRange(int number){
        if (number > LottoConfig.LOTTO_MAX_NUMBER.getValue()
                ||
                number < LottoConfig.LOTTO_MIN_NUMBER.getValue()
        ){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }

    }

    private static void lottoNumbersDuplicate(int number, Lotto winningLotto) {
    if(winningLotto.hasNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }
}
