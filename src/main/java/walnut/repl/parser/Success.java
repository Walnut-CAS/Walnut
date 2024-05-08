package walnut.repl.parser;

import walnut.repl.Command;

public record Success(Command command) implements ReplParseResult {
}
