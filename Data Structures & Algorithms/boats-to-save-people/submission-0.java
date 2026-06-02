// Resolve again

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int max = Arrays.stream(people).max().getAsInt();

        int[] count = new int[max + 1];
        for(int person : people){
            count[person]++;
        }

        int idx = 0, i = 0;
        while(idx < people.length){
            while(count[i] == 0){
                i++;
            }

            people[idx++] = i;
            count[i]--;
        }

        int res = 0, l = 0, r = people.length - 1;

        while(l <= r){
            int remain = limit - people[r--];
            res++;
            if(l <= r && remain >= people[l]){
                l++;
            }
        }

        return res;
        
    }
}