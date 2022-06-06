package calculator;

public class StringCalculator {
    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splittedInput = getSplittedInput(input);
        return getSum(splittedInput);
    }

    private int getSum(String[] splittedInput) {
        int sum = 0;
        for (String number : splittedInput) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private String[] getSplittedInput(String input) {
        return input.split("[,:]");
    }
}
