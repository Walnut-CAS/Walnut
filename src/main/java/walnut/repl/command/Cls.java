package walnut.repl.command;

import org.petitparser.parser.Parser;
import org.petitparser.parser.primitive.StringParser;
import walnut.repl.Command;

public record Cls() implements Command {
    public static Parser parser() {
        return Command.wrap(StringParser.of("cls").map(in -> new Cls()));
    }
}
