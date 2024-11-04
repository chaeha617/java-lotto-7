package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString(){
        Collections.sort(numbers);
        return numbers.toString();
    }
}
