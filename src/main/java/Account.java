import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class Account extends Transfer {
    @Setter
    private BigDecimal cash;
    private int interest;
    private Client owner;


    public Account(BigDecimal cash, int interest) {
        this.cash = cash;
        this.interest = interest;
    }

    public Account(BigDecimal cash, int interest, Client owner) {
        this(cash, interest);
        owner.setAccount(this);
    }

    public void addMoney(double money) {
        setCash(cash.add(new BigDecimal(money)));
    }

    public void subtractMoney(double money) {
        setCash(cash.subtract(new BigDecimal(money)));
    }

    public BigDecimal getCash() {
        return cash.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setOwner(Client owner) {
        if (this.owner == null) {
            this.owner = owner;
        } else {
            System.out.println("This account has owner already. Only admin can change owner");
        }
    }
    public void setOwner(Client client, Admin admin){
        this.getOwner().getAccounts().remove(this);
        this.owner = null;
        client.setAccount(this);
        System.out.println("Admin " + admin.getName() + " changed account's owner");
    }
}
