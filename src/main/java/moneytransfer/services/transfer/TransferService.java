package moneytransfer.services.transfer;

import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;
import moneytransfer.services.logger.LoggerServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class TransferService implements TransferServiceInterface {
    private LoggerServiceInterface loggerService;

    public TransferService(LoggerServiceInterface loggerService) {
        this.loggerService = loggerService;
    }

    public TransferSuccessResponse transfer(Transfer transfer) {
        return new TransferSuccessResponse(loggerService.log(transfer));
    }
}
