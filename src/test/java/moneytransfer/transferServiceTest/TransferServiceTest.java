package moneytransfer.transferServiceTest;

import moneytransfer.models.*;
import moneytransfer.services.logger.LoggerServiceInterface;
import moneytransfer.services.transfer.TransferServiceInterface;
import moneytransfer.services.transfer.TransferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TransferServiceTest {
    private LoggerServiceInterface loggerServiceMock;
    private TransferServiceInterface transferSeviceImpl;
    private TransferSuccessResponse transferResp;
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
    private final String VERIFICATION_CODE = "0000";
    private ConfirmOperation confirmOperation;


    public TransferServiceTest() {
        loggerServiceMock = Mockito.mock(LoggerServiceInterface.class);
        Mockito.when(loggerServiceMock.log(transfer))
                .thenReturn(log.getId());
        transferSeviceImpl = Mockito.spy(new TransferService(loggerServiceMock));
        transferResp = transferSeviceImpl.transfer(transfer);
        confirmOperation = new ConfirmOperation(transferResp.getOperationId(), VERIFICATION_CODE);
    }

    @Test
    public void test_transfer_service_response_instance() {
        final var actual = transferResp.getClass();
        Assertions.assertEquals(TransferSuccessResponse.class, actual);
    }

    @Test
    public void test_transfer_service_response_equal_ids() {
        final var actualId = transferResp.getOperationId();
        Assertions.assertEquals(log.getId(), actualId);
    }

    @Test
    public void test_transfer_service_confirm_instance() {
        final var actual = transferSeviceImpl.confirm(confirmOperation);
        Assertions.assertEquals(TransferSuccessResponse.class, actual.getClass());
    }

    @Test
    public void test_transfer_service_confirm_equal_ids() {
        final var actualId = transferResp.getOperationId();
        Assertions.assertEquals(confirmOperation.getOperationId(), actualId);
    }
}
