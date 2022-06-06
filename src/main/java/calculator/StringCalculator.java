package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {
    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splittedInput = getSplittedInput(input);
        validateInputContainsPositiveOrZero(splittedInput);
        return getSum(splittedInput);
    }

    private void validateInputContainsPositiveOrZero(String[] splittedInput) {
        Arrays.stream(splittedInput)
                .filter(s -> Integer.parseInt(s) < 0)
                .findAny()
                .ifPresent(s -> {
                    throw new RuntimeException();
                });
    }

    private int getSum(String[] splittedInput) {
        return Stream.of(splittedInput)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String[] getSplittedInput(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split("[,:]");
    }
}
