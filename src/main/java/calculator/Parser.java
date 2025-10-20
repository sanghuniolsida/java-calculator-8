package calculator;

import calculator.delimiter.CustomDelimiter;
import calculator.delimiter.Delimiter;

import java.util.Arrays;
import java.util.List;

class Parser {

    public List<String> parse(String input) {
        if (CustomDelimiter.isCustom(input)) {
            var r = CustomDelimiter.parse(input);
            return Arrays.asList(r.body.split(r.combinedRegex(), -1));
        }

        return Arrays.asList(input.split(Delimiter.getBasicDelimiterRegex(), -1));
    }
}