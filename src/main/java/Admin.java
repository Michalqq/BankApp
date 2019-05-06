import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.acl.Owner;

@Data
public class Admin{
    private String name;

    public void changeAccountOwner(Account account, Client owner) {
        account.setOwner(owner, this);
        //owner.setAccount(null);
    }
}
