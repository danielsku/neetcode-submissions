class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        long total = 0;
        for(int c : candies) {
            total += c;
            max = Math.max(max, c);
        }

        if(total < k) return 0;

        return bS(candies, k, 1, max);
    }

    private int bS(int[] candies, long k, int l, int r){
        if(r < l) return r;

        int mid = (l + r)/2;

        long dis = calc(candies, mid);

        if(dis >= k) return bS(candies, k, mid + 1, r);
        return bS(candies, k, l, mid - 1);
        
    }

    private long calc(int[] candies, int a){
        long n = 0;
        for(int c : candies) n += c/a;
        return n;
    }
}
