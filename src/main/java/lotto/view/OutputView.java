package lotto.view;

import lotto.domain.Lottos;
import lotto.enums.LottoConfig;

public class OutputView {
    private static final String INPUT_AMOUNT = "구입 금액을 입력해주세요. 로또 1장 가격은 " + LottoConfig.LOTTO_PRICE + "입니다.";

    public OutputView(){
    }

    public static void printAmountInputMessage(){ System.out.println(INPUT_AMOUNT); }

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos){
        System.out.println(lottos.toString());
    }
}
