class MedianFinder {

    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> bigger;


    public MedianFinder() {
        smaller = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        bigger = new PriorityQueue<>();

        
    }
    
    public void addNum(int num) {
        if(bigger.size() == smaller.size()){
            bigger.offer(num);
        } else if (!bigger.isEmpty() && num > bigger.peek()){
            bigger.offer(num);
        } else {
            smaller.offer(num);
        }
        if (bigger.size() > smaller.size()){
            int curr = bigger.poll();
            smaller.offer(curr);
            
        } else if (smaller.size() > bigger.size()){
           int curr = smaller.poll();
            bigger.offer(curr);
        }
    }
    
    public double findMedian() {
        if(smaller.size() == bigger.size()) {
            return (smaller.peek() + bigger.peek())/2.0;
        } else if (bigger.size() > smaller.size()){
            return bigger.peek();
        } else {
            return smaller.peek();
        }
    }
}
