package calculator;

import java.math.BigInteger;

final class Validator {
    private Validator() {}

    static BigInteger validateToken(String raw) {
        if (raw == null) throw new IllegalArgumentException();
        String s = raw.trim();
        if (s.isEmpty()) throw new IllegalArgumentException();
        if (s.charAt(0) == '-') throw new IllegalArgumentException();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') throw new IllegalArgumentException();
        }
        return new BigInteger(s);
    }
}