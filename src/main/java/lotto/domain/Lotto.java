package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public Lotto(String input){
        LottoValidator.validate(input);
        List<Integer> numbers;
        numbers = Arrays.stream(input.split(","))
                .map(String::trim) // 각 요소의 앞뒤 공백 제거
                .map(Integer::parseInt) // 문자열을 Integer로 변환
                .sorted() // 요소 정렬
                .toList();
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public boolean hasNumber(int number){
        return numbers.contains(number);
    }

    @Override
    public String toString(){
        return numbers.toString();
    }
}
