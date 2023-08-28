package com.rish.twenty48.model.helper;

import java.util.ArrayList;
import java.util.List;

public class SlideMoveHelper {

    public static int[] slideRight(int[] arr) {

        List<Integer> slid = new ArrayList<>();

        for (int e : arr) {
            if (e != 0) {
                slid.add(e);
            }
        }

        for (int i = slid.size() - 1; i > 0; i--) {
            if (slid.get(i) == slid.get(i - 1)) {
                slid.set(i, slid.get(i) * 2);
                slid.set(i - 1, 0);
                i--;
            }
        }

        slid = slid.stream().filter(e -> e != 0).toList();

        int[] ans = new int[arr.length];

        int j = slid.size() - 1;
        for (int i = ans.length - 1; i >= 0; i--) {

            if (j >= 0) {
                ans[i] = slid.get(j);
                j--;
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }

    public static int[] slideLeft(int[] arr) {

        List<Integer> slid = new ArrayList<>();

        for (int e : arr) {
            if (e != 0) {
                slid.add(e);
            }
        }

        for (int i = 0; i < slid.size() - 1; i++) {
            if (slid.get(i) == slid.get(i + 1)) {
                slid.set(i, slid.get(i) * 2);
                slid.set(i + 1, 0);
                i++;
            }
        }

        slid = slid.stream().filter(e -> e != 0).toList();

        int[] ans = new int[arr.length];

        int j = 0;
        for (int i = 0; i < ans.length; i++) {

            if (j < slid.size()) {
                ans[i] = slid.get(j);
                j++;
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }

    public static int[] getColumn(int[][] array, int index) {
        int len = array[0].length;
        int[] column = new int[len];
        for (int i = 0; i < len; i++) {
            column[i] = array[i][index];
        }
        return column;
    }

    public static void setColumn(int[][] array, int index, int[] input) {
        int len = array[0].length;
        for (int i = 0; i < len; i++) {
            array[i][index] = input[i];
        }
    }

}
