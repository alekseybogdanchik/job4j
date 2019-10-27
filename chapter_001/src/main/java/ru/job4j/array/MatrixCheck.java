package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        int count = 0;
        int count2 = 0;

        for (int row = 0; row < board.length; row++) {
            if (board[row][row] == 'X') {
                for (int cell = 0; cell < board.length; cell++) {
                    if (board[row][cell] == 'X') {
                        count++;
                    }
                    if (board[cell][row] == 'X') {
                        count2++;
                    }
                }
                if (count == board.length) {
                    result = true;
                    break;
                } else if (count2 == board.length) {
                    result = true;
                    break;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}