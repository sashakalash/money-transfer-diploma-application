package moneytransfer.controller;

import moneytransfer.models.Transfer;
import moneytransfer.models.TransferSuccessResponse;
import moneytransfer.services.TransferSevice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TranferController {
    private TransferSevice service;

    public TranferController(TransferSevice service) {
        this.service = service;
    }

    @PostMapping(value="/transfer")
    public TransferSuccessResponse postTransfer(@RequestBody Transfer body) {
        return service.transfer(body);
    }

    @PostMapping(value="/confirmOperation")
    public String confirm() {
        return "post";
    }
}
