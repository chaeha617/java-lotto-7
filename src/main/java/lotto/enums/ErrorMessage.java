package lotto.enums;

enum ErrorHeader {
    ERROR_HEADER("[ERROR]");

    private final String header;

    ErrorHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}


public enum ErrorMessage {
    NULL_ERROR("입력 값이 없습니다."),
    AMOUNT_ONLY_INTEGER("구입 금액은 부호가 없는 숫자여야 합니다."),
    AMOUNT_BELOW_LOTTO_PRICE("구입 금액은 " + LottoConfig.LOTTO_PRICE.getValue() + " 이상이여야 합니다."),
    AMOUNT_NOT_DIVISIBLE_BY_LOTTO_PRICE("구입 금액은 " + LottoConfig.LOTTO_PRICE.getValue() + "으로 나누어 떨어져야 합니다."),
    LOTTO_INPUT_FORMAT_IS_INCORRECT("로또 번호는 정수여야 하며, 쉼표로 구분되어야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는"
        + LottoConfig.LOTTO_MIN_NUMBER.getValue()
        + "~"
        + LottoConfig.LOTTO_MAX_NUMBER.getValue()
        +"사이의 값이여야 합니다."
        ),
    LOTTO_NUMBERS_COUNT_INVALID("로또 번호는 "
        + LottoConfig.LOTTO_NUMBER_COUNT.getValue()
        + "개여야 합니다."
        ),
    LOTTO_NUMBERS_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_ONLY_INTEGER("보너스 번호는 정수여야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는"
            + LottoConfig.LOTTO_MIN_NUMBER.getValue()
            + "~"
            + LottoConfig.LOTTO_MAX_NUMBER.getValue()
            +"사이의 값이여야 합니다."
    ),
    BONUS_NUMBER_DUPLICATE("당첨 번호와 보너스 번호는 중복 될 수 없습니다.");



    private final String message;

    ErrorMessage(String message) { this.message = message; }

    public String getMessage(){ return ErrorHeader.ERROR_HEADER.getHeader() + message; }
}
