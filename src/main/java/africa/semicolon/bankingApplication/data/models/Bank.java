package africa.semicolon.bankingApplication.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {
    private final String id;
    private List<Account> accounts = new ArrayList<>();
    private String name;

//    public Bank(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
