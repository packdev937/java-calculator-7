package calculator.domain.vo.delimiter;

import static calculator.domain.vo.delimiter.constants.DelimiterPatterns.*;

import calculator.domain.vo.number.Number;
import calculator.domain.vo.number.Numbers;
import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private final List<Delimiter> delimiters;

    private Delimiters(List<Delimiter> values) {
        validate(values);
        this.delimiters = values;
    }

    private void validate(List<Delimiter> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static Delimiters from(String input) {
        List<Delimiter> delimiters = new ArrayList<>();
        addDefaultDelimiters(delimiters);
        addCustomDelimiter(delimiters, input);

        return new Delimiters(delimiters);
    }

    private static void addDefaultDelimiters(List<Delimiter> delimiters) {
        delimiters.add(Delimiter.from(COLON.getValue()));
        delimiters.add(Delimiter.from(COMMA.getValue()));
    }

    private static void addCustomDelimiter(List<Delimiter> delimiters, String input) {
        String customDelimiter = parseCustomDelimiter(input);
        if (!customDelimiter.isEmpty()) {
            delimiters.add(Delimiter.from(customDelimiter));
        }
    }

    private static String parseCustomDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX.getValue()) && input.contains(CUSTOM_DELIMITER_SUFFIX.getValue())) {
            return input.substring(2, input.indexOf(CUSTOM_DELIMITER_SUFFIX.getValue()));
        }
        return EMPTY.getValue();
    }

    public Numbers extractNumbers(String input) {
        String[] values = input.split(getDelimiterRegex());
        List<Number> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(Number.from(value));
        }
        return Numbers.from(numbers);
    }

    private String getDelimiterRegex() {
        StringBuilder regex = new StringBuilder();
        for (Delimiter delimiter : delimiters) {
            regex.append(delimiter.getDelimiter());
            regex.append(PIPE.getValue());
        }
        regex.deleteCharAt(regex.length() - 1);
        return regex.toString();
    }
}
