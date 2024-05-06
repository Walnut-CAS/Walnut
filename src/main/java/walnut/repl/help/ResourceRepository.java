package walnut.repl.help;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * A {@code HelpRepository} that reads the help messages as resource from {@code "/help/<COMMAND_NAME>.txt"}.
 */
public class ResourceRepository implements HelpRepository {

    @Override
    public String helpForCommand(String commandName) {
        try (InputStream input = getClass().getResourceAsStream(String.format("/help/%s.txt", commandName))) {
            if (input != null) {
                return new String(input.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException | NullPointerException e) {
            /* when an exception occurs we are going to fall through to not knowing the command. */
        }
        return null;
    }
}
