package transferServiceTest;

import moneytransfer.models.Amount;
import moneytransfer.models.Log;
import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;
import moneytransfer.services.logger.LoggerServiceInterface;
import moneytransfer.services.transfer.TransferServiceInterface;
import moneytransfer.services.transfer.TransferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TransferServiceTest {
    private LoggerServiceInterface loggerServiceMock;
    private TransferServiceInterface transferSeviceImpl;
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

    public TransferServiceTest() {
        loggerServiceMock = Mockito.mock(LoggerServiceInterface.class);
        Mockito.when(loggerServiceMock.log(transfer))
                .thenReturn(log.getId());
        transferSeviceImpl = Mockito.spy(new TransferService(loggerServiceMock));
    }

    @Test
    public void test_transfer_service_response_instance() {
        final var actual = transferSeviceImpl.transfer(transfer);
        Assertions.assertEquals(TransferSuccessResponse.class, actual.getClass());
    }

    @Test
    public void test_transfer_service_response_equal_ids() {
        final var resp = transferSeviceImpl.transfer(transfer);
        final var actualId = resp.getOperationId();
        Assertions.assertEquals(log.getId(), actualId);
    }
}
