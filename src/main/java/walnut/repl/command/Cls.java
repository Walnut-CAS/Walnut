package walnut.repl.command;

import org.petitparser.parser.Parser;
import org.petitparser.parser.primitive.StringParser;
import walnut.repl.Command;
import walnut.repl.ReplContext;

public record Cls() implements Command {

    @Override
    public void execute(ReplContext context) {

        context.clear();
    }

    public static Parser parser() {
        return Command.wrap(StringParser.of("cls").map(in -> new Cls()));
    }
}
