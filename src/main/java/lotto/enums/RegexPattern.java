package lotto.enums;

import java.util.regex.Pattern;

public enum RegexPattern {
    NOT_ONLY_NUMBER(Pattern.compile(".*[\\D].*")),
    //숫자로 시작하며 숫자뒤 쉼표(,)또는 쉼표와 공백(, )으로 구분된 숫자가 반복되는 정규 표현식
    LOTTO_NUMBERS_FORMAT(Pattern.compile("^\\d+(,\\s*\\d+)*$"));
    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
