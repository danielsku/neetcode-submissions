// Resolve

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        int row = 0;

        while(l <= r){
            row = l + (r-l)/2; // implement different version if it overflows
            if(matrix[row][0] == target){
                return true;
            } else if(matrix[row][0] < target){
                l = row + 1;
            } else if(matrix[row][0] > target){
                r = row - 1;
            }
        }

        row = (l+r)/2;
        System.out.println(l);
        System.out.println(r);
        System.out.println(row);

        l = 0;
        r = matrix[row].length - 1; 
        
        while(l<=r){
            int m = l + (r-l)/2;
            if(matrix[row][m] == target){
                return true;
            } else if(matrix[row][m] < target){
                l = m + 1;
            } else if(matrix[row][m] > target){
                r = m - 1;
            }
        }
        return false;
    }
}
