package lotto.view;

import lotto.enums.LottoConfig;

public class OutputView {
    private static final String INPUT_AMOUNT = "구입 금액을 입력해주세요. 로또 1장 가격은 " + LottoConfig.LOTTO_PRICE + "입니다.";

    public OutputView(){
    }

    public static void printAmountInputMessage(){ System.out.println(INPUT_AMOUNT); }

}
