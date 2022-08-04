package moneytransfer.repository;

import moneytransfer.models.Amount;
import moneytransfer.models.Log;
import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;
import moneytransfer.repository.LogRepository;
import moneytransfer.repository.RepositoryInterface;
import moneytransfer.services.logger.LoggerService;
import moneytransfer.services.logger.LoggerServiceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RepositoryTest {
    private final Amount amount = new Amount(
            1000,
            "USD"
    );
    private final Transfer transfer = new Transfer(
            "1234567890",
            "1223",
            "123",
            "09787654321",
            amount
    );
    private final Log log = new Log(transfer);
    private RepositoryInterface repositoryImpl;

    public RepositoryTest() {
        repositoryImpl = Mockito.spy(new LogRepository());
        repositoryImpl.save(log);
    }

    @Test
    public void test_repository_store_instance() {
        final var actual = repositoryImpl.getLogStore();
        Assertions.assertEquals(ConcurrentLinkedQueue.class, actual.getClass());
    }

    @Test
    public void test_repository_adding_to_store() {
        final var actualLog = repositoryImpl.getLogStore().poll();
        Assertions.assertEquals(log, actualLog);
    }

    @Test
    public void test_repository_store_size_after_adding_el() {
        final var actualSize = repositoryImpl.getLogStore().size();
        final var expectedSize = 1;
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void test_repository_get_logs_instance() {
        final var actual = repositoryImpl.getLogs();
        final var expected = Collections.unmodifiableList(new ArrayList<Log>());
        Assertions.assertTrue(actual.getClass().isInstance(expected));
    }
}
