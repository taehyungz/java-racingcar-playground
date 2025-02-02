package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    private StringCalculator sut;

    @BeforeEach
    void init() {
        sut = new StringCalculator();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void Sum_of_null_or_empty_string_returns_zero(String input) {
        int result = sut.splitAndSum(input);

        Assertions.assertThat(result).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    void Sum_of_one_number_returns_input(String input, int answer) {
        int result = sut.splitAndSum(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2',3", "'1,2,3',6"})
    void Sum_of_string_with_comma_returns_sum_of_each_number(String input, int answer) {
        int result = sut.splitAndSum(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @Test
    void String_can_be_splitted_by_colon() {
        String input = "1,2:3";

        int result = sut.splitAndSum(input);

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void Calculator_can_use_custome_separator() {
        String input = "//;\n1;2;3";

        int result = sut.splitAndSum(input);

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void If_given_string_contains_negative_number_then_throw_runtime_exception() {
        String input = "-1,2,3";

        assertThrows(RuntimeException.class, () -> sut.splitAndSum(input));
    }
}
