package moneytransfer.services.logger;

import moneytransfer.models.Log;
import moneytransfer.models.Transfer;
import moneytransfer.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggerService implements LoggerServiceInterface {
    private LogRepository logRepo;
    private Log log;

    public LoggerService(LogRepository logRepo) {
        this.logRepo = logRepo;
    }

    public String log(Transfer transfer) {
        log = createLog(transfer);
        logRepo.save(log);
        return log.getId();
    }

    public List<Log> getLogsList() {
        return logRepo.getLogs();
    }

    public Log createLog(Transfer transfer) {
        return new Log(transfer);
    }
}
