package com.siddharth.tictactoe.models;

import com.siddharth.tictactoe.enums.PlayerType;

import java.util.List;

public class Board {
    private List<List<Cell>> cells;
    private int size;
    private Player player;
}
