package lotto.contoller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run(){
        int amount = getAmount();
        Lottos lottos =  getLottos(amount);
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);
        getLottoResult(lottos, winningLotto, bonusNumber);
    }

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

    private void getLottoResult(Lottos lottos, Lotto winningLotto, int bonusNumber){
        LottoResult lottoResult = new LottoResult(winningLotto, bonusNumber);
        lottoResult.createLottoResult(lottos);
        OutputView.printLottoResult(lottoResult.toString());
        OutputView.printPropit(lottoResult.getProfit());
    }


}
