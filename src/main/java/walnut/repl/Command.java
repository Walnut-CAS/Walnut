package walnut.repl;

import org.petitparser.parser.Parser;
import org.petitparser.parser.primitive.CharacterParser;

public interface Command {
    static Parser wrap(Parser commandParser){
       return commandParser.trim()
               .seq(CharacterParser.of(';').trim())
               .pick(0);
    }
}
