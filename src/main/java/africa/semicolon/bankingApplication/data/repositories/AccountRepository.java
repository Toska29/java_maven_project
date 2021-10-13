package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.Customer;

import java.util.List;

public interface AccountRepository {
    Account save(Account account);
    Account findAccountByCustomerId(String id);
    void delete(Account account);
    void delete(String customerId);
    List<Account> findAll();
}
