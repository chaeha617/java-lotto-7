package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.LottoConfig;
import lotto.validator.LottoValidator;

public class LottoMachine {
    private final int lottoCount;

    public LottoMachine(int Amount){ this.lottoCount = Amount / LottoConfig.LOTTO_PRICE.getValue(); }

    public Lottos createLottos(){
        Lottos lottos = new Lottos();
        for(int count = 0; lottoCount > count; count++){
            List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(
                LottoConfig.LOTTO_MIN_NUMBER.getValue(),
                LottoConfig.LOTTO_MAX_NUMBER.getValue(),
                LottoConfig.LOTTO_NUMBER_COUNT.getValue()
            );
                LottoValidator.validate(numbers);
                lottos.addLotto(new Lotto(numbers));
        }
        return lottos;
    }

}
