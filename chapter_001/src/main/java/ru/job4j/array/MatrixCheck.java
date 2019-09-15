package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        int count = 0;
        int count2 = 0;
        for (int row = 0; row < board.length; row++) {
            for (int cell = 0; cell < board.length; cell++) {
                char sign = board[row][cell];
                System.out.print(sign);
                //for () { проверить последовательность.
            }
            System.out.println();
        }

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
            }
        }

        if (count == 5) {
            result = true;
        } else if (count2 == 5) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }
}