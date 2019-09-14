package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = true;
        for (int row = 0; row < board.length; row++) {
            for (int cell = 0; cell < board.length; cell++) {
                char sign = board[row][cell];
                System.out.print(sign);
                //for () { проверить последовательность.
            }
            System.out.println();
        }
        for (int h = 0; h < board.length; h++) {
            if (result == true) {
                for (int v = 1; v < board.length; v++) {
                    if (board[h][0] == board[h][v]) {
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        boolean cycle2 = true;

        if (result == false) {
            for (int v = 0; v < board.length; v++) {
                if (cycle2 == true) {
                    for (int h = 1; h < board.length; h++) {
                        if (board[0][v] == board[h][v]) {
                            result = true;
                            cycle2 = true;
                        } else {
                            result = false;
                            cycle2 = false;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
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