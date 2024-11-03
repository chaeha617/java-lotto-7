package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.AmountValidator;
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
}
