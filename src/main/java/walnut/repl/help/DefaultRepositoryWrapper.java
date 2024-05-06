package walnut.repl.help;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * A {@code HelpRepository} wrapper that provides a default help message when the delegate does not provide
 * a help message.
 */
class DefaultRepositoryWrapper implements HelpRepository {
    private static final String DEFAULT_MESSAGE_LOCATION = "/help/default-help-message.txt";
    private static final String BACKUP_MESSAGE = "[TODO] place a help message at DEFAULT_MESSAGE_LOCATION";

    /**
     * Create a {@code DefaultRepositoryWrapper} that reads the default help message as a resource from
     * {@code "/help/default-help-message.txt"}.
     *
     * @param delegate the {@code HelpRepository} to wrap.
     * @return a {@code DefaultRepositoryWrapper}.
     */
    public static HelpRepository wrap(HelpRepository delegate) {
        String defaultHelpMessage = BACKUP_MESSAGE;
        try (InputStream input = DefaultRepositoryWrapper.class.getResourceAsStream(DEFAULT_MESSAGE_LOCATION)) {
            if (input != null) {
                defaultHelpMessage = new String(input.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException | NullPointerException e) {
            /* we will rely on the backup message when these exceptions occur */
        }

        return new DefaultRepositoryWrapper(defaultHelpMessage, delegate);
    }

    private final String defaultHelpMessage;
    private final HelpRepository delegate;

    public DefaultRepositoryWrapper(String defaultHelpMessage, HelpRepository delegate) {
        this.defaultHelpMessage = defaultHelpMessage;
        this.delegate = delegate;
    }


    @Override
    public String helpForCommand(String commandName) {
        String helpMessage = delegate.helpForCommand(commandName);
        return (helpMessage != null ? helpMessage : defaultHelpMessage);
    }
}
