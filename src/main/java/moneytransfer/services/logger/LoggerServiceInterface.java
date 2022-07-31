package moneytransfer.services.logger;

import moneytransfer.models.Log;
import moneytransfer.models.Transfer;

import java.util.List;

public interface LoggerServiceInterface {
    String log(Transfer transfer);
    List<Log> getLogsList();
    Log createLog(Transfer transfer);
}
