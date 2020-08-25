package System;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.Wallet;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public final class DigitalWalletSystem {
    private final double MIN_AMOUNT = 0.00001;
    private final HashMap<Integer, Wallet> walletList = null;


}
