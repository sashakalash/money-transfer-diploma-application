package moneytransfer.repository;

import moneytransfer.models.Log;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface RepositoryInterface {
    void save(Log log);
    List<Log> getLogs();
    ConcurrentLinkedQueue<Log> getLogStore();
}
