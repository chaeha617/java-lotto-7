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
    AMOUNT_BELOW_LOTTO_PRICE("구입 금액은 " + LottoConfig.LOTTO_PRICE + " 이상이여야 합니다."),
    AMOUNT_NOT_DIVISIBLE_BY_LOTTO_PRICE("구입 금액은 " + LottoConfig.LOTTO_PRICE + "으로 나누어 떨어져야 합니다.");



    private final String message;

    ErrorMessage(String message) { this.message = message; }

    public String getMessage(){ return ErrorHeader.ERROR_HEADER.getHeader() + message; };
}
