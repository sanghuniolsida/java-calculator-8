package calculator.delimiter;

import java.util.regex.Pattern;

public final class CustomDelimiter {
    private static final String PREFIX = "//";
    private static final char REAL_NL = '\n';
    private static final String LITERAL_NL = "\\n";

    private CustomDelimiter() {}

    public static final class Resolution {
        public final String delimiterPart;
        public final String body;

        public Resolution(String delimiterPart, String body) {
            this.delimiterPart = delimiterPart;
            this.body = body;
        }

        public String combinedRegex() {
            return "(?:" + Delimiter.getBasicDelimiterRegex() + "|" + Pattern.quote(delimiterPart) + ")";
        }
    }

    public static boolean isCustom(String input) {
        return input != null && input.startsWith(PREFIX);
    }

    /* 실개행(\n)과 리터럴("\\n") */
    public static Resolution parse(String input) {
        if (input == null) throw new IllegalArgumentException();

        int idxReal = input.indexOf(REAL_NL);
        int idxLit  = input.indexOf(LITERAL_NL);

        final boolean usedReal;
        final int sepIdx;
        if (idxReal >= 0 && (idxLit < 0 || idxReal < idxLit)) {
            usedReal = true;
            sepIdx = idxReal;
        } else if (idxLit >= 0) {
            usedReal = false;
            sepIdx = idxLit;
        } else {
            throw new IllegalArgumentException();
        }

        String delimPart = input.substring(PREFIX.length(), sepIdx);
        if (delimPart.length() != 1) throw new IllegalArgumentException();
        char custom = delimPart.charAt(0);
        if (Character.isISOControl(custom)) throw new IllegalArgumentException();

        String body = usedReal
                ? input.substring(sepIdx + 1)                  // 실제 개행 뒤
                : input.substring(sepIdx + LITERAL_NL.length()); // 리터럴 "\n" 뒤

        if (body.isEmpty()) throw new IllegalArgumentException();

        return new Resolution(delimPart, body);
    }
}