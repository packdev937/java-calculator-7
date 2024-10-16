package calculator.domain.vo.delimiter.constants;

public enum DelimiterPatterns {
    COMMA(","),
    COLON(":"),
    CUSTOM_DELIMITER_PREFIX("//"),
    CUSTOM_DELIMITER_SUFFIX("\n");

    private final String value;

    DelimiterPatterns(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
