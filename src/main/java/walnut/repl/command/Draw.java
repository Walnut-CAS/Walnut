package walnut.repl.command;

import org.petitparser.parser.Parser;
import org.petitparser.parser.primitive.StringParser;
import walnut.repl.Command;
import walnut.repl.ReplContext;
import walnut.repl.command.parser.Common;

import static org.petitparser.parser.primitive.CharacterParser.whitespace;

public record Draw(String automatonName) implements Command {

    @Override
    public void execute(ReplContext context) {
        throw new RuntimeException("TODO");
    }

    public static Parser parser() {
        return Command.wrap(StringParser.of("draw")
                .seq(whitespace().plus())
                .seq(Common.automatonName())
                .pick(2)
                .map(automatonName -> new Draw((String) automatonName)));
    }

}
