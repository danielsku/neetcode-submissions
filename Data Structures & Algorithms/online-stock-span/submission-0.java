class StockSpanner {

    Deque<Integer> prices;

    public StockSpanner() {
        prices = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;

        Deque<Integer> copy = new ArrayDeque<>(prices);

        while(!copy.isEmpty() && copy.peek() <= price){
            copy.pop();
            span++;
        }

        prices.push(price);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */