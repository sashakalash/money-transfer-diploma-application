package moneytransfer.repository;

import moneytransfer.models.Log;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Repository
public class LogRepository implements RepositoryInterface {
    private final ConcurrentLinkedQueue<Log> logStore = new ConcurrentLinkedQueue<>();

    public void save(Log log) {
        this.logStore.add(log);
    }

    public List<Log> getLogs() {
        return Collections.unmodifiableList(Arrays.asList(logStore.toArray(new Log[0])));
    }

    public ConcurrentLinkedQueue<Log> getLogStore() {
        return logStore;
    }
}
