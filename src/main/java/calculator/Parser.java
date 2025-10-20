package calculator;

import java.util.Arrays;
import java.util.List;

class Parser {
    private final Delimiter delimiter = new Delimiter();

    /**
     * 입력 문자열을 구분자 기준으로 분리하여 숫자 문자열 리스트로 반환
     */
    public List<String> parse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null입니다.");
        }

        String regex = delimiter.getBasicDelimiterRegex();

        return Arrays.asList(input.split(regex));
    }
}