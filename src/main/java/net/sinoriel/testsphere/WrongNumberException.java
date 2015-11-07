package net.sinoriel.testsphere;

/**
 * Created by armandosanchezmedina on 06/11/2015.
 */
public class WrongNumberException extends Exception{
    public WrongNumberException(String message) {
        super(message);
    }
    public WrongNumberException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
