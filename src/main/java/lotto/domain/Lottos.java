package lotto.domain;

import java.util.LinkedList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new LinkedList<>();


    public Lottos(){
    }

    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public int size(){
        return lottos.size();
    }

    public List<Integer> countMatchingNumbersForAll(Lotto winningLotto) {
        List<Integer> matchCounts = new LinkedList<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto); // 각 로또와 비교하여 일치 개수 계산
            matchCounts.add(matchCount);
        }
        return matchCounts;
    }
    public List<Boolean> matchingBonusNumbersForAll(int bonusNumber) {
        List<Boolean> matchBonus = new LinkedList<>();
        for (Lotto lotto : lottos) {
            matchBonus.add(lotto.hasNumber(bonusNumber));
        }
        return matchBonus;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Lotto lotto : lottos){
            stringBuilder.append(lotto.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
