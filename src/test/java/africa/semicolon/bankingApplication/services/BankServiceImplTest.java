package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceImplTest {
    BankService bankService;
    @BeforeEach
    void setUp() {
        bankService = new BankServiceImpl();
    }

    @AfterEach
    void tearDown() {
        bankService = null;
    }

    @Test
    void createBank() {
        //when
        String bankId = bankService.createBank("GTCO");
        //assert
        assertEquals("01", bankId);
    }

    @Test
    void createTwoBanks_secondBankId_willBe02() {
        //when
        String gTCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("FIRST bank");
        //assert
        assertEquals("01", gTCoId);
        assertEquals("02", firstBankId);

    }

    @Test
    void createTwoBanks_repositoryShouldHaveTwoBanks(){
        //when
        String gTCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("FIRST bank");
        //assert
        assertEquals("01", gTCoId);
        assertEquals("02", firstBankId);
        assertEquals(2, bankService.findAllBanks().size());
//        System.out.println(bankService.findAllBanks());
    }

    @Test
    void bankCanCreateAccountFirCustomers_test(){
        String gtCoId = bankService.createBank("GTCO");
        //when
        String accountNumber = bankService.createAccount("01", "John", "Doe");
        //assert
        assertEquals("0100000001", accountNumber);
    }

    @Test
    void createTwoAccountsInBank1_accNumberShouldBe02(){
        String gtCoId = bankService.createBank("GTCO");
        //when
        String johnAccountNumber = bankService.createAccount("01", "John", "Doe");
        String janeAccountNumber = bankService.createAccount("01", "Jane", "Doe");
        //assert
        assertEquals("0100000001", johnAccountNumber);
        assertEquals("0100000002", janeAccountNumber);
    }

    @Test
    void createTwoAccountsInTwoBanks(){
        //given
        String gTCoId = bankService.createBank("GTCO");
        String firstBank = bankService.createBank("FIRST bank");
        //when
        String johnGTCO_accountNumber = bankService.createAccount("01", "John", "Doe");
        String paulGTCO_accountNumber = bankService.createAccount("01", "Paul", "Sam");
        String millFirstBank_accountNumber = bankService.createAccount("02", "Mill", "Moore");
        String emmyFirstBank_accountNumber = bankService.createAccount("02", "Emmy", "Lexy");

        //assert
        assertEquals("0100000001", johnGTCO_accountNumber);
        assertEquals("0100000002", paulGTCO_accountNumber);
        assertEquals("0200000001", millFirstBank_accountNumber);
        assertEquals("0200000002", emmyFirstBank_accountNumber);
    }

}