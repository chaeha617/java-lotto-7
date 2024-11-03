package lotto.contoller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public int getAmount(){
        OutputView.printAmountInputMessage();
        return Integer.parseInt(InputView.inputAmount());
    }
}
