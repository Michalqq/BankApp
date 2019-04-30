import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.acl.Owner;

@Data
public class Admin extends Account{
    private String name;
    private Account account;
}
