import lombok.Data;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Client {
    private String name;
    private final int userId;
    private static final AtomicInteger count = new AtomicInteger(0);
    private Account account;

    public Client(String name) {
        this.name = name;
        this.userId = count.incrementAndGet();
    }

    public Client(String name, Account account){
        this(name);
        this.setAccount(account);
    }

    public void setAccount(Account account) {
        if (account.getOwner() == null) {
            this.account = account;
            account.setOwner(this);
        } else {
            System.out.println("This account has owner already.");
        }
    }
}
