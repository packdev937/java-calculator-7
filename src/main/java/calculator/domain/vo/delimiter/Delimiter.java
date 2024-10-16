package calculator.domain.vo.delimiter;

import java.util.Objects;

public class Delimiter {

    private final String delimiter;

    private Delimiter(final String delimiter) {
        validate(delimiter);
        this.delimiter = delimiter;
    }

    protected void validate(final String delimiter) {
        if (delimiter == null || delimiter.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    public static Delimiter from(String delimiter) {
        return new Delimiter(delimiter);
    }

    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Delimiter)) {
            return false;
        }
        Delimiter delimiter = (Delimiter) o;
        return this.delimiter.equals(delimiter.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }

    @Override
    public String toString() {
        return String.format("Delimiter = '%s'", delimiter);
    }
}
