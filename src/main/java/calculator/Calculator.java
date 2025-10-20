package calculator;

import java.math.BigInteger;
import java.util.List;

public class Calculator {
    private final Parser parser = new Parser();

    /**
     * 문자열 덧셈 계산의 진입점
     */
    public BigInteger add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return BigInteger.ZERO;
        }

        // 문자열을 파싱하여 숫자 토큰 목록 얻기
        List<String> tokens = parser.parse(input);

        BigInteger sum = BigInteger.ZERO;
        for (String token : tokens) {
            // 아직은 검증 안 함 (Validator는 다음 단계에서 붙임)
            sum = sum.add(new BigInteger(token));
        }

        return sum;
    }
}
