package walnut.repl.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import walnut.repl.Command;
import walnut.repl.command.*;

import java.util.stream.Stream;

public class ReplParserTest {
    private ReplParser parser;

    @BeforeEach
    public void createParser() {
        parser = new ReplParser();
    }

    @ParameterizedTest(name="[{index}] \"{0}\" should successful parse into `{1}`")
    @MethodSource("parseableCommands")
    public void shouldParseSuccessfully(String input, Command expected) {
        ReplParseResult actual = parser.parse(input);

        Assertions.assertInstanceOf(Success.class, actual);
        Assertions.assertEquals(expected, ((Success) actual).command());
    }

    @ParameterizedTest(name="[{index}] \"{0}\" should fail to parse")
    @MethodSource("unparseableCommands")
    public void shouldFailToParse(String input) {
        ReplParseResult actual = parser.parse(input);

        Assertions.assertInstanceOf(Failure.class, actual);
    }

    private static Stream<Arguments> parseableCommands() {
        return Stream.of(
                Arguments.of("help;", new Help()),
                Arguments.of(" help;", new Help()),
                Arguments.of("help ;", new Help()),
                Arguments.of("help; ", new Help()),
                Arguments.of("  help ; ", new Help()),
                Arguments.of("help cls;", new Help("cls")),
                Arguments.of("cls;", new Cls()),
                Arguments.of(" cls;", new Cls()),
                Arguments.of("cls ;", new Cls()),
                Arguments.of("cls; ", new Cls()),
                Arguments.of(" cls ;  ", new Cls()),
                Arguments.of("draw AUT;", new Draw("AUT")),
                Arguments.of("draw $aut;", new Draw("$aut"))
        );
    }

    private static Stream<Arguments> unparseableCommands() {
        return Stream.of(
                Arguments.of("help"),
                Arguments.of("hlp;"),
                Arguments.of("clr;"),
                Arguments.of("draw;"),
                Arguments.of("drw AUT;")
        );
    }
}

