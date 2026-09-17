class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int size = beginWord.length();

        HashMap<String, List<String>> adj = new HashMap<>();

        // List of Words
        for(String a : wordList){
            for(String b : wordList){
                if(compStr(a, b, size, 1)){ 
                    adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                    adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
                }
            }
        }

        // beginWord
        for(String a : wordList){
            if(compStr(beginWord, a, size, 1)){
                adj.computeIfAbsent(a, k -> new ArrayList<>()).add(beginWord);
                adj.computeIfAbsent(beginWord, k -> new ArrayList<>()).add(a);
            }
        }

        ArrayDeque<String> q = new ArrayDeque<>();
        HashMap<String, Integer> visitMap = new HashMap<>();

        q.add(beginWord);
        visitMap.put(beginWord, 1);

        while(!q.isEmpty()){
            String node = q.poll();

            if(adj.get(node) == null) continue;

            for(String nei : adj.get(node)){
                if(visitMap.containsKey(nei)) continue;

                if(compStr(nei, endWord, size, 0)) 
                    return visitMap.get(node) + 1;

                visitMap.put(nei, visitMap.get(node) + 1);
                q.add(nei);
            }
        }

        return 0;
    }

    private boolean compStr(String a, String b, int size, int d){
        int diff = 0;
        for(int i = 0; i < size; i++){
            if(a.charAt(i) != b.charAt(i)) {
                if(++diff > d) return false;
            }
        }

        return diff == d;
    }

}
