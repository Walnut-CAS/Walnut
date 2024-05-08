package walnut.repl.help;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import walnut.repl.HelpRepository;

import static org.mockito.Mockito.mock;

public class DefaultRepositoryWrapperFactoryTest {
    private static final String UNKNOWN_COMMAND = "unknown command";
    private static final String EXPECTED_HELP_MESSAGE = "default help message";
    private HelpRepository delegate;

    @BeforeEach
    public void createDelegateHelpRepository() {
        delegate = mock(HelpRepository.class);
    }

    @Test
    public void theDefaultRepositoryWrapperFactoryLoadsTheDefaultHelpMessageFromResources() {
        HelpRepository repository = DefaultRepositoryWrapper.wrap(delegate);

        String actual = repository.helpForCommand(UNKNOWN_COMMAND);

        Assertions.assertEquals(EXPECTED_HELP_MESSAGE, actual);
    }
}
