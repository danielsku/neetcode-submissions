class Solution {
    public int tribonacci(int n) {
        int r[] = new int[]{0, 1, 1};

        for(int i = 3; i <= n; i++){
            r[i % 3] = r[0] + r[1] + r[2];
        }

        return r[n % 3];
    }
}