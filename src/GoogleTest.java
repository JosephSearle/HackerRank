import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GoogleTest {

    private Main main = new Main();

    @ParameterizedTest
    @MethodSource("getPossibleInputs")
    void solution1Test(String input, int output) throws IOException {
        int solution = main.solution(input);
        assertEquals(output, solution);
    }

    private static Stream<Arguments> getPossibleInputs() {
        return Stream.of(
                Arguments.of("abccbaabccba",2),
                Arguments.of("abcabcabcabc",4),
                Arguments.of("abccbaabccba",2),
                Arguments.of("abcabcabcabc",4)
        );
    }
}