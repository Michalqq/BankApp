import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Client {
    private String name;
    private final int userId;
    private static final AtomicInteger count = new AtomicInteger(0);
    private List<Account> accounts = new ArrayList<Account>();

    public Client(String name) {
        this.name = name;
        this.userId = count.incrementAndGet();
    }

    public Client(String name, Account account){
        this(name);
        this.setAccount(account);
        accounts.add(account);
    }

    public void addMoney(double money, Account account) {
        if (account.getOwner() == this) {
            account.addMoney(money);
        } else {
            System.out.println("This account isn't your");
        }
    }

    public void takeMoney(double money, Account account) {
        account.subtractMoney(money);
    }

    public void setAccount(Account account) {
        if (account.getOwner() == null) {
            accounts.add(account);
            account.setOwner(this);
        } else {
            System.out.println("This account has owner already.");
        }
    }
    public void removeAccount(Account account){
        for (Account acc:accounts){
            if (acc.equals(account)){
                accounts.remove(account);
            }
        }
    }

    public String getAccountsCash() {
        StringBuilder text = new StringBuilder();
        for (Account acc:accounts){
            text.append(acc.getCash() + "   ");
        }
        return text.toString();
    }
}
