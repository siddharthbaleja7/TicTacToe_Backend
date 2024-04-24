package com.siddharth.tictactoe.Exception;


public class InvalidGame extends RuntimeException{
    public InvalidGame(String message) {
        super(message);
    }
}