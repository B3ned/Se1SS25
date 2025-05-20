package org.hbrs.se1.ss25.uebung03;

import java.io.FileNotFoundException;

public class CardboxStorageException extends Exception {
    public CardboxStorageException(String message, Throwable cause) {
        super(message,cause);
    }
    public CardboxStorageException(String message) {
        super(message);
    }

}
