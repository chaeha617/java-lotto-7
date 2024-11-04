package lotto.contoller;

import lotto.domain.LottoMachine;
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


}
