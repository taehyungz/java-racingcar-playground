package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

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
        int result = sut.sum(input);

        Assertions.assertThat(result).isZero();
    }
}
