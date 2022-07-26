package moneytransfer.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Log {
    private String id;
    private String date;
    private String time;
    private String cardFromNumber;
    private String cardToNumber;
    private long sum;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getCardFromNumber() {
        return cardFromNumber;
    }
    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }
    public String getCardToNumber() {
        return cardToNumber;
    }
    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }
    public long getSum() {
        return sum;
    }
    public void setSum(long sum) {
        this.sum = sum;
    }
    public String getId() {
        return id;
    }

    public Log(Transfer transfer) {
        final var dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyy");
        final var timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        final var currentDate = LocalDateTime.now();
        this.date = dateFormat.format(currentDate);
        this.time = timeFormat.format(currentDate);
        this.cardFromNumber = transfer.getCardFromNumber();
        this.cardToNumber = transfer.getCardToNumber();
        this.sum = transfer.getAmount().getValue();
        this.id = String.valueOf(new Random().nextLong());
    }
}
