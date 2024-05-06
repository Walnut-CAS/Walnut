package walnut.repl.help;

/**
 * A repository for help messages.
 */
public interface HelpRepository {
    /**
     * Will look up a help message given a command name.
     *
     * @param commandName The name of the command to search the help message for.
     * @return a help message, or {@code null} when no help message is known for {@code commandName}.
     */
    String helpForCommand(String commandName);
}
