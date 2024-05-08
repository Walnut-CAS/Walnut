package walnut.repl;

import walnut.repl.help.CacheRepositoryWrapper;
import walnut.repl.help.DefaultRepositoryWrapper;
import walnut.repl.help.ResourceRepository;

import java.io.PrintStream;

public class ReplContext implements HelpRepository {
    private final HelpRepository repository;
    private final PrintStream out;

    public ReplContext() {
        repository = DefaultRepositoryWrapper.wrap(new CacheRepositoryWrapper(new ResourceRepository()));
        out = System.out;
    }

    public String helpForCommand(String commandName) {
        return repository.helpForCommand(commandName);
    }

    public void output(String message) {
        out.print(message);
    }

    public void clear() {
        out.print("\033[H\033[2J");
        out.flush();
    }
}
