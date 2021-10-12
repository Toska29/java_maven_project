package africa.semicolon.bankingApplication.data.models;
//import lombok.Setter;
import lombok.*;

import java.math.BigDecimal;

@Data
public class Account {
    private String customerId;
    private final BigDecimal balance = BigDecimal.ZERO;
    private String number;
    private AccountType type;
}
