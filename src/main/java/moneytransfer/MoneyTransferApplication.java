package moneytransfer;

import moneytransfer.controller.TranferController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoneyTransferApplication {
    public static void main(String[] args) {
        final var context = SpringApplication.run(MoneyTransferApplication.class, args);
        context.getBean(TranferController.class);
    }

}
