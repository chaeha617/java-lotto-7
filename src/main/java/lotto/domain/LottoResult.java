package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.enums.LottoConfig;
import lotto.enums.LottoRank;

public class LottoResult {
    private Lotto winningLotto;
    private int bonusNumber;
    private final List<LottoRank> ranks = new ArrayList<>();


    public LottoResult(Lotto winningLotto, int bonusNumber){
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void createLottoResult(Lottos lottos) {
        List<Integer> matchNumbers = lottos.countMatchingNumbersForAll(winningLotto);
        List<Boolean> matchHasBonusNumber = lottos.matchingBonusNumbersForAll(bonusNumber);

        // 각 로또의 일치 번호 수와 보너스 번호 여부에 따라 등수 계산
        for (int index = 0; index < matchNumbers.size(); index++) {
            int matchCount = matchNumbers.get(index);
            boolean hasBonus = matchHasBonusNumber.get(index);
            LottoRank rank = LottoRank.findLottoRank(matchCount, hasBonus); // 등수 계산
            ranks.add(rank); // 등수를 리스트에 추가
        }
    }

    public float getTotalPrize() {
        // 등수별 당첨금액
        float totalPrize = 0;

        EnumMap<LottoRank, Integer> rankCountMap = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCountMap.put(rank, 0); // 초기화
        }

        for (LottoRank rank : ranks) {
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        }

        // 각 등수에 따른 총 당첨금 계산
        totalPrize += rankCountMap.get(LottoRank.FIFTH) * 5000; // 3개 일치
        totalPrize += rankCountMap.get(LottoRank.FOURTH) * 50000; // 4개 일치
        totalPrize += rankCountMap.get(LottoRank.THIRD) * 1500000; // 5개 일치
        totalPrize += rankCountMap.get(LottoRank.SECOND) * 30000000; // 5개 + 보너스 일치
        totalPrize += rankCountMap.get(LottoRank.FIRST) * 2000000000; // 6개 일치

        return totalPrize;
    }

    public String getProfit() {
        float totalInvestment = ranks.size() * LottoConfig.LOTTO_PRICE.getValue(); // 총 구매 금액
        float totalPrize = getTotalPrize(); // 총 당첨 금액
        return String.format("총 수익률은 %.1f%%입니다.", totalPrize / totalInvestment);
    }

    @Override
    public String toString() {
        EnumMap<LottoRank, Integer> rankCountMap = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCountMap.put(rank, 0); // 초기화
        }

        for (LottoRank rank : ranks) {
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        }

        StringBuilder result = new StringBuilder("당첨 통계\n---\n");
        result.append(String.format("3개 일치 (5,000원) - %d개\n", rankCountMap.get(LottoRank.FIFTH)));
        result.append(String.format("4개 일치 (50,000원) - %d개\n", rankCountMap.get(LottoRank.FOURTH)));
        result.append(String.format("5개 일치 (1,500,000원) - %d개\n", rankCountMap.get(LottoRank.THIRD)));
        result.append(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rankCountMap.get(LottoRank.SECOND)));
        result.append(String.format("6개 일치 (2,000,000,000원) - %d개\n", rankCountMap.get(LottoRank.FIRST)));

        return result.toString();
    }
}
