class Solution {
    int cache[];

    public int tribonacci(int n){
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return dp(n, n);
    }

    public int dp(int i, int n) {
        
        if(i <= 2) return i == 0 ? 0 : 1;

        if(cache[i] != -1) return cache[i];
        return cache[i] = dp(i - 1, n) + dp(i - 2, n) + dp(i - 3, n);
    }


}