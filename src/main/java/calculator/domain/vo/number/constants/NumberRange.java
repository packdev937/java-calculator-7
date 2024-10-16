package calculator.domain.vo.number.constants;

public enum NumberRange {
    ZERO(0),
    MIN_VALID_NUMBER(1),
    MAX_VALID_NUMBER(1000);

    private final int value;

    NumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

/**
 * Constants의 이름은 그 용도에 맞게 작명한다.
 *
 * Pattern, Range, Number 등등
 */
