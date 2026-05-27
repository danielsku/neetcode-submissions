class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Map<Row #, Map< #, freq>>
        Map<Integer, HashSet<Character>> column = new HashMap<>();

        // Map<Ceil((Row # + 1)/2) #, Map<Ceil((Column # + 1)/2), Map< #, freq>>>
        Map<Integer, HashMap<Integer, HashSet<Character>>> box = new HashMap<>();

        // i = row, j = column
        for(int i = 0; i<board.length; i++){
            Set<Character> row = new HashSet<>();
            for(int j = 0; j<board.length; j++){
                boolean isDot = board[i][j] == '.';

                // Row Check
                if(!isDot && row.contains(board[i][j])){
                    System.out.println("False because of row " + i + " and value " + board[i][j]);
                    return false;
                }
                row.add(board[i][j]);

                // Column Check
                if(!isDot && column.containsKey(j) && column.get(j).contains(board[i][j])){
                    System.out.println("False because of column " + j  + " and value " + board[i][j]);
                    return false;
                }
                column.computeIfAbsent(j, k -> new HashSet<Character>()).add(board[i][j]);

                // Box check
                int x = (int) Math.ceil((i+1.0)/3.0);
                int y = (int) Math.ceil((j+1.0)/3.0);
                System.out.println(" x : " + x + " y : " + y);

                if(!isDot && box.containsKey(x) && box.get(x).containsKey(y) && box.get(x).get(y).contains(board[i][j])){
                    System.out.println("False because of box " + x + ", " + y + " and value " + board[i][j]);
                    System.out.println(box);
                    return false;
                }
                box.computeIfAbsent(x, k -> new HashMap<Integer, HashSet<Character>>())
                    .computeIfAbsent(y, k -> new HashSet<Character>())
                    .add(board[i][j]);
            }
        }

        return true;
    }
}
