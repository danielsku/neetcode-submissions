// Majority in a Sorted Array
// Difficulty: EasyAccuracy: 55.2%Submissions: 19K+Points: 2
// Given a sorted array arr[] of size n, determine whether there is a majority element in the array or not. 
// An element is called a majority element if it appears more than n/2 times in the array.

class Solution {
    public boolean isMajority(int[] arr) {
        
        int candidate = arr.length/2; // Possible majority element
        
        int l = 0;
        int r = candidate;
        
        while(l <= r){
            int m = l + (r - l)/2;
            
            
            if(arr[m] >= arr[candidate]){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int min = l;
        
        l = candidate;
        r = arr.length - 1;
        
        while(l <= r){
            int m = l + (r - l)/2;
            
            if(arr[m] <= arr[candidate]){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int max = l - 1;
        return max - min + 1 > arr.length/2;
        
    }
}
