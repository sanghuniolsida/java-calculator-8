package calculator;

import calculator.delimiter.CustomDelimiter;
import calculator.delimiter.Delimiter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 문자열을 구분자 규칙에 따라 토큰(숫자 문자열)으로 분리
 * - 기본 구분자: 쉼표(,), 콜론(:)
 * - 커스텀 구분자: //x\n (형식 검증은 CustomDelimiter.parse에서 수행)
 */
class Parser {

    public List<String> parse(String input) {
        if (input == null) throw new IllegalArgumentException();

        if (CustomDelimiter.isCustom(input)) {
            var r = CustomDelimiter.parse(input);
            return Arrays.asList(r.body.split(r.combinedRegex(), -1));
        }

        return Arrays.asList(input.split(Delimiter.getBasicDelimiterRegex(), -1));
    }
}