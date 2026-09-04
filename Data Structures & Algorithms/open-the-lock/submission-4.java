class Solution {
    private String[] deadends;
    private String target;

    private ArrayDeque<String> q;

    public int openLock(String[] deadends, String target) {
        this.deadends = deadends;
        this.target = target;
        this.q = new ArrayDeque<>();
    
        HashMap<String, Integer> distances = new HashMap<>();
        for(String deadend : deadends){
            distances.put(deadend, -1);
        }

        if(distances.containsKey("0000")) return -1;

        distances.put("0000", 0);

        q.add("0000");
        
        int distance = -1;

        while(!q.isEmpty()){
            String n = q.poll();
            
            if(compare(n)) {
                distance = distances.get(n);
                break;
            }
            for(int i = 0; i < target.length(); i++){
                // Up
                StringBuilder comb = new StringBuilder(n);
                comb.setCharAt(i, (char)(Math.abs(comb.charAt(i) - '0' + 1) % 10 + '0'));                
                String newComb = new String(comb);
                if(!distances.containsKey(newComb)){
                    distances.put(newComb, distances.get(n) + 1);
                    q.add(newComb);
                }

                // Down
                comb = new StringBuilder(n);          
                comb.setCharAt(i, (char)(Math.abs(comb.charAt(i) - '0' - 1 + 10) % 10 + '0'));    
                newComb = new String(comb);
                if(!distances.containsKey(newComb)){
                    distances.put(newComb, distances.get(n) + 1);
                    q.add(newComb);
                }
            }
        }

        return distance;
    }

    private boolean compare(String comb){
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != comb.charAt(i)) return false;
        }

        return true;
    }
}