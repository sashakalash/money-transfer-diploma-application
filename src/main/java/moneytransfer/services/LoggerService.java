package moneytransfer.services;

import moneytransfer.models.Log;
import moneytransfer.models.Transfer;
import moneytransfer.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggerService {
    private LogRepository logRepo;

    public LoggerService(LogRepository logRepo) {
        this.logRepo = logRepo;
    }

    public String log(Transfer transfer) {
        final var log = new Log(transfer);
        logRepo.save(log);
        return log.getId();
    }

    public List<Log> getLogsList() {
        return logRepo.getLogs();
    }
}
