package calculator;

import java.math.BigInteger;

final class Validator {
    private Validator() {}

    static BigInteger validateToken(String raw) {
        if (raw == null) throw new IllegalArgumentException("입력값이 null입니다.");
        String s = raw.trim();
        if (s.isEmpty()) throw new IllegalArgumentException("토큰이 비어있습니다.");
        if (s.charAt(0) == '-') throw new IllegalArgumentException("음수는 허용되지 않습니다: " + s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다: " + s);
        }
        return new BigInteger(s);
    }
}