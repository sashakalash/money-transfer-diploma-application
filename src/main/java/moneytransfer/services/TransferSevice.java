package moneytransfer.services;

import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;
import org.springframework.stereotype.Service;

@Service
public class TransferSevice {
    private LoggerService loggerService;

    public TransferSevice(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public TransferSuccessResponse transfer(Transfer transfer) {
        return new TransferSuccessResponse(loggerService.log(transfer));
    }
}
