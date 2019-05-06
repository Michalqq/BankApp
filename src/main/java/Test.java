import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        Client firstClient = new Client("Adam");
        Client secondClient = new Client("Michal");
        Account account1 = new Account(new BigDecimal(1000),0, firstClient);
        Account account2 = new Account(new BigDecimal(1000),0, secondClient);
        Account account3 = new Account(new BigDecimal(2000),0);
        Account account4 = new Account(new BigDecimal(3000),0);
        firstClient.setAccount(account3);
        firstClient.setAccount(account4);
        System.out.println(firstClient.getAccountsCash());
        Admin HeadAdmin = new Admin();
        HeadAdmin.setName("adam");
        HeadAdmin.changeAccountOwner(account4,secondClient);
        System.out.println(firstClient.getAccountsCash());
        System.out.println(account4.getOwner().getName());
        System.out.println(secondClient.getAccountsCash());
    }
}
