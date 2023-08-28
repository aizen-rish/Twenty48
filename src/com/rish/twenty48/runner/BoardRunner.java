package com.rish.twenty48.runner;

import com.rish.twenty48.model.Board;
import com.rish.twenty48.model.BoardMove;

public class BoardRunner {

    public static void main(String[] args) {

        Board runner = new Board(4);

        runner.initBoard();
        runner.printBoard();

        for (int i = 0; i < 2; i++) {
            runner.slideAndMerge(BoardMove.UP);
            runner.printBoard();
        }

        runner.slideAndMerge(BoardMove.LEFT);
        runner.printBoard();
    }

}
