package calculator;

public class StringCalculator {
    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splittedInput = input.split(",");
        int sum = 0;
        for (String number : splittedInput) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
