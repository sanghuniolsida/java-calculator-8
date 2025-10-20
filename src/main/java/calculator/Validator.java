package calculator;

import java.math.BigInteger;

public final class Validator {
    private Validator() {}

    public static void validateDelimiter(String delimiterPart) {
        if (delimiterPart == null || delimiterPart.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 정확히 1문자여야 합니다.");
        }
    }

    /* 숫자 토큰 검증 (추가 예정) */
    public static BigInteger validateToken(String raw) {
        return new BigInteger(raw.trim());
    }
}