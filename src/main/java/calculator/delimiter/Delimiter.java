package calculator.delimiter;

/* 기본 구분자 관리: 쉼표(,) 또는 콜론(:) */
public final class Delimiter {
    private static final String BASIC_REGEX = "[,:]";

    private Delimiter() {} // 유틸 클래스

    public static String getBasicDelimiterRegex() {
        return BASIC_REGEX;
    }
}
