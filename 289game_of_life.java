class Solution {
    public void gameOfLife(int[][] board) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                int alive = 0;
                if (-1 < y - 1) {
                    alive += CountSideAlive(x, y-1, board);
                    if (board[y-1][x] > 0) alive ++;
                }
                if (y + 1 < board.length) {
                    alive += CountSideAlive(x, y+1, board);
                    if (board[y+1][x] > 0) alive ++;
                }
                alive += CountSideAlive(x, y, board);
                if (board[y][x] == 1) {
                    if (alive < 2 || alive > 3) {
                        board[y][x] = 2;
                    }
                } else if (board[y][x] == 0) {
                    if (alive == 3) board[y][x] = -1;
                }
            }
        }
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == 2) board[y][x] = 0;
                if (board[y][x] == -1) board[y][x] = 1;
            }
        }
    }
    
    private int CountSideAlive(int x, int y, int[][] board) {
        int alive = 0;
        if (-1 < x - 1 && board[y][x-1] > 0) {
            alive ++;
        }
        if (x + 1 < board[y].length && board[y][x+1] > 0) {
            alive ++;
        }
        return alive;
    }
}
