package calculator;

import java.math.BigInteger;

final class Validator {
    private Validator() {}

    static BigInteger validateToken(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("토큰이 null입니다.");
        }

        String s = raw.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException("토큰이 비어있습니다.");
        }

        // 부호 없는 순수 숫자만
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + s);
            }
        }

        return new BigInteger(s);
    }
}