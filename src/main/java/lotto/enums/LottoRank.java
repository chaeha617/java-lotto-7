package lotto.enums;

import lotto.domain.Lotto;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    LottoRank(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank findLottoRank(int matchCount, boolean hasBonus) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.matchCount == matchCount && lottoRank.requiresBonus == hasBonus) {
                return lottoRank;
            }
        }
        return NONE;
    }
}

