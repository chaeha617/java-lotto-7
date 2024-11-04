package lotto.view;

import lotto.domain.Lottos;
import lotto.enums.LottoConfig;

public class OutputView {
    private static final String INPUT_AMOUNT = "구입 금액을 입력해주세요. 로또 1장 가격은 " + LottoConfig.LOTTO_PRICE + "입니다.";
    private static final String INPUT_WINNING_LOTTO = "당첨 번호를 입력해주세요. (숫자는 쉼표(,)로 구분해주세요.)";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요.";

    public OutputView(){
    }

    public static void printAmountInputMessage(){ System.out.println(INPUT_AMOUNT); }

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos){ System.out.println(lottos.toString()); }
    
    public static void printWinningLottoInputMessage(){ System.out.println(INPUT_WINNING_LOTTO); }

    public static void printBonusNumberInputMessage(){ System.out.println(INPUT_BONUS_NUMBER); }

    public static void printLottoResult(String lottoResult){ System.out.println(lottoResult);}

    public static void printPropit(String propit){ System.out.println(propit);}


}
