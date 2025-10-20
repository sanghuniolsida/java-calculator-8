package calculator;

/**
 * 문자열 구분자 관리 클래스
 * - 기본 구분자(, :)를 우선 지원
 * - 추후 커스텀 구분자(//<구분자>\n) 규칙 추가 예정
 */
class Delimiter {
    private static final String BASIC_DELIMITERS = ",:";

    public String getBasicDelimiterRegex() {
        return "[" + BASIC_DELIMITERS + "]";
    }
}