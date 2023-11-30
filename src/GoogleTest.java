import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GoogleTest {

    private GoogleSolutions googleSolutions = new GoogleSolutions();

    @ParameterizedTest
    @MethodSource("getPossibleInputsForProblem1")
    void solution1Test(String input, int output) {
        int solution = googleSolutions.solution1(input);
        assertEquals(output, solution);
    }

    private static Stream<Arguments> getPossibleInputsForProblem1() {
        return Stream.of(
                Arguments.of("abaaba", 2),
                Arguments.of("ababab", 3),
                Arguments.of("abbcaabbca", 2),
                Arguments.of("aaaaaaa", 7)
        );
    }

    @ParameterizedTest
    @MethodSource("getPossibleInputsForProblem2")
    void solution2Test(String input, int output) throws IOException {
        int solution = googleSolutions.solution2(input);
        assertEquals(output, solution);
    }

    private static Stream<Arguments> getPossibleInputsForProblem2() {
        return Stream.of(
                Arguments.of(">----<",2),
                Arguments.of("<<><<",4),
                Arguments.of("--->-><-><-->-",10),
                Arguments.of("--<->-->-<<-",8)
        );
    }

    @ParameterizedTest
    @MethodSource("getPossibleInputsForProblem3")
    void solution1Test(String input, int b, String output) throws IOException {
        String solution = googleSolutions.solution3(input, b);
        assertEquals(output, solution);
    }

    private static Stream<Arguments> getPossibleInputsForProblem3() {
        return Stream.of(
                Arguments.of("1211",10,"1"),
                Arguments.of("210022",3,"3")
        );
    }
}