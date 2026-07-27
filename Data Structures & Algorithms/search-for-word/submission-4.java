class Solution {
    private int ROWS, COLS;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        this.board = board;
        this.word = word;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(dfs(r, c, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int i){
        if(i == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS
        || board[r][c] != word.charAt(i) || board[r][c] == '#'){
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(r + 1, c, i + 1) 
                   || dfs(r - 1, c, i + 1) 
                   || dfs(r, c + 1, i + 1) 
                   || dfs(r, c - 1, i + 1);

        board[r][c] = word.charAt(i);
        return res;
    }
}
