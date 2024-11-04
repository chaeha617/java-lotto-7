package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.validator.AmountValidator;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoValidator;
import lotto.validator.NullValidator;

public class InputView {

    private InputView(){
    }

    public static String inputAmount(){
        String input = Console.readLine();
        try {
            NullValidator.validate(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            AmountValidator.validate(input);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputAmount();
        }
        return input;
    }

    public static String inputWinningLotto(){
        String input = Console.readLine();
        NullValidator.validate(input);
        try{
            LottoValidator.validate(input);
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim) // 각 요소의 앞뒤 공백 제거
                    .map(Integer::parseInt) // 문자열을 Integer로 변환
                    .toList();
            LottoValidator.validate(numbers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputWinningLotto();
        }
        return input;
    }

    public static String inputBonusNumber(Lotto winningLotto){
        String input = Console.readLine();
        NullValidator.validate(input);
        try{
            BonusNumberValidator.validate(input, winningLotto);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBonusNumber(winningLotto);
        }
        return input;
    }

}
