package walnut.repl.help;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CacheRepositoryWrapperTest {
    private static final String UNKNOWN_COMMAND = "unknown command";
    private static final String KNOWN_COMMAND = "known command";
    private static final String HELP_MESSAGE = "a help message";
    private HelpRepository mock;
    private HelpRepository repository;

    @BeforeEach
    public void createHelpRepositories() {
        mock = mock(HelpRepository.class);
        repository = new CacheRepositoryWrapper(mock);
    }

    @Test
    public void whenAnCommandIsNotCachedItShouldBeFetchedFromDelegate() {
        repository.helpForCommand(UNKNOWN_COMMAND);

        verify(mock).helpForCommand(UNKNOWN_COMMAND);
    }

    @Test
    public void whenAnCommandIsCachedDelegateShouldNotBeAsked() {
        ((CacheRepositoryWrapper) repository).load(KNOWN_COMMAND, HELP_MESSAGE);

        repository.helpForCommand(KNOWN_COMMAND);

        verify(mock, never()).helpForCommand(any());
    }

    @Test
    public void whenTheDelegateDoesNotKnownTheCommandNullIsReturned() {
        when(mock.helpForCommand(UNKNOWN_COMMAND)).thenReturn(null);

        String actual = repository.helpForCommand(UNKNOWN_COMMAND);

        Assertions.assertNull(actual);
    }
}



