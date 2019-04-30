import java.math.BigDecimal;

public class Transfer {
    void transferMoney(Account accountFromTransfer, Account accountWhereTransfer, double money) {
        if (accountFromTransfer.getCash().compareTo(new BigDecimal(money)) > -1){
            accountFromTransfer.subtractMoney(money);
            accountWhereTransfer.addMoney(money);
            System.out.println("Transfered " + money + " from " + accountFromTransfer.getOwner().getName() + "'s account to " + accountWhereTransfer.getOwner().getName() + "'s account");
        } else {
            System.out.println("Can't transfer, Account has no enough money to transfer");}
    }
}
