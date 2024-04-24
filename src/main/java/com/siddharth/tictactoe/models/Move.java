package com.siddharth.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
@Getter
@Setter
public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }
}
