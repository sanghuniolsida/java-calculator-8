package calculator.delimiter;

/* 기본 구분자 관리: 쉼표(,) 또는 콜론(:) */
public final class Delimiter {
    private static final String BASIC_REGEX = "[,:]";

    // 유틸리티 클래스로, 불필요한 객체 생성을 차단
    private Delimiter() {}

    public static String getBasicDelimiterRegex() {
        return BASIC_REGEX;
    }
}
