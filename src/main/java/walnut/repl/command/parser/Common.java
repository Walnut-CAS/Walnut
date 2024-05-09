package walnut.repl.command.parser;

import org.petitparser.parser.Parser;
import org.petitparser.parser.primitive.CharacterParser;

import static org.petitparser.parser.primitive.CharacterParser.word;

public class Common {
    public static Parser automatonName() {
        return CharacterParser.of('$').optional()
                .seq(word().plus())
                .flatten();
    }
}
