class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }

    public void merge(int l, int m, int r, int[] arr){
        ArrayList<Integer> temp = new ArrayList<>();
        
        int i = l;
        int j = m + 1;

        while(i <= m && j <= r){
            if(arr[i] <= arr[j]){
                temp.add(arr[i++]);
            } else{
                temp.add(arr[j++]);
            }
        }

        while(i <= m){
            temp.add(arr[i++]);
        }

        while(j <= r){
            temp.add(arr[j++]);
        }

        for(int h = l; h <= r; h++){
            arr[h] = temp.get(h - l);
        }

    }

    public void mergeSort(int l, int r, int[] arr){
        if(l >= r) return;

        int m = (l + r)/2;

        mergeSort(l, m, arr);
        mergeSort(m + 1, r, arr);
        merge(l, m, r, arr);
    }
}