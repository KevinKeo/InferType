package exception;

import type.Type;

/**
 * Created by borsing on 29/11/17.
 */
public class UnificationException extends RuntimeException{
    public UnificationException(String message, Type t1, Type t2) {
        super("UnificationException "+message+" between"+ t1 +" and " + t2);
    }
}