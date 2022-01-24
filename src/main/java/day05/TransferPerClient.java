package day05;

import java.util.Objects;

public class TransferPerClient {

    private String clientId;

    private int sum;

    private int numberOfTransactions;

    public TransferPerClient(String clientId) {
        this.clientId = clientId;
    }

    public void increase(int amount) {
        sum += amount;
        numberOfTransactions++;
    }

    public void decrease(int amount) {
        increase(-amount);
    }

    public String getClientId() {
        return clientId;
    }

    public long getSum() {
        return sum;
    }

    public long getNumberOfTransactions() {
        return numberOfTransactions;
    }

    @Override
    public String toString() {
        return "TransferPerClient{" +
                "clientId='" + clientId + '\'' +
                ", sum=" + sum +
                ", numberOfTransactions=" + numberOfTransactions +
                '}';
    }
}
