package walnut.repl.help;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResourceRepositoryTest {
    private static final String KNOWN_COMMAND = "known-command";
    private static final String UNKNOWN_COMMAND = "unknown-command";
    private static final String EXPECTED_HELP_MESSAGE = "A help message";
    private HelpRepository repository;


    @BeforeEach
    public void createResourceRepository() {
        repository = new ResourceRepository();
    }

    @Test
    public void helpMessagesForCommandsAreReadFromResources() {
        String actual = repository.helpForCommand(KNOWN_COMMAND);

        Assertions.assertEquals(EXPECTED_HELP_MESSAGE, actual);
    }

    @Test
    public void unKnownCommandsReturnNull() {
        String actual = repository.helpForCommand(UNKNOWN_COMMAND);

        Assertions.assertNull(actual);
    }
}

