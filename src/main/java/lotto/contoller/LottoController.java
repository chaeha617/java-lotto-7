package lotto.contoller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private int getAmount(){
        OutputView.printAmountInputMessage();
        return Integer.parseInt(InputView.inputAmount());
    }

    private Lottos getLottos(int Amount){
        LottoMachine lottoMachine = new LottoMachine(Amount);
        Lottos lottos = lottoMachine.createLottos();
        OutputView.printLottoCount(lottos.size());
        OutputView.printLottos(lottos);
        return lottos;
    }

    private Lotto getWinningLotto(){
        OutputView.printWinningLottoInputMessage();
        String input = InputView.inputWinningLotto();
        return new Lotto(input);
    }

    private int getBonusNumber(Lotto winningLotto){
        OutputView.printBonusNumberInputMessage();
        return Integer.parseInt(InputView.inputBonusNumber(winningLotto));
    }

}
