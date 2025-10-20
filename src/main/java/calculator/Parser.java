package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.CustomDelimiter;

import java.util.Arrays;
import java.util.List;

class Parser {

    /*
     * 입력 문자열을 구분자 기준으로 분리하여 숫자 문자열 리스트로 반환
     * - 기본 구분자: 쉼표(,), 콜론(:)
     * - 커스텀 구분자: //x\n 형태
     */
    public List<String> parse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null입니다.");
        }

        if (CustomDelimiter.isCustom(input)) {
            CustomDelimiter.Resolution r = CustomDelimiter.resolve(input);

            if (r.body == null || r.body.isEmpty()) {
                return List.of();
            }

            return Arrays.asList(r.body.split(r.splitRegex, -1));
        }

        String regex = Delimiter.getBasicDelimiterRegex();
        return Arrays.asList(input.split(regex, -1));
    }
}