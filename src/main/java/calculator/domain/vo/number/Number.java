package calculator.domain.vo.number;

import static calculator.domain.vo.number.constants.NumberRange.*;

import calculator.domain.vo.delimiter.Delimiter;
import java.math.BigInteger;
import java.util.Objects;

public class Number {

    private final BigInteger number;

    private Number(final String number) {
        validate(number);
        this.number = new BigInteger(number);
    }

    private void validate(final String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException();
        }

        try {
            new BigInteger(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        BigInteger bigNumber = new BigInteger(number);
        if (bigNumber.compareTo(BigInteger.valueOf(MIN_VALID_NUMBER.getValue())) < 0 ||
            bigNumber.compareTo(BigInteger.valueOf(MAX_VALID_NUMBER.getValue())) > 0) {
            throw new IllegalArgumentException();}
    }

    public static Number from(final String number) {
        return new Number(number);
    }

    public BigInteger getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Number)) {
            return false;
        }
        Number number = (Number) o;
        return this.number.equals(number.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.format("Number = %s", number);
    }
}
