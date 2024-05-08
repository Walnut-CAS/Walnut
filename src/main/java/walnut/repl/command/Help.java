package walnut.repl.command;

import org.petitparser.parser.Parser;
import org.petitparser.parser.primitive.StringParser;
import walnut.repl.Command;

import static org.petitparser.parser.primitive.CharacterParser.whitespace;
import static org.petitparser.parser.primitive.CharacterParser.word;

public record Help(String commandName) implements Command {
    public Help() {
        this("help");
    }

    public static Parser parser() {
        return Command.wrap(helpAbout().or(defaultHelp()));
    }

    private static Parser helpAbout() {
        return StringParser.of("help")
                .seq(whitespace().plus())
                .seq(word().plus().flatten())
                .pick(2)
                .map(commandName -> new Help((String) commandName));
    }

    private static Parser defaultHelp() {
        return StringParser.of("help").map(in -> new Help());
    }
}

