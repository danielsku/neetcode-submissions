class Solution {
    private int[][] heights;
    private int ROWS, COLS;
    private boolean[][] atl, pac;

    private int[][] directions = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.ROWS = heights.length;
        this.COLS = heights[0].length;
        this.atl = new boolean[ROWS][COLS];
        this.pac = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pac);
            dfs(r, COLS - 1, atl);
        }

        for(int c = 0; c < COLS; c++){
            dfs(0, c, pac);
            dfs(ROWS - 1, c, atl);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(atl[i][j] && pac[i][j]) res.add(new ArrayList<>(List.of(i, j)));
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] ocean){
        ocean[i][j] = true;

        for(int[] d : directions){
            int x = d[0];
            int y = d[1];

            if(x + i < 0
            || y + j < 0 
            || x + i >= ROWS 
            || y + j >= COLS
            || ocean[x + i][y + j]) 
                continue;

            if(heights[i][j] <= heights[x + i][y + j]){
                dfs(x + i, y + j, ocean);
            }
        }

    }
}
