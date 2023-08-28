package com.rish.twenty48.model;

import java.util.Arrays;
import java.util.Random;

import com.rish.twenty48.model.helper.SlideMoveHelper;

public class Board {

    public int[][] grid;

    public Board(int n) {
        this.grid = new int[n][n];
    }

    public void initBoard() {
        randomlyFill(2);
        randomlyFill(2);
    }

    private void randomlyFill(int element) {

        int n = grid.length;

        // TODO: check if whole board is occupied

        Random r = new Random();
        int i = r.nextInt(n);
        int j = r.nextInt(n);

        while (grid[i][j] != 0) {
            i = r.nextInt(n);
            j = r.nextInt(n);
        }

        grid[i][j] = element;
    }

    public void printBoard() {

        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println();
    }

    public void slideAndMerge(BoardMove moveType) {

        switch (moveType) {

        case UP:
        case DOWN:
            slideVertical(moveType);
            randomlyFill(2);
            return;

        case LEFT:
        case RIGHT:
            slideHorizontal(moveType);
            randomlyFill(2);
            return;

        default:
            throw new IllegalArgumentException("Unexpected value: " + moveType);
        }
    }

    private void slideVertical(BoardMove moveType) {

        if (moveType == BoardMove.DOWN) {

            for (int i = 0; i < grid.length; i++) {
                int[] arr = SlideMoveHelper.getColumn(grid, i);
                int[] ans = SlideMoveHelper.slideRight(arr);
                SlideMoveHelper.setColumn(grid, i, ans);
            }

            return;
        }

        for (int i = 0; i < grid.length; i++) {
            int[] arr = SlideMoveHelper.getColumn(grid, i);
            int[] ans = SlideMoveHelper.slideLeft(arr);
            SlideMoveHelper.setColumn(grid, i, ans);
        }
    }

    private void slideHorizontal(BoardMove moveType) {

        if (moveType == BoardMove.LEFT) {

            for (int i = 0; i < grid.length; i++) {
                int[] arr = grid[i];
                int[] ans = SlideMoveHelper.slideLeft(arr);
                grid[i] = ans;
            }

            return;
        }

        for (int i = 0; i < grid.length; i++) {
            int[] arr = grid[i];
            int[] ans = SlideMoveHelper.slideRight(arr);
            grid[i] = ans;
        }
    }

}
