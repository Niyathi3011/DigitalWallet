package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transaction {

    private final String name;
    private final Type type;
    private final int amount;

    public enum Type {
        Credit, Debit
    }
}
