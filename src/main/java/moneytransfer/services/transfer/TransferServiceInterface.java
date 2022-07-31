package moneytransfer.services.transfer;

import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;

public interface TransferServiceInterface {
    TransferSuccessResponse transfer(Transfer transfer);
}
