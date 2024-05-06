package walnut.repl.help;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultRepositoryWrapperTest {
    private static final String KNOWN_COMMAND = "known command";
    private static final String KNOWN_HELP_MESSAGE = "known help message";
    private static final String UNKNOWN_COMMAND = "unknown command";
    private static final String DEFAULT_HELP_MESSAGE_FORMAT = "default help message for %s";
    private HelpRepository delegate;
    private HelpRepository repository;

    @BeforeEach
    public void createHelpRepositoryMock() {
        delegate = mock(HelpRepository.class);
        repository = new DefaultRepositoryWrapper(DEFAULT_HELP_MESSAGE_FORMAT, delegate);
    }

    @Test
    public void whenAnDelegateDoesKnowAnCommandThatMessageIsReturned() {
        when(delegate.helpForCommand(KNOWN_COMMAND)).thenReturn(KNOWN_HELP_MESSAGE);

        String actual = repository.helpForCommand(KNOWN_COMMAND);

        Assertions.assertEquals(KNOWN_HELP_MESSAGE, actual);
    }

    @Test
    public void whenAnDependencyDoesNotKnowAnCommandTheDefaultHelpMessageIsReturned() {
        when(delegate.helpForCommand(UNKNOWN_COMMAND)).thenReturn(null);

        String actual = repository.helpForCommand(UNKNOWN_COMMAND);

        Assertions.assertEquals(String.format(DEFAULT_HELP_MESSAGE_FORMAT, UNKNOWN_COMMAND), actual);
    }
}

