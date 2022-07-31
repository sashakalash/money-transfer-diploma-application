package moneytransfer.controller;

import moneytransfer.models.Log;
import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;
import moneytransfer.services.logger.LoggerService;
import moneytransfer.services.transfer.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TranferController {
    private TransferService transService;
    private LoggerService logService;

    public TranferController(TransferService transService, LoggerService logService) {
        this.transService = transService;
        this.logService = logService;
    }

    @PostMapping(value="/transfer")
    public TransferSuccessResponse postTransfer(@RequestBody Transfer body) {
        return transService.transfer(body);
    }

    @PostMapping(value="/confirmOperation")
    public String confirm() {
        return "post";
    }

    @RequestMapping("/logs")
    public List<Log> getLogList() {
        return logService.getLogsList();
    }
}
