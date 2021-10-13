package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.repositories.CustomerRepository;
import africa.semicolon.bankingApplication.data.repositories.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public String createAccount(String firstName, String lastName) {
        return null;
    }

    @Override
    public String createAccount(String firstName, String lastName, String bvn) {
        return null;
    }
}
