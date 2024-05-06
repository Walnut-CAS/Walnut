package walnut.repl.help;

import java.util.HashMap;

/**
 * A {@code HelpRepository} wrapper that caches help messages it already knows about.
 */
public class CacheRepositoryWrapper implements HelpRepository {
    private final HelpRepository delegate;
    private final HashMap<String, String> cache;

    public CacheRepositoryWrapper(HelpRepository delegate) {
        this.delegate = delegate;
        cache = new HashMap<>();
    }

    @Override
    public String helpForCommand(String commandName) {
        cache.computeIfAbsent(commandName, delegate::helpForCommand);
        return cache.get(commandName);
    }

    public void load(String commandName, String helpMessage) {
        this.cache.put(commandName, helpMessage);
    }
}
