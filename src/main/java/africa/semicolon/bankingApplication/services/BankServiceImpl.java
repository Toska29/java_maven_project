package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.data.repositories.BankRepository;
import africa.semicolon.bankingApplication.data.repositories.BankRepositoryImpl;

import java.util.List;

public class BankServiceImpl implements BankService{
    private final BankRepository bankRepository = new BankRepositoryImpl();
    private static int lastAccountNumber;

    @Override
    public String createBank(String bankName) {
        String bankId = generateBankId();
        Bank bank = new Bank(bankId);
        bank.setName(bankName);
        Bank savedBank = bankRepository.save(bank);
        return savedBank.getId();
    }

    private String generateBankId(){
        int lastBankIdCreated = bankRepository.findAll().size();
        return String.format("%02d", ++lastBankIdCreated);
    }

    @Override
    public List<Bank> findAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public String createAccount(String bankId, String firstName, String lastName) {
        String accountSuffixNumber = generateSuffixFor(bankId);
        Account account = new Account();
        account.setNumber(bankId + accountSuffixNumber);
        Bank bank = bankRepository.findBankById(bankId);
        bank.getAccounts().add(account);
        bankRepository.save(bank);
        return account.getNumber();
    }

    private String generateSuffixFor(String bankId) {
        Bank bank = bankRepository.findBankById(bankId);
        int lastNumber = bank.getAccounts().size();
        String accountSuffix = String.format("%08d", ++lastNumber);
        return accountSuffix;
    }
}
