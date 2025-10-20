package calculator;

import java.math.BigInteger;
import java.util.List;

public class Calculator {
    private final Parser parser = new Parser();

    public BigInteger add(String input) {
        if (input == null) throw new IllegalArgumentException();
        String s = input.trim();
        if (s.isEmpty()) return BigInteger.ZERO;

        List<String> tokens = parser.parse(s);

        BigInteger sum = BigInteger.ZERO;
        for (String t : tokens) {
            sum = sum.add(Validator.validateToken(t));
        }
        return sum;
    }
}