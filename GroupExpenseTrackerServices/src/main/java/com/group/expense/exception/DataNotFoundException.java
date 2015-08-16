package com.group.expense.exception;

public class DataNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 8142577744265473816L;

    public DataNotFoundException(String message) {
        super(message);
    }

}
