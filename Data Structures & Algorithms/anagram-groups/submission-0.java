class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> agms = new HashMap<>();

        for(String str : strs){
            String unsorted = str;
            char[] tosort = str.toCharArray();
            Arrays.sort(tosort);
            String s = new String(tosort);
            agms.computeIfAbsent(s, k -> new ArrayList<String>()).add(unsorted);
        }

        List<List<String>> solution = new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> entry : agms.entrySet()){
            solution.add(entry.getValue());
        }

        return solution;
    }
}
