import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        Client firstClient = new Client("Adam");
        Client secondClient = new Client("Michal");
        Account account1 = new Account(new BigDecimal(1000),0, firstClient);
        Account account2 = new Account(new BigDecimal(1000),0, secondClient);
        Account account3 = new Account(new BigDecimal(1000),0);
        Account account4 = new Account(new BigDecimal(1000),0);

        Client thirdClient = new Client("Anna", account3);

        account3.setOwner(firstClient);
        account4.setOwner(firstClient);

        System.out.println(account3.getOwner().getName());
        System.out.println(account4.getOwner().getName());

    }
}
