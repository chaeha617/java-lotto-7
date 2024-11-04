package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoValidatorTest {

    @DisplayName("입력 값이 정수와 쉼표로 이루어져 있지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {",,,,,","123,45,5668,,","hello,lotto"," ",""})
    void validateInputFormatIsIncorrect(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.LOTTO_INPUT_FORMAT_IS_INCORRECT.getMessage(), exception.getMessage());
    }

    @DisplayName("로또 숫자중 범위를 벗어나는 값이 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"123,1,2,5,3,4","44,55,22,11,33","0,1,2,3,4,5","45,46,2,3,4,5"})
    void validateLottoNumberOutOfRange(String input) {
        // when
        List<Integer> numbers = new LinkedList();
        String[] splitText = input.split(",");
        for (String Text : splitText){
            numbers.add(Integer.parseInt(Text));
        }

        Throwable exception = getException(numbers);
        // then
        assertEquals(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage(), exception.getMessage());
    }

    @DisplayName("로또 숫자중 범위를 벗어나는 값이 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"2,5,3,4","44,20,22,11","11,1,2,3,4,5,12"})
    void validateLottoCountInvalid(String input) {
        // when
        List<Integer> numbers = new LinkedList();
        String[] splitText = input.split(",");
        for (String Text : splitText){
            numbers.add(Integer.parseInt(Text));
        }

        Throwable exception = getException(numbers);
        // then
        assertEquals(ErrorMessage.LOTTO_NUMBERS_COUNT_INVALID.getMessage(), exception.getMessage());
    }

    @DisplayName("로또 숫자중 중복된 숫자가 있는경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,1,3,3,3","1,2,3,4,5,1"})
    void validateLottoNumberDuplicate(String input) {
        // when
        List<Integer> numbers = new LinkedList();
        String[] splitText = input.split(",");
        for (String Text : splitText){
            numbers.add(Integer.parseInt(Text));
        }

        Throwable exception = getException(numbers);
        // then
        assertEquals(ErrorMessage.LOTTO_NUMBERS_DUPLICATE.getMessage(), exception.getMessage());
    }
    private Throwable getException(String input) {
        return assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validate(input);
        });
    }

    private Throwable getException(List<Integer> numbers) {
        return assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validate(numbers);
        });
    }

}
