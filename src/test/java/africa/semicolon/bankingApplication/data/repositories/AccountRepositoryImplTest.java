package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.AccountType;
import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
    AccountRepository accountRepository;
    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = new Customer();
        Account account = new Account();
        Bvn bvn = new Bvn("311889901", customer);
        customer.setBvn(bvn.getId());
        account.setNumber("1130231448");
        account.setType(AccountType.SAVINGS);
        account.setCustomerId(customer.getBvn());

        Account savedAccount  = accountRepository.save(account);
        assertEquals(account, savedAccount);
    }

    @Test
    void findAccountByCustomerId() {
        Customer customer = new Customer();
        Account account = new Account();
        Bvn bvn = new Bvn("311889901", customer);
        customer.setBvn(bvn.getId());
        account.setNumber("1130231448");
        account.setType(AccountType.SAVINGS);
        account.setCustomerId(customer.getBvn());
        accountRepository.save(account);

        Account foundAccount = accountRepository.findAccountByCustomerId(customer.getBvn());
        assertEquals(account, foundAccount);
    }

    @Test
    void delete() {
        Customer customer = new Customer();
        Account account = new Account();
        Bvn bvn = new Bvn("311889901", customer);
        customer.setBvn(bvn.getId());
        account.setNumber("1130231448");
        account.setType(AccountType.SAVINGS);
        account.setCustomerId(customer.getBvn());
        Account savedAccount = accountRepository.save(account);

        accountRepository.delete(savedAccount);

        assertNull(accountRepository.findAccountByCustomerId(savedAccount.getCustomerId()));
    }

    @Test
    void testDelete() {
        Customer customer = new Customer();
        Account account = new Account();
        Bvn bvn = new Bvn("311889901", customer);
        customer.setBvn(bvn.getId());
        account.setNumber("1130231448");
        account.setType(AccountType.SAVINGS);
        account.setCustomerId(customer.getBvn());
        accountRepository.save(account);

        accountRepository.delete(account.getCustomerId());

        assertNull(accountRepository.findAccountByCustomerId(account.getCustomerId()));
    }

    @Test
    void findAll() {
        Customer customer = new Customer();
        Account account = new Account();
        Bvn bvn = new Bvn("311889901", customer);
        customer.setBvn(bvn.getId());
        account.setNumber("1130231448");
        account.setType(AccountType.SAVINGS);
        account.setCustomerId(customer.getBvn());
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);

        assertEquals(3, accountRepository.findAll().size());
    }
}