package walnut.repl.parser;

import org.petitparser.context.Result;
import org.petitparser.parser.Parser;
import walnut.repl.command.*;

public class ReplParser {
    private Parser parser;

    public ReplParseResult parse(String input) {
        Result result = parser().parse(input);
        if (result.isSuccess()) {
            return new Success(result.get());
        } else {
            return new Failure();
        }
    }

    private Parser parser() {
        if (parser == null) {
            parser = replParser();
        }
        return parser;
    }

    private Parser replParser() {
        return Help.parser()
                .or(Cls.parser())
                .or(Draw.parser());
    }
}
