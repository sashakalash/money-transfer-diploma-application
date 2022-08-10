package moneytransfer.controller;

import moneytransfer.models.ConfirmOperation;
import moneytransfer.models.Log;
import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;
import moneytransfer.models.exceptions.BadRequestException;
import moneytransfer.services.logger.LoggerService;
import moneytransfer.services.transfer.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin()
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
    public TransferSuccessResponse confirm(@RequestBody ConfirmOperation body) {
        return transService.confirm(body);
    }

    @RequestMapping(value="/logs")
    public List<Log> getLogList() {
        return logService.getLogsList();
    }

    @RequestMapping(value="*")
    public String getAbsensePath() {
        return "Oops! Something's gone wrong!";
    }
}
