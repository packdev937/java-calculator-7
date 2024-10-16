package calculator.domain.vo.number;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Number> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static Numbers from(final List<Number> numbers) {
        return new Numbers(numbers);
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public BigInteger reduce() {
        return numbers.stream()
            .map(Number::getNumber)
            .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
