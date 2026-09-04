class Solution {
    private int ROWS, COLS;
    private char[][] board;
    public void solve(char[][] board) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for(int r = 0; r < ROWS; r++){
            if(board[r][0] == 'O'){
                capture(r, 0);
            }
            if(board[r][COLS - 1] == 'O'){
                capture(r, COLS - 1);
            }
        }

        for(int c = 0; c < COLS; c++){
            if(board[0][c] == 'O'){
                capture(0, c);
            }
            if(board[ROWS - 1][c] == 'O'){
                capture(ROWS - 1, c);
            }
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    public void capture(int i, int j){
        if( i < 0 || j < 0 || i >= ROWS || j >= COLS 
        || board[i][j] == 'X' || board[i][j] == 'T') return;
        if(board[i][j] == 'O') board[i][j] = 'T';

        capture(i + 1, j);
        capture(i - 1, j);
        capture(i, j + 1);
        capture(i, j - 1);
    }
}
