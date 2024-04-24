package com.siddharth.tictactoe.Exception;


public class InvalidGameException extends RuntimeException{
    public InvalidGameException(String message) {
        super(message);
    }
}