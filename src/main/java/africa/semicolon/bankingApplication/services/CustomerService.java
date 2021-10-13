package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Account;

public interface CustomerService {
   String createAccount(String firstName, String lastName);

   String createAccount(String firstName, String lastName, String bvn);
}
