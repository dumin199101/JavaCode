package com.goosuu.code11;

/**
 *  自定义异常
 *
 */
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
