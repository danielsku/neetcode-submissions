class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[] = new int[26];
        for(char task : tasks) count[task - 'A']++;

        Arrays.sort(count);
        int maxf = count[25];
        int idle = (maxf - 1) * n;
        for(int i = 24; i >= 0; i--){
            idle -= Math.min(count[i], maxf - 1);
        }

        return Math.max(idle, 0) + tasks.length;

        // A _ _ _ A _ _ _ A
    }
}
