package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Account;

public interface CustomerService {
    Account createAccount(String firstName, String lastName);

    Account createAccount(String firstName, String lastName, String bvn);
}
