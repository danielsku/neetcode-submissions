class Solution {
    char[][] board;
    String word;
    boolean exists;
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                visited = new boolean[board.length][board[i].length];
                backtrack(new StringBuilder(), i, j);
            }
        }
        return exists;
    }

    public void backtrack(StringBuilder curr, int i, int j){        
        if(curr.length() > word.length()) return;

        if(curr.length() == word.length()){
            exists |= word.equals(new String(curr));
        }

        // System.out.println(curr);
        if(i >= board.length || i < 0) return;
        if(j >= board[i].length || j < 0) return;
        if(visited[i][j]) return;


        
        curr.append(board[i][j]);
        visited[i][j] = true;
        backtrack(curr, i + 1, j);
        visited[i][j] = false;
        curr.deleteCharAt(curr.length() - 1);

        curr.append(board[i][j]);
        visited[i][j] = true;
        backtrack(curr, i - 1, j);
        visited[i][j] = false;
        curr.deleteCharAt(curr.length() - 1);

        curr.append(board[i][j]);
        visited[i][j] = true;
        backtrack(curr, i, j + 1);
        visited[i][j] = false;
        curr.deleteCharAt(curr.length() - 1);

        curr.append(board[i][j]);
        visited[i][j] = true;
        backtrack(curr, i, j - 1);
        visited[i][j] = false;
        curr.deleteCharAt(curr.length() - 1);
        
    } 
}
