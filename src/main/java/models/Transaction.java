package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Transaction {

    private final String name;
    private final Type type;
    private final int amount;

    public enum Type {
        CREDIT, DEBIT
    }
}
