package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankRepositoryImplTest {
    BankRepository bankRepository;
    @BeforeEach
    void setUp() {
       bankRepository = new BankRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Bank bank = new Bank("001");
        bank.setName("first_bank");
        Bank savedBank = bankRepository.save(bank);

        assertEquals(bank, savedBank);
    }

    @Test
    void findBankById() {
        Bank bank = new Bank("001");
        bank.setName("first_bank");
        bankRepository.save(bank);

        Bank foundBank = bankRepository.findBankById("001");
        assertEquals(bank, foundBank);
    }

    @Test
    void delete() {
        Bank bank = new Bank("001");
        bank.setName("first_bank");
        bankRepository.save(bank);

        bankRepository.delete(bank);

        assertNull(bankRepository.findBankById("001"));
    }

    @Test
    void testDelete() {
        Bank bank = new Bank("001");
        bank.setName("first_bank");
        bankRepository.save(bank);

        bankRepository.delete("001");

        assertNull(bankRepository.findBankById("001"));

    }

    @Test
    void findAll() {
        Bank bank = new Bank("001");
        bank.setName("first_bank");
        bankRepository.save(bank);
        bankRepository.save(bank);
        bankRepository.save(bank);

        assertEquals(3, bankRepository.findAll().size());
    }
}