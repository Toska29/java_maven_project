package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankRepositoryImpl implements BankRepository {
    private List<Bank> banks = new ArrayList<>();
    @Override
    public Bank save(Bank bank) {
        banks.add(bank);
        return bank;
    }

    @Override
    public Bank findBankById(String id) {
        for (Bank bank: banks) {
            if (bank.getId().equalsIgnoreCase(id)){
                return bank;
            }
        }
        return null;
    }

    @Override
    public void delete(Bank bank) {
        banks.remove(bank);
    }

    @Override
    public void delete(String id) {
        banks.removeIf(bank -> bank.getId().equalsIgnoreCase(id));

    }

    @Override
    public List<Bank> findAll() {
        return banks;
    }
}
