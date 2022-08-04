package moneytransfer.services.transfer;

import moneytransfer.models.ConfirmOperation;
import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;
import moneytransfer.models.exceptions.InvalidPaymentException;
import moneytransfer.services.logger.LoggerServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class TransferService implements TransferServiceInterface {
    private LoggerServiceInterface loggerService;

    public TransferService(LoggerServiceInterface loggerService) {
        this.loggerService = loggerService;
    }

    public TransferSuccessResponse transfer(Transfer transfer) {
        try {
            return new TransferSuccessResponse(loggerService.log(transfer));
        } catch (InvalidPaymentException ex) {
            throw new InvalidPaymentException("Error customer message!");
        }
    }

    @Override
    public TransferSuccessResponse confirm(ConfirmOperation confirmOperation) {
        try {
            return new TransferSuccessResponse(confirmOperation.getOperationId());
        } catch (InvalidPaymentException ex) {
            throw new InvalidPaymentException("Error customer message!");
        }
    }
}
