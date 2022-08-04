package moneytransfer.loggerServiceTest;

import moneytransfer.models.Amount;
import moneytransfer.models.Log;
import moneytransfer.models.Transfer;
import moneytransfer.repository.LogRepository;
import moneytransfer.services.logger.LoggerService;
import moneytransfer.services.logger.LoggerServiceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LoggerServiceTest {
    final private LoggerServiceInterface loggerServiceImpl;
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
    private LogRepository logRepo;
    private final Log log = new Log(transfer);

    public LoggerServiceTest() {
        logRepo = Mockito.mock(LogRepository.class);
        loggerServiceImpl = Mockito.spy(new LoggerService(logRepo));
        Mockito.doReturn(log).when(loggerServiceImpl)
                .createLog(transfer);
    }

    @Test
    public void test_logger_service_log_creating_instance() {
        final var actual = loggerServiceImpl.createLog(transfer);
        Assertions.assertEquals(Log.class, actual.getClass());
    }

    @Test
    public void test_logger_service_log_response() {
        final var actual = loggerServiceImpl.log(transfer);
        Assertions.assertEquals(log.getId(), actual);
    }

    @Test
    public void test_logger_service_get_logs() {
        final var actual = loggerServiceImpl.getLogsList();
        Assertions.assertEquals(logRepo.getLogs(), actual);
    }
}
