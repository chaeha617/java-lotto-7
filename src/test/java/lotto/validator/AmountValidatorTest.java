package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountValidatorTest {

    @DisplayName("아무런 값을 입력하지 않았을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.NULL_ERROR.getMessage(), exception.getMessage());
    }

    @DisplayName("입력된 값이 부호가 없는 숫자가 아닐 경우")
    @ParameterizedTest
    @ValueSource(strings = {"12dfasd","123ㅇ","1 23","-123","+14564"})
    void validateNotInteger(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.AMOUNT_ONLY_INTEGER.getMessage(), exception.getMessage());
    }

    @DisplayName("구입 금액이 로또 단가로 나누어 지지 않을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"112345","1001","1004"})
    void validateNotDivisibleByLottoPrice(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.AMOUNT_NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage(), exception.getMessage());
    }

    @DisplayName("로또 단가보다 구입금액이 적을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"90","200","20"})
    void validateBeLowLottoPrice(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.AMOUNT_BELOW_LOTTO_PRICE.getMessage(), exception.getMessage());
    }

    private Throwable getException(String input) {
        return assertThrows(IllegalArgumentException.class, () -> {
            AmountValidator.validate(input);
        });
    }

}
