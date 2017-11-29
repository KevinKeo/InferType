package exception;

import type.Type;

import java.util.List;

/**
 * Created by borsing on 29/11/17.
 */
public class UnificationException extends RuntimeException{
    public UnificationException(String message, Type t1, Type t2) {
        super("UnificationException "+message+" between"+ t1 +" and " + t2);
    }

    public UnificationException(String message, List<Type> t1, List<Type> t2) {
        super("UnificationException "+message+" between"+ t1 +" and " + t2);
    }


}