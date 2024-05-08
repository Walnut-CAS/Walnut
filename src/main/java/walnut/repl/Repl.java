package walnut.repl;

import walnut.repl.parser.Failure;
import walnut.repl.parser.ReplParseResult;
import walnut.repl.parser.ReplParser;
import walnut.repl.parser.Success;

import java.awt.image.ReplicateScaleFilter;

public class Repl {
    private ReplParser parser = new ReplParser();
    private ReplContext context = new ReplContext();

    public void run() {
        while (true) {
            String input = "help;"; // read input
            ReplParseResult result = parser.parse(input);
            if (result instanceof Success success) {
                Command command = success.command();
                command.execute(context);
            } else { // result is a Failure
                Failure failure = (Failure) result;
                // handle failure
            }

        }
    }
}
