class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int r[] = new int[n];
        r[0] = 1;
        r[1] = 2;

        for(int i = 2; i < n; i++){        
            r[i] = r[i - 1] + r[i - 2];
        }

        return r[n - 1];

    }
}
