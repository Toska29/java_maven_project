package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvnRepositoryImplTest {
    BvnRepository bvnRepository;
    @BeforeEach
    void setUp() {
        bvnRepository = new BvnRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("2133445567", customer);
        Bvn bvNumber = bvnRepository.save(bvn);

        assertEquals(bvn, bvNumber);
    }

    @Test
    void findBvn() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("2133445567", customer);
        bvnRepository.save(bvn);

        Bvn foundBvn = bvnRepository.findBvn(bvn.getId());
        assertEquals(bvn, foundBvn);
    }

    @Test
    void delete() {
    }
}